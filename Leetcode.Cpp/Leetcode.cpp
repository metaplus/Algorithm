// Leetcode.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include "expect.hpp"
#include "pch.h"

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
    return 0;
}
                                                       