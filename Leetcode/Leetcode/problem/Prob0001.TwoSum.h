#pragma once
namespace leetcode 
{
    template<>
    struct problem<1>
    {
        class Solution {
        public:
            std::vector<int> twoSum(std::vector<int>& nums, int target) {
                std::unordered_map<int, int> record;
                for (int i = 0; i != nums.size(); ++i) {
                    if (record.count(target - nums[i])) {
                        return { record[target - nums[i]] ,i };
                    }
                    record[nums[i]] = i;
                }
                return {};
            }
        };
        static bool test()
        {
            std::vector<int> data{ 3,3 };
            return Solution{}.twoSum(data, 6) == std::vector<int>{0, 1};
        }
    };
}