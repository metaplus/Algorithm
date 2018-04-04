#pragma once
#include <string>
#include <algorithm>
#include <vector>
#include <iostream>

/*
小Q最近遇到了一个难题：把一个字符串的大写字母放到字符串的后面，各个字符的相对位置不变，且不能申请额外的空间。
你能帮帮小Q吗？


输入描述:

输入数据有多组，每组包含一个字符串s，且保证:1<=s.length<=1000.




输出描述:

对于每组数据，输出移位后的字符串。


输入例子1:
AkleBiCeilD

输出例子1:
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
