// Algorithms-4thEdition.cpp : Defines the entry point for the console application.
//
#include "stdafx.h"
#include "Sorting/PriorityQueue.h"
#include "Sorting/QuickSort.h"
#include "Sorting/MergeSort.h"
#include "Sorting/ElementarySorts.h"
#include <random>
#include <tuple>

std::vector<int> make_random_integers(int min = -1000, int max = 1000)
{
    std::random_device generator;
    const auto vec_size = std::uniform_int_distribution<size_t>{ 300,800 }(generator);
    std::vector<int> result;
    result.reserve(vec_size);
    std::generate_n(std::back_inserter(result), vec_size,
        [&, dist = std::uniform_int_distribution<int>{ min,max }]{ return dist(generator); });
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
        sorting::quick_sort, sorting::quick_sort::three_way,
        sorting::heap_sort
    > sortings;
    auto is_sortable = verify_sortable<std::tuple_element_t<
        std::tuple_size_v<decltype(sortings)> - 1, decltype(sortings)>>();
    return 0;
}