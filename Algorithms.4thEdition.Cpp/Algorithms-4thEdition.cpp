// Apo0-yylgorithms-4thEdition.cpp : Defines the entry point for the console application.
//
#include "stdafx.h"
#include "String/DataCompression.h"
#include "String/RegularExpression.h"
#include "String/SubstringSearch.h"
#include "String/Trie.h"
#include "String/StringSort.h"
#include "Graph/ShortestPath.h"
#include "Graph/MinimumSpanningTree.h"
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
    std::vector<int> intvec; intvec.reserve(vec_size);
    std::generate_n(std::back_inserter(intvec), vec_size,
        [&, dist = std::uniform_int_distribution<int>{ low,high }]{ return dist(generator); });
    return intvec;
}
std::vector<std::string> make_random_strvec(size_t strlen_low = 100, size_t strlen_high = 100)
{
    std::random_device generator;
    const auto vec_size = std::uniform_int_distribution<size_t>{ 100,200 }(generator);
    std::vector<std::string> strvec; strvec.reserve(vec_size);
    std::generate_n(std::back_inserter(strvec), vec_size, [&] {
        const auto str_size = strlen_high != strlen_low ?
            std::uniform_int_distribution<size_t>{strlen_low, strlen_high}(generator) : strlen_low;
        std::string str; str.reserve(str_size);
        std::generate_n(std::back_inserter(str), str_size,  // [0, 127]  '\0'->0  '0'->48 
            [&, dist = std::uniform_int_distribution<short>{ 0,std::numeric_limits<char>::max() }]
            { return static_cast<char>(dist(generator)); });
        return str;
    });
    return strvec;
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
    graph::digraph<int> dig;
    graph::bellman_ford_shortest_path<int> bfsp{ dig,1 };
    auto strvec = make_random_strvec(50, 150);
    string::string_sort::three_way_quick_sort(strvec);
    string::knuth_morris_pratt kmp{ "123" };
    string::huffman_compression huff;
    return 0;
}