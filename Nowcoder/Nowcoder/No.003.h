#pragma once
#include <numeric>
#include <cassert>
#include <functional>

/*
小Q今天在上厕所时想到了这个问题：有n个数，两两组成二元组，差最小的有多少对呢？差最大呢？


输入描述:

 输入包含多组测试数据。

 对于每组测试数据：

 N - 本组测试数据有n个数

 a1,a2...an - 需要计算的数据

 保证:

 1<=N<=100000,0<=ai<=INT_MAX.




输出描述:

对于每组数据，输出两个数，第一个数表示差最小的对数，第二个数表示差最大的对数。

示例1
输入
6
45 12 45 32 5 6
输出
1 2
 */

#include <numeric>
#include <cassert>
#include <functional>
#include <vector>
#include <algorithm>
#include <iostream>
namespace nowcoder
{
    struct solution003
    {
        size_t combination(size_t p, size_t n)
        {
            if (n == 1 || n == 2)
                return 1;
            assert(p <= n);
            return n * (n - 1) / 2;
        }
        void solve()
        {
            std::sort(data.begin(), data.end());
            std::vector<int> diff; diff.reserve(data.size());
            std::adjacent_difference(data.begin(), data.end(), std::back_inserter(diff));
            auto low_diff_iter = std::min_element(diff.begin() + 1, diff.end());
            size_t low_diff_pair = 0;
            if (*low_diff_iter != 0)
                low_diff_pair = std::count(diff.begin() + 1, diff.end(), *low_diff_iter);
            else
            {
                auto zcount = 0;
                for (auto i = 1; i != diff.size(); ++i)
                {
                    if (diff[i] == 0)
                        ++zcount;
                    else if (zcount != 0 && diff[i] != 0)
                    {
                        low_diff_pair += combination(2, zcount + 1);
                        zcount = 0;
                    }
                }
                if (zcount != 0)
                    low_diff_pair += combination(2, zcount + 1);
            }
            size_t high_diff_pair = 0;
            if (data.front() != data.back()) {
                auto min_count = std::upper_bound(data.begin(), data.end(), data.front()) - data.begin();
                auto max_count = std::upper_bound(data.rbegin(), data.rend(), data.back(), std::greater<int>{}) - data.rbegin();
                high_diff_pair = min_count * max_count;
            }
            else {
                high_diff_pair = combination(2, data.size());
            }
            std::cout << low_diff_pair << " " << high_diff_pair << "\n";
        }
        static void test()
        {
            size_t data_len = 0;
            solution003 solution;
            std::cin >> data_len;
            solution.data.assign(data_len, -1);
            for (auto i = 0; i != data_len; ++i)
            {
                std::cin >> solution.data[i];
            }
            assert(solution.data.back() != -1);
            solution.solve();
        }
        std::vector<int> data;
    };
}