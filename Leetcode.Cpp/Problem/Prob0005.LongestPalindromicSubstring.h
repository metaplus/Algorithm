#pragma once
namespace leetcode
{
    template<>
    struct problem<5>
    {
#pragma warning(push)
#pragma warning(disable:4018)
        class Solution {
        public:
            std::string longestPalindrome(std::string s) {
                size_t bl = 0, br = 0;
                auto is_palindromic = [&](size_t l, size_t r) ->bool
                {
                    assert(l <= r);
                    size_t ll = l, rr = r;
                    while (l <= r && l != s.size() && r != s.size())
                    {
                        if (s[l] != s[r])
                            return false;
                        l += 1; r -= 1;
                    }
                    if (rr - ll >= br - bl)
                    {
                        bl = ll; br = rr;
                    }
                    return true;
                };
                for (int i = 0; i != s.size(); ++i)
                {
                    for (int j = i + br - bl + 1; j < s.size(); ++j)
                    {
                        if(is_palindromic(i, j))
                        {
                            bl = i; br = j;
                        }
                    }
                }
                return s.substr(bl, br - bl + 1);
/*              std::map<size_t, std::vector<char>> centrals;
                std::array <std::vector<size_t>, 128> char_poses;
                for (size_t i = 0; i != s.size(); ++i)
                {
                    char c = s[i];
                    centrals[i].push_back(c);
                    if(!char_poses[c].empty())
                    {
                        for (size_t pos : char_poses[c])
                        {
                            if (pos + i % 2 != 0)
                                continue;
                            if (i - pos == 2 * centrals[(pos + i) / 2].size())
                                centrals[(pos + i) / 2].push_back(c);
                        }
                    }
                    char_poses[c].push_back(i);
                }
                auto& pair = *std::max_element(centrals.begin(), centrals.end(),
                    [](auto& l, auto& r) { return l.second.size() < r.second.size(); });
                std::string str{ pair.second.rbegin(),pair.second.rend() };
                if (pair.second.size() > 1)
                    str.append(pair.second.begin() + 1, pair.second.end());
                return str;*/
            }
        };
#pragma warning(pop)
        static bool test()
        {
            std::vector<bool> result{
                Solution{}.longestPalindrome("babad") == "bab"s,
                Solution{}.longestPalindrome("ccc") == "ccc"s,
                Solution{}.longestPalindrome("abcda") == "a"s,
                Solution{}.longestPalindrome("cbbd") == "bb"s
            };
            return std::all_of(result.begin(), result.end(), [](bool b) { return b; });
        }
    };

}