// Leetcode.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include "expect.hpp"
#include "pch.h"
struct chunk
{
    int val;
    bool has_left;
    bool has_right;
    friend std::istream& operator>>(std::istream& is, chunk& ch);
    friend std::ostream& operator<<(std::ostream& os, chunk& ch);

};
int main()
{
    using namespace leetcode;
    if (!expect::of<filter::last>(  // *** notes area *** 
        problem<1>::test(),         //for-loop adapt better than <algorithm> just for OJ
        problem<2>::test(),             
        problem<3>::test(),         //ascii 0~127  ' '32  '!'33  '0'48  'A'65  'a'97
        problem<4>::test(),         //use size concept instead of index covers appropriately
        problem<5>::test()          
        ))
        throw std::logic_error{ "" };

    std::stringstream ss;
    chunk test{ 2432,false,true };
    ss << test;
    std::string str = ss.str();
    std::stringstream ss2;
    ss2.str(str);
    chunk test2;
    ss2 >> test2;
    return 0;
}
std::istream& operator>>(std::istream& is, chunk& ch){
    is.read(reinterpret_cast<char*>(&ch), sizeof(chunk));
    return is;
}
std::ostream& operator<<(std::ostream& os, chunk& ch)
{
    os.write(reinterpret_cast<char*>(&ch), sizeof(chunk));
    return os;
}
