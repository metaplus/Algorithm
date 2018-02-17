// Algorithms-4thEdition.cpp : Defines the entry point for the console application.
//
#include "stdafx.h"
#include "Sorting/ElementarySorts.h"
std::vector<int> random_generate_integers(int min = -1000, int max = 1000)
{
    std::random_device generator;
    auto vec_size = std::uniform_int_distribution<size_t>{ 300,800 }(generator);
    std::vector<int> result;
    result.reserve(vec_size);
    std::generate_n(std::back_inserter(result), vec_size,
        [&, dist = std::uniform_int_distribution<int>{ min,max }]{ return dist(generator); });
    return result;
}
template<typename Algorithm>
bool verify_sortable()
{
    auto unsorted = random_generate_integers();
   
    Algorithm{}(unsorted.begin(), unsorted.end());
    return std::is_sorted(unsorted.begin(), unsorted.end());
}
int main()
{
    auto verify = verify_sortable<sorting::selection_sort>();
    return 0;
}

