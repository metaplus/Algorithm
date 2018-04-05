#pragma once
#include <numeric>
#include <cassert>
#include <functional>
#include <vector>
#include <algorithm>
#include <iostream>

namespace nowcoder
{
    namespace solution004
    {

        void test()
        {
            size_t n, m;
            std::cin >> n >> m;
            int64_t sum = 0;
            sum = m * m*(n / 2 / m);
            std::cout << sum << "\n";
        }
    }
}