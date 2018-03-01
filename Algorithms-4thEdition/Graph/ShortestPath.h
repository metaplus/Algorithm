#pragma once
#include "DirectGraph.h"
#include <set>
namespace graph
{
    template<typename Vertex>
    class dijkstra_shortest_path
    {
        digraph<Vertex>& digraph_;
        using graph_type = std::remove_reference_t<decltype(digraph_)>;
        using edge_type = typename graph_type::edge;
        using vertex_type = typename graph_type::vertex;
        std::vector<edge_type> edge_to_;
        //std::priority_queue<edge_type, std::vector<edge_type>, std::greater<>> min_heap_;
        using dist_to_source = decltype(std::declval<edge_type&>().weight());
        std::map<dist_to_source, vertex_type> dist_to_;    // use ordered container instead of minimum heap
    public:
        void relax(const vertex_type& from)
        {
            for(const auto& edge : digraph_.adjacency(from))
            {
                const auto& to = edge.to();
                if (dist_to_.at(digraph_.index(to)) <= dist_to_.at(digraph_.index(from)) + edge.weight()) continue;
                edge_to_.at(digraph_.index(to)) = edge;
                dist_to_.insert_or_assign(dist_to_.at(digraph_.index(from)) + edge.weight(), to);
            }
        }
        dijkstra_shortest_path(graph_type& gr, const vertex_type& vert)
            :digraph_(gr)
        {
            auto verts = digraph_.vertexes();

            auto edges = digraph_.edges();
        }
    };
}
