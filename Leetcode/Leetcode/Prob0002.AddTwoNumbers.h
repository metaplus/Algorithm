#pragma once
namespace leetcode
{
    template<>
    struct problem<2>
    {
        struct ListNode {
            int val;
            ListNode *next;
            ListNode(int x) : val(x), next(NULL) {}
        };
        class Solution {
        public:
            ListNode * addTwoNumbers(ListNode* l1, ListNode* l2) {
                int add_result = l1->val + l2->val;
                int complement = add_result / 10;
                ListNode* last = new ListNode{ add_result % 10 };
                ListNode* lists = last;
                int val1, val2;
                while (l1->next != nullptr || l2->next != nullptr)
                {
                    if (l1->next != nullptr)
                    {
                        l1 = l1->next;
                        val1 = l1->val;
                    }
                    else
                        val1 = 0;
                    if (l2->next != nullptr)
                    {
                        l2 = l2->next;
                        val2 = l2->val;
                    }
                    else
                        val2 = 0;
                    add_result = val1 + val2 + complement;
                    complement = add_result / 10;
                    last->next = new ListNode{ add_result % 10 };
                    last = last->next;
                }
                if (complement)
                    last->next = new ListNode{ complement };
                return lists;
            }
        };
        static bool test()
        {
            ListNode* l1 = new ListNode{ 1 };
            ListNode* l2 = new ListNode{ 9 };
            l2->next = new ListNode{ 9 };
            auto result = Solution{}.addTwoNumbers(l1, l2);
            return result->val == 0 && result->next->val == 0 && result->next->next->val == 1;
        }

    };
}