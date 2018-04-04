#pragma once
#include <string>
#include <algorithm>
#include <vector>
#include <iostream>

/*
СQ���������һ�����⣺��һ���ַ����Ĵ�д��ĸ�ŵ��ַ����ĺ��棬�����ַ������λ�ò��䣬�Ҳ����������Ŀռ䡣
���ܰ��СQ��


��������:

���������ж��飬ÿ�����һ���ַ���s���ұ�֤:1<=s.length<=1000.




�������:

����ÿ�����ݣ������λ����ַ�����


��������1:
AkleBiCeilD

�������1:
kleieilABCD
*/
namespace nowcoder
{
    struct solution002
    {
        std::string& solve(std::string& str)
        {
//            auto up_case = std::find_if(str.begin(), str.end(), [](const char c) { return c <= 'Z'; });
//            if (up_case == str.end())
//                return str;
//            for (auto iter = up_case + 1; iter != str.end(); ++iter)
//            {
//                if (*iter >= 'a')
//                {
//                    up_case = std::rotate(up_case, iter, iter + 1);
//                }
//            }
            std::stable_partition(str.begin(), str.end(), [](const char c) { return c >= 'a'; });
            return str;
        }
        static void test()
        {
            std::string line;
            while (std::getline(std::cin, line))
            {
                std::cout << solution002{}.solve(line) << "\n";
            }
        }
    };
}
