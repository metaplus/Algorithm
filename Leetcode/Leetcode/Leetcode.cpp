// Leetcode.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include "expect.hpp"
#include "problem.h"

int main()
{
    using namespace leetcode;
    if (!expect::of<filter::last>(
        problem<1>::test(),         //for loop adapt better than <algorithm> just for OJ
        problem<2>::test(),             
        problem<3>::test()          //ascii 0~127 ' '32 '!'33 '0'48 'A'65 'a'97
        ))
        throw std::logic_error{ "" };
    return 0;
}

