#pragma once
#include <memory>
#include <map>
#include <forward_list>
#include <vector>
#include <algorithm>
#include <numeric>
#include <functional>
#include <deque>

namespace graph
{
    template<typename Vertex, typename Allocator = std::allocator<Vertex>>
    struct digraph
    {
        std::map<Vertex, std::forward_list<Vertex, Allocator>> data;
        size_t count_vertex() const 
        {
//            std::vector<Vertex> result;
//            result.reserve(data.size());
//            std::generate_n(std::back_inserter(result), data.size(),
//                [iter = data.cbegin()]() mutable { return (iter++)->first; });
//            return result;
            return data.size();
        }
        size_t count_edge() const
        {
            using cref = typename decltype(data)::const_reference;
            return std::accumulate(data.cbegin(), data.cend(), 0, [](size_t sum, cref right) {
                return sum + std::distance(right.second.cbegin(), right.second.cend());
            });
        }
        void add_edge(Vertex from, Vertex to)
        {
            using adjacent_list = typename decltype(data)::mapped_type;
            if (!data.count(from))
                data.emplace(std::move(from), adjacent_list{ {std::move(to)},Allocator{} });
            else
                data.at(from).push_front(std::move(to));
        }
        const std::forward_list<Vertex, Allocator>& adjacency(const Vertex& vertex) const
        {
            return data.at(vertex);
        }
        digraph reverse() const
        {
            digraph reverse_digraph;
            for(const auto& pair : data)
            {
                const auto& from = pair.first;
                for (const auto& to : pair.second)
                    reverse_digraph.add_edge(to, from);
            }
            return reverse_digraph;
        }
        std::vector<Vertex> reachable(const std::vector<Vertex>& source) const
        {
            std::deque<bool> marked(data.size(), false);    // std::vector<bool>::value_type not compatible with std::exchange
            std::function<void(const Vertex&)> dfs;
            dfs = [&](const Vertex& vertex) 
            {
                const auto vertex_iter = data.find(vertex);
                const auto vertex_index = std::distance(data.cbegin(), vertex_iter);
                if (std::exchange(marked.at(vertex_index), true)) return;
                for (const auto& adjacent_vertex : vertex_iter->second)
                    dfs(adjacent_vertex);
            };
            for (const auto& vertex : source)
                dfs(vertex);
            std::vector<Vertex> result;
            typename decltype(marked)::const_iterator citer;
            while ((citer = std::find(citer, marked.cend(), true)) != marked.cend())
                result.push_back(std::next(data.cbegin(), std::distance(marked.cbegin(), citer++))->first);
            return result;
        }
    };
}