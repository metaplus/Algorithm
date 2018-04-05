#pragma once
#include <string>
#include <algorithm>
#include <vector>
#include <iostream>

/*
给定一个字符串s，你可以从中删除一些字符，使得剩下的串是一个回文串。如何删除才能使得回文串最长呢？
输出需要删除的字符个数。

输入描述:

输入数据有多组，每组包含一个字符串s，且保证:1<=s.length<=1000.




输出描述:

对于每组数据，输出一个整数，代表最少需要删除的字符个数。


输入例子1:
abcda
google

输出例子1:
2
2
 */
namespace nowcoder
{
    struct solution001
    {
        static size_t solve(const std::string& str)
        {
            std::string rstr{ str.rbegin(),str.rend() };
//            std::string rstr; 
//            rstr.reserve(str.size());
//            std::reverse_copy(str.begin(), str.end(), std::back_inserter(rstr));
            static int dp[1001][1001]{};
            for (auto i = 0; i != str.size() + 1; ++i)
            {
                dp[i][0] = 0;
                dp[0][i] = 0;
            }
            for (auto i = 1; i != str.size() + 1; ++i)
            {
                for (auto j = 1; j != str.size() + 1; ++j)
                {
                    if (str[i - 1] == rstr[j - 1])
                    {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    else
                    {
                        dp[i][j] = std::max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            return str.size() - dp[str.size()][str.size()];
        }
        static void test()
        {
            std::string line;
            while (std::getline(std::cin, line))
            {
                std::cout << solve(line) << "\n";
            }
        }
    };
}
