#pragma once
#include <memory>
#include <map>
#include <forward_list>
#include <vector>
#include <algorithm>
#include <numeric>
#include <functional>
#include <deque>
#include <stack>
#include <queue>
namespace graph
{
    template<typename Vertex>
    class digraph       //EdgeWeightedDirecrtedGraph
    {
    public:
        using vertex = Vertex;
        class edge
        {
            Vertex from_;
            Vertex to_;
            double weight_;
        public:
            edge(const Vertex& from, const Vertex& to, const double weight)
                : from_(from), to_(to), weight_(weight)
            {}
            edge() = default;
            const Vertex& from() const { return from_; }
            void from(const Vertex& v) { from_ = v; }
            const Vertex& to() const { return to_; }
            void to(const Vertex& v) { to_ = v; }
            const double& weight() const { return  weight_; }
            void weight(const double w) { weight_ = w; }
            bool operator<(const edge& r) const { return weight_ < r.weight_; }
            bool operator>(const edge& r) const { return r < *this; }
        };
    private:
        std::map<vertex, std::forward_list<edge>> data_;
        mutable std::unique_ptr<std::vector<vertex>> cycle_ = nullptr;
    public:
        size_t count_vertex() const 
        {
            return data_.size();
        }
        size_t count_edge() const
        {
            using cref = typename decltype(data_)::const_reference;
            return std::accumulate(data_.cbegin(), data_.cend(), size_t{ 0 }, [](size_t sum, cref right) {
                return sum + std::distance(right.second.cbegin(), right.second.cend());
            });             // std::forward_list without ::size() member function
        }
        void add_edge(vertex from, vertex to, double weight = 1)
        {
            using adjacent_list = typename decltype(data_)::mapped_type;
            if (!data_.count(from))
                data_.emplace(from, adjacent_list{ edge{from,std::move(to),std::move(weight)} });
            else
                data_.at(from).emplace_front(std::move(from), to, std::move(weight));
            if (!data_.count(to))
                data_.emplace(std::move(to), adjacent_list{});
        }
        void add_edge(const edge& e)
        {
            add_edge(e.from(), e.to(), e.weight());
        }
        const std::forward_list<edge>& adjacency(const vertex& vert) const
        {
            return data_.at(vert);
        }
        digraph reverse() const
        {
            digraph reverse_digraph;
            for(const auto& pair : data_)
            {
                for (const auto& edge : pair.second)
                    reverse_digraph.add_edge(edge.to(), edge.from(), edge.weight());
            }
            return reverse_digraph;
        }
        size_t index(const vertex& vert) const
        {
            return std::distance(data_.cbegin(), data_.find(vert));
        }
        std::vector<vertex> vertexes() const
        {
            std::vector<vertex> result; result.reserve(data_.size());
            std::generate_n(std::back_inserter(result), data_.size(),
                [iter = data_.cbegin()]() mutable { return iter++->first; });
            return result;
        }
        std::vector<edge> edges() const
        {
            std::vector<edge> result; result.reserve(data_.size() * 2);
            for (const auto& pair : data_)
                std::copy(pair.second.cbegin(), pair.second.cend(), std::back_inserter(result));
            return result;
        }
        std::vector<vertex> reachable(const std::vector<vertex>& source) const
        {
            std::deque<bool> marked(count_vertex(), false);    // std::vector<bool>::value_type not compatible with std::exchange
            std::function<void(const vertex&)> dfs;
            dfs = [&](const vertex& vert)
            {
                const auto vertex_citer = data_.find(vert);
                const auto vertex_index = std::distance(data_.cbegin(), vertex_citer);
                if (std::exchange(marked.at(vertex_index), true) || vertex_citer->second.empty()) return;
                for (const auto& adjacent_edge : vertex_citer->second)
                    dfs(adjacent_edge.to());
            };
            for (const auto& vertex : source)
                dfs(vertex);
            std::vector<vertex> result;
            auto citer = marked.cbegin();
            while ((citer = std::find(citer, marked.cend(), true)) != marked.cend())
                result.push_back(std::next(data_.cbegin(), std::distance(marked.cbegin(), citer++))->first);
            return result;
        }
        bool has_cycle() const
        {
            return cycle_ != nullptr;
        }
        std::vector<vertex> cycle() const       //DirectedCycle
        {
            std::deque<bool> marked(count_vertex(), false);
            std::deque<bool> on_tree(count_vertex(), false);
            std::function<void(const vertex&)> dfs;
            dfs=[&](const vertex& vert)
            {
                if (has_cycle()) return;
                const auto vertex_iter = data_.find(vert);
                const auto vertex_index = std::distance(data_.begin(), vertex_iter);
                const auto is_marked = std::exchange(marked.at(vertex_index), true);
                const auto is_on_tree = std::exchange(on_tree.at(vertex_index), true);
                if (is_marked)
                {
                    if (is_on_tree) cycle_ = std::make_unique<std::vector<vertex>>(1, vert);
                    return;
                }
                for (const auto& adjacent_edge : vertex_iter->second)
                    dfs(adjacent_edge.to());
                on_tree.at(vertex_index) = false;
                if (has_cycle()) cycle_->push_back(vert);
            };
            for (const auto& pair : data_)
                dfs(pair.first);
            if (!cycle_)
                return {};
            std::reverse(cycle_->begin(), cycle_->end());
            return *cycle_;
        }
        bool is_directed_acyclic_graph() const  // isDAG
        {
            cycle();
            return !has_cycle();
        }
        enum order { preorder, postorder, reverse_postorder };
        std::vector<vertex> order_vertex(const order dfs_order) const
        {
            std::queue<vertex> preorder_queue;
            std::queue<vertex> postorder_queue;
            std::stack<vertex> reverse_posorder_stack;
            std::deque<bool> marked(count_vertex(), false);
            std::function<void(const vertex&)> dfs;
            dfs=[&](const vertex& vert)
            {
                const auto vertex_iter = data_.find(vert);
                const auto vertex_index = std::distance(data_.begin(), vertex_iter);                
                if (std::exchange(marked.at(vertex_index), true)) return;
                preorder_queue.push(vert);
                for (const auto& adjacent_edge : vertex_iter->second)
                    dfs(adjacent_edge.to());
                postorder_queue.push(vert);
                reverse_posorder_stack.push(vert);
            };
            for (const auto& pair : data_)
                dfs(pair.first);
            std::vector<vertex> result; result.reserve(count_vertex());
            switch (dfs_order)
            {
            case preorder:
            {
                std::generate_n(std::back_inserter(result), preorder_queue.size(), [&] {
                    auto front = std::move(preorder_queue.front()); preorder_queue.pop();
                    return front;
                });
            }
            case postorder:
            {
                std::generate_n(std::back_inserter(result), postorder_queue.size(), [&] {
                    auto front = std::move(postorder_queue.front()); postorder_queue.pop();
                    return front;
                });
            }
            case reverse_postorder:
            {
                std::generate_n(std::back_inserter(result), reverse_posorder_stack.size(), [&] {
                    auto top = std::move(reverse_posorder_stack.top()); reverse_posorder_stack.pop();
                    return top;
                });
            }
            }
            return result;
        }
        std::vector<vertex> topological_sort()      //require DirectedAcyclicGraph
        {
            if (!is_directed_acyclic_graph()) throw std::logic_error{ "graph is not DAG, with cycle found" };
            const auto topological_order = order_vertex(reverse_postorder);
            return topological_order;
        }         
        bool is_strongly_connected(const vertex& vert0, const vertex& vert1) const  // KosarajuSCC
        {   
            const auto reverse_topological_order = reverse().topological_sort();
            std::deque<bool> marked(count_vertex(), false);
            std::vector<size_t> id(count_vertex(), 0);      // cast to bool gains false
            size_t count = 1;                               // count-1 := number of strong connected components
            std::function<void(const vertex&)> dfs;
            dfs = [&](const vertex& vert)
            {
                const auto vertex_iter = data_.find(vert);
                const auto vertex_index = std::distance(data_.cbegin(), vertex_iter);
                if (std::exchange(marked.at(vertex_index), true)) return;
                id.at(std::distance(data_.cbegin(), data_.find(vert))) = count;
                for (const auto& adjacent_edge : vertex_iter->second)
                    dfs(adjacent_edge.to());
            };
            for (const auto& vertex : reverse_topological_order)
            {
                if (marked.at(std::distance(data_.cbegin(), data_.find(vertex)))) continue;
                dfs(vertex); ++count;
            }
            const auto& id0 = id.at(std::distance(data_.cbegin(), data_.find(vert0)));
            const auto& id1 = id.at(std::distance(data_.cbegin(), data_.find(vert1)));
            return id0 && id1 && (id0 == id1);
        }
    };
}                                                                                                                                                                                                                        