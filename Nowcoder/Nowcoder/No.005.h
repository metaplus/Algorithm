#pragma once
#include <numeric>
#include <cassert>
#include <functional>
#include <vector>
#include <algorithm>
#include <iostream>

namespace nowcoder
{
    namespace solution005
    {
        size_t combination(size_t p, size_t n)
        {
            if (n == 1 || p == 0 || n == 0)
                return 1;
            size_t result = 1;
            for (size_t i = n - p + 1; i <= n; ++i)
            {
                result *= i;
            }
            for (size_t i = 1; i <= p; ++i)
            {
                result /= i;
            }
            return result;
        }
        void test()
        {
            const size_t modular = 1000000007;
            int sum_len;
            int a_len, a_count, b_len, b_count;
            while (std::cin >> sum_len)
            {
                size_t sum_method = 0;
                std::cin >> a_len >> a_count >> b_len >> b_count;
                for (int i = 0; i <= sum_len / a_len && i <= a_count; ++i)
                {
                    if (sum_len - a_len * i < 0 || (sum_len - a_len * i) % b_len != 0)
                        continue;
                    int j = (sum_len - a_len * i) / b_len;
                    if (j > b_count)
                        continue;
                    assert(i >= 0);
                    assert(j >= 0);
                    size_t a_comb = combination(i, a_count);
                    size_t b_comb = combination(j, b_count);
                    sum_method += (a_comb * b_comb);
                }
                std::cout << sum_method % modular << "\n";
            }
        }
    }
}