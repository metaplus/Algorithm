#pragma once
#include "DirectGraph.h"
#include <set>
namespace graph
{
    template<typename Vertex>
    class graph       //EdgeWeightedDirecrtedGraph
    {
    public:
        using vertex = Vertex;
        class edge
        {
            Vertex either_;
            Vertex other_;
            double weight_;
        public:
            edge() = default;
            edge(const Vertex& either, const Vertex& other, const double weight = 1)
                : either_(either), other_(other), weight_(weight)
            {}
            Vertex either() const { return either_; }
            Vertex other() const { return other_; }
            Vertex other(const Vertex& v) const { return either_ != v ? either_ : other_; }
            std::pair<Vertex,Vertex> order_pair() const
            {
                return either_ > other_ ?
                    std::make_pair(other_, either_) : std::make_pair(either_, other_);
            }
            double weight() const { return weight_; }
            bool operator>(const edge& right) { return weight_ > right.weight_; }   
            //friend bool operator>(const edge& left, const edge& right) { return left.weight_ < right.weight_; }
        };
    private:
        std::map<vertex, std::forward_list<edge>> data_;
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
            }) / 2;     // half
        }
        void add_edge(vertex either, vertex other, int weight = 1)
        {
            using adjacent_list = typename decltype(data_)::mapped_type;
            if (!data_.count(either))
                data_.emplace(either, adjacent_list{ edge{ either,other,weight } });
            else
                data_.at(either).emplace_front(either, other, weight);
            if (!data_.count(other))
                data_.emplace(other, adjacent_list{ edge{ either,other,weight } });
            else
                data_.at(other).emplace_front(either, other, weight);
        }
        const std::forward_list<edge>& adjacency_list(const vertex& vert) const
        {
            return data_.at(vert);
        }
        size_t index(const vertex& vert) const
        {
            return std::distance(data_.cbegin(), data_.find(vert));
        }
        std::vector<edge> prim_mst_lazy() const
        {
            std::priority_queue<edge, std::vector<edge>, std::greater<>> min_heap;
            std::deque<bool> marked(count_vertex(), false);
            std::function<void(const vertex&)> visit;
            std::vector<edge> mst;
            visit=[&](const vertex& vert)
            {
                if (std::exchange(marked.at(index(vert)), true)) return;
                for (const auto& edge : adjacency_list(vert))
                    if (!marked.at(edge.other(vert))) min_heap.push(edge);
            };
            visit(data_.cbegin()->first);
            while (!min_heap.empty())
            {
                auto min_edge = std::move(min_heap.top()); min_heap.pop();
                const size_t index_either = index(min_edge.either());
                const size_t index_other = index(min_edge.other());
                if (marked.at(index_either) && marked.at(index_other)) continue;
                mst.push_back(min_edge);
                if (!marked.at(index_either)) visit(min_edge.either());
                if (!marked.at(index_other)) visit(min_edge.other());
            }
            return mst;
        }
        std::vector<edge> prim_mst_eager() const    //TODO affirm
        {
            std::priority_queue<edge, std::vector<edge>, std::greater<>> min_heap;
            std::deque<bool> marked(count_vertex(), false);
            std::vector<double> dist_to(count_edge(), std::numeric_limits<double>::max());
            dist_to.at(0) = 0;
            std::function<void(const vertex&)> visit;
            std::vector<edge> mst;
            visit = [&](const vertex& vert)
            {
                if (std::exchange(marked.at(index(vert)), true)) return;
                for (const auto& edge : adjacency_list(vert))
                {
                    const auto& other = edge.other(vert);
                    if (marked.at(other)) continue;
                    if (dist_to.at(index(other)) <= edge.weight()) continue;
                    dist_to.at(index(other)) = edge.weight();
                    min_heap.push(edge);
                }
            };
            visit(data_.cbegin()->first);
            while (!min_heap.empty())
            {
                auto min_edge = std::move(min_heap.top()); min_heap.pop();
                mst.push_back(min_edge);
                if (!marked.at(index(min_edge.either()))) visit(min_edge.either());
                if (!marked.at(index(min_edge.other()))) visit(min_edge.other());
            }
            return mst;
        }
        std::vector<edge> edges() const
        {
            auto edge_less = [](const edge& l, const edge& r)
            {
                return l.order_pair() < r.order_pair();
            };
            std::set<edge, decltype(edge_less)> edge_set(edge_less);
            for(const auto& pair : data_)
                edge_set.insert(pair.second.cbegin(), pair.second.cend());
            std::vector<edge> result; result.reserve(edge_set.size());
            std::generate_n(std::back_inserter(result), edge_set.size(),
                [iter = edge_set.begin()]() mutable { return std::move(*iter++); });
            return result;
        }
        std::vector<edge> kruskal_mst() const
        {
            auto union_edges = edges();
            std::priority_queue<edge, std::vector<edge>, std::greater<>> 
                min_heap{ std::make_move_iterator(union_edges.begin()), std::make_move_iterator(union_edges.end()) };
            //std::deque<bool> marked(count_vertex(), false);       // another option
            std::vector<edge> mst;
            while (!min_heap.empty() && mst.size() < count_vertex() - 1)
            {
                auto min_edge = std::move(min_heap.top()); min_heap.pop();
                if (std::any_of(mst.cbegin(), mst.cend(), [&, lfind = false, rfind = false](const edge& e) mutable
                {
                    lfind = lfind || (e.either() == min_edge.either() || e.other() == min_edge.either());
                    rfind = rfind || (e.either() == min_edge.other() || e.other() == min_edge.other());
                    return lfind && rfind;
                })) continue;
                mst.push_back(std::move(min_edge));
            }
            return mst;
        }
    };
}