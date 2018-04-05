#pragma once
#include <string>
#include <algorithm>
#include <vector>
#include <iostream>

/*
����һ���ַ���s������Դ���ɾ��һЩ�ַ���ʹ��ʣ�µĴ���һ�����Ĵ������ɾ������ʹ�û��Ĵ���أ�
�����Ҫɾ�����ַ�������

��������:

���������ж��飬ÿ�����һ���ַ���s���ұ�֤:1<=s.length<=1000.




�������:

����ÿ�����ݣ����һ������������������Ҫɾ�����ַ�������


��������1:
abcda
google

�������1:
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
