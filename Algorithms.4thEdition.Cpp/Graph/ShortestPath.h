#pragma once
#include "DirectGraph.h"
#include <set>
namespace graph
{
    // $1 create additional reversed directional edge for undirected graph
    // $2 stop searching once specified sink is dropped from priority queue
    template<typename Vertex>   // restriction: edge non-negative
    class dijkstra_shortest_path
    {
        digraph<Vertex>& digraph_;
        using graph_type = std::remove_reference_t<decltype(digraph_)>;
        using edge_type = typename graph_type::edge;
        using vertex_type = typename graph_type::vertex;
        using weight_type = std::decay_t<decltype(std::declval<edge_type&>().weight())>;
        const vertex_type source_;
        std::vector<edge_type> edge_to_;
        std::vector<weight_type> dist_to_;
        struct dist_to_source
        {                                                            
            std::reference_wrapper<const vertex_type> vertex;   // reference_wrapper<T> advance in DefaultConstructible unlike T&   
            weight_type dist_weight;
            dist_to_source() = default;
            bool operator>(const dist_to_source& right) const { return dist_weight > right.dist_weight; }
        };
        std::vector<dist_to_source> dist_min_heap_;  // manually make heap operation
    public:
        void relax(const vertex_type& from)
        {
            for(const auto& edge : digraph_.adjacency(from))
            {
                const auto& to = edge.to();
                if (dist_to_.at(digraph_.index(to)) <= dist_to_.at(digraph_.index(from)) + edge.weight()) continue;
                dist_to_.at(digraph_.index(to)) = dist_to_.at(digraph_.index(from)) + edge.weight();
                edge_to_.at(digraph_.index(to)) = edge;
                auto iter = std::find_if(dist_min_heap_.begin(), dist_min_heap_.end(),
                    [&](const dist_to_source& dist) { return dist.vertex == to; });
                if (iter != dist_min_heap_.end()) iter->dist_weight = edge.weight();
                else
                {
                    dist_min_heap_.push_back(dist_to_source{ to,edge.weight() });
                    std::push_heap(dist_min_heap_.begin(), dist_min_heap_.end(), std::greater<>{}); // min heap
                }
            }
        }
        dijkstra_shortest_path(graph_type& gr, const vertex_type& source)
            :digraph_(gr), source_(source)
        {
            const auto count_vertex = digraph_.count_vertex();
            edge_to_.resize(count_vertex);
            dist_to_.assign(count_vertex, std::numeric_limits<weight_type>::max());
            dist_to_.front() = 0;
            dist_min_heap_.push_back(dist_to_source{ source,0 });
            assert(dist_min_heap_.size() == 1);                     // no need to std::push_heap
            while (!dist_min_heap_.empty())
            {
                std::pop_heap(dist_min_heap_.begin(), dist_min_heap_.end(), std::greater<>{});
                const auto min_dist = std::move(dist_min_heap_.back()); dist_min_heap_.pop_back();
                relax(min_dist.vertex);
;           }
        }
        weight_type dist_to(const vertex_type& to) const
        {
            return dist_to_.at(digraph_.index(to));
        }
        bool has_path_to(const vertex_type& to) const
        {
            return dist_to(to) < std::numeric_limits<weight_type>::max();
        }
        std::vector<edge_type> path_to(const vertex_type& to) const
        {
            if (!has_path_to(to)) return {};
            std::vector<edge_type> paths; paths.reserve(edge_to_.size());
            std::reference_wrapper<const vertex_type> vert_ref = std::cref(to);
            do
            {
                const auto& edge = edge_to_.at(digraph_.index(vert_ref));
                paths.push_back(edge);
                vert_ref = std::cref(edge.from());  // wrapper rebind, not ::type assignment
            } while (vert_ref != source_);
            std::reverse(paths.begin(), paths.end());
            return paths;
        }
    };
    // $1 negate edge weight then shortest path stands for longest path for original digraph
    template<typename Vertex>   // edge weighted DAG shorted path
    class topological_acyclic_shortest_path
    {
        digraph<Vertex>& digraph_;
        using graph_type = std::remove_reference_t<decltype(digraph_)>;
        using edge_type = typename graph_type::edge;
        using vertex_type = typename graph_type::vertex;
        using weight_type = std::decay_t<decltype(std::declval<edge_type&>().weight())>;
        const vertex_type source_;
        std::vector<edge_type> edge_to_;
        std::vector<weight_type> dist_to_;
    public:
        void relax(const vertex_type& from)
        {
            for (const auto& edge : digraph_.adjacency(from))
            {
                const auto& to = edge.to();
                if (dist_to_.at(digraph_.index(to)) <= dist_to_.at(digraph_.index(from)) + edge.weight()) continue;
                dist_to_.at(digraph_.index(to)) = dist_to_.at(digraph_.index(from)) + edge.weight();
                edge_to_.at(digraph_.index(to)) = edge;
            }
        }
        topological_acyclic_shortest_path(graph_type& gr, const vertex_type& source)
            :digraph_(gr), source_(source)
        {
            const auto count_vertex = digraph_.count_vertex();
            edge_to_.resize(count_vertex);
            dist_to_.assign(count_vertex, std::numeric_limits<weight_type>::max());
            dist_to_.front() = 0;
            for (const auto& vertex : digraph_.topological_sort())
                relax(vertex);
        }
    };
    template<typename Vertex>   // restriction: no negative cycle
    class bellman_ford_shortest_path
    {
        digraph<Vertex>& digraph_;
        using graph_type = std::remove_reference_t<decltype(digraph_)>;
        using edge_type = typename graph_type::edge;
        using vertex_type = typename graph_type::vertex;
        using weight_type = std::decay_t<decltype(std::declval<edge_type&>().weight())>;
        const vertex_type source_;
        std::vector<edge_type> edge_to_;
        std::vector<weight_type> dist_to_;
        mutable std::unique_ptr<std::vector<vertex_type>> cycle_;
        std::queue<vertex_type> queue_;
        std::deque<bool> on_queue_;
        size_t cost_;
    public:
        bool has_negative_cycle() const
        {
            return cycle_ != nullptr;
        }
        std::vector<edge_type> negative_cycle() const
        {
            return *cycle_;
        }
        void find_negative_cycle() const
        {
            graph_type partial_digraph;
            for (size_t i = 0; i != dist_to_.size(); ++i)
            {
                if (dist_to_.at(i) < std::numeric_limits<weight_type>::max())
                    partial_digraph.add_edge(edge_to_.at(i));
            }
            cycle_ = std::make_unique<std::vector<vertex_type>>(partial_digraph.cycle());
        }
        void relax(const vertex_type& from)
        {
            for (const auto& edge : digraph_.adjacency(from))
            {
                const auto& to = edge.to();
                if (dist_to_.at(digraph_.index(to)) <= dist_to_.at(digraph_.index(from)) + edge.weight()) continue;
                dist_to_.at(digraph_.index(to)) = dist_to_.at(digraph_.index(from)) + edge.weight();
                edge_to_.at(digraph_.index(to)) = edge;
                if (!std::exchange(on_queue_.at(digraph_.index(to)), true))
                    queue_.push(to); 
                if (cost_++ % digraph_.count_vertex() == 0)
                    find_negative_cycle();
            }
        }
        bellman_ford_shortest_path(graph_type& gr, const vertex_type& source)
            :digraph_(gr), source_(source)
        {
            const auto count_vertex = digraph_.count_vertex();
            edge_to_.resize(count_vertex);
            dist_to_.assign(count_vertex, std::numeric_limits<weight_type>::max());
            dist_to_.front() = 0;
            on_queue_.assign(count_vertex, false);
            queue_.push(source_);
            on_queue_.at(digraph_.index(source)) = true;
            while (!queue_.empty() && !has_negative_cycle())
            {
                const auto front_vertex = std::move(queue_.front()); queue_.pop();
                on_queue_.at(digraph_.index(front_vertex)) = false;
                relax(front_vertex);
            }
        }
    };
}
