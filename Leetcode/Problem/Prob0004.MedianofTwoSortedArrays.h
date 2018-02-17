#pragma once
namespace leetcode
{
    template<>
    struct problem<4>
    {
#pragma warning(push)
#pragma warning(disable:4715)
        class Solution {
        public:
            enum side { left, right };
            void shrink(size_t& p,size_t& s, size_t delta, side side)
            {
                //size_t delta = s / 2;
                //size_t delta = (s + 1) / 2;
                if (side == left)
                    p += delta;
                s -= delta;
            }
            double average(int a, int b)
            {
                return static_cast<double>(a + b) / 2;
            }
            double find_median(const std::vector<int>& nums, size_t p, size_t s)
            {
                if (s % 2 != 0)
                    return nums[p + s / 2];
                return average(nums[p + s / 2], nums[p + s / 2 - 1]);
            }
            double findMedianSortedArrays(const std::vector<int>& nums1, const std::vector<int>& nums2) {
                if (nums1.empty())
                    return find_median(nums2, 0, nums2.size());
                if (nums2.empty())
                    return find_median(nums1, 0, nums1.size());
                size_t total_size = nums1.size() + nums2.size();
                size_t part_size = (total_size) / 2;
                auto& vec1 = nums1.size() <= nums2.size() ? nums1 : nums2;   //smaller one
                auto& vec2 = nums1.size() <= nums2.size() ? nums2 : nums1;   //bigger one
                std::function<size_t(size_t, size_t)> binary_search;
                binary_search = [&](size_t sl, size_t sr)
                {
                    size_t s1 = (sl + sr) / 2;
                    size_t s2 = part_size - s1;
                    if (sr - sl == 0)      
                        return s1;
                    if ((s1 == 0 || vec1[s1 - 1] <= vec2[s2]) && (s1 == vec1.size() || vec2[s2 - 1] <= vec1[s1]))
                        return s1;
                    if (s1 != 0 && vec1[s1 - 1] > vec2[s2])
                        return binary_search(sl, s1 - 1);
                    if (s1 != vec1.size() && vec2[s2 - 1] > vec1[s1])
                        return binary_search(s1 + 1, sr);
                };
                size_t s1 = binary_search(0, vec1.size());
                size_t s2 = part_size - s1;
                if (total_size % 2 != 0)
                {
                    return  s1 != vec1.size() ? s2 != vec2.size() ? std::min(vec1[s1], vec2[s2]) : vec1[s1] : vec2[s2];
                }
                return average(
                    s1 != 0 ? s2 != 0 ? std::max(vec1[s1 - 1], vec2[s2 - 1]) : vec1[s1 - 1] : vec2[s2 - 1],
                    s1 != vec1.size() ? s2 != vec2.size() ? std::min(vec1[s1], vec2[s2]) : vec1[s1] : vec2[s2]);
            }
        };
#pragma warning(pop)
        static bool test()
        {
            std::vector<bool> result{
                Solution{}.findMedianSortedArrays({ 1,2 },{ 3,4,5,6 }) == 3.5,
                Solution{}.findMedianSortedArrays({ 1,2,6 }, { 3,4,5 }) == 3.5,
                Solution{}.findMedianSortedArrays({ 1,3 }, { 2 }) == 2,
                Solution{}.findMedianSortedArrays({ 1,2 }, { 3,4 }) == 2.5,
                Solution{}.findMedianSortedArrays({ 100001 }, { 100000 }) == 100000.5
            };
            return std::all_of(result.begin(), result.end(), [](bool b) { return b; });
        }
    };
    
}