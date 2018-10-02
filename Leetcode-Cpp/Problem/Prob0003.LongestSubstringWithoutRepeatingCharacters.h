#pragma once
namespace leetcode
{
    template<>
    struct problem<3>
    {
        class Solution {
        public:
            int lengthOfLongestSubstring(std::string s) {
                if (s.empty())
                    return 0;
                std::array<int, 128> index;
                index.fill(-1);
                int max_len = 1;
                int len = 1;
                size_t posl = 0, posr = 0;
                index[s[0]] = 0;
                while (++posr != s.size())
                {
                    if (index[s[posr]] == -1)
                    {
                        index[s[posr]] = posr;
                        len += 1;
                        max_len = std::max<int>(max_len, len);
                    }
                    else
                    {
                        for (int i = posl; i < index[s[posr]]; ++i)
                        {
                            index[s[i]] = -1;
                            //len -= 1;
                        }
                        posl = index[s[posr]] + 1;
                        index[s[posr]] = posr;
                        len = posr - posl + 1;
                    }
                }
                return max_len;
            }
        };
        static bool test()
        {
            std::vector<bool> result{
                Solution{}.lengthOfLongestSubstring("abcabcbb"s) == 3,
                Solution{}.lengthOfLongestSubstring("bbbbb"s) == 1,
                Solution{}.lengthOfLongestSubstring("pwwkew"s) == 3
            };
            return std::all_of(result.begin(), result.end(), [](bool b) { return b; });
        }
    };
}
