// Apo0-yylgorithms-4thEdition.cpp : Defines the entry point for the console application.
//
#include "stdafx.h"
#include "Graph/DirectGraph.h"
#include "Searching/BalancedSearchTree.h"
#include "Searching/BinarySearchTree.h"
#include "Sorting/PriorityQueue.h"
#include "Sorting/QuickSort.h"
#include "Sorting/MergeSort.h"
#include "Sorting/ElementarySorts.h"
#include <random>
#include <tuple>
#include <map>
std::vector<int> make_random_integers(int low = -1000, int high = 1000)
{
    std::random_device generator;
    const auto vec_size = std::uniform_int_distribution<size_t>{ 300,800 }(generator);
    std::vector<int> result;
    result.reserve(vec_size);
    std::generate_n(std::back_inserter(result), vec_size,
        [&, dist = std::uniform_int_distribution<int>{ low,high }]{ return dist(generator); });
    return result;
}
template<typename Algorithm>
bool verify_sortable()
{
    auto unsorted = make_random_integers();
    Algorithm{}(unsorted.begin(), unsorted.end());
    return std::is_sorted(unsorted.begin(), unsorted.end());
}
int main()
{
    std::tuple<
        sorting::selection_sort, sorting::insertion_sort, sorting::shell_sort,
        sorting::merge_sort::top_down, sorting::merge_sort::bottom_up,
        sorting::quick_sort, sorting::quick_sort::three_way, sorting::heap_sort
    > sortings;
    auto is_sortable = verify_sortable<std::tuple_element_t<std::tuple_size_v<decltype(sortings)> -1, decltype(sortings)>>();
    graph::digraph<int> test_graph;
    auto t1 = test_graph.count_vertex();
    test_graph.add_edge(1, 2);
    auto t2 = test_graph.adjacency(3);
    auto t3 = test_graph.reverse();
    auto t4 = test_graph.reachable({ 1,2,3 });
    return 0;
}