package problem;

import annotation.Problem;
import structure.ListNode;

/**
 * @Author: Jingxing Xu
 * @Date: 2019/9/14 18:38
 */
@Problem(index = 24,
        title = "Swap Nodes in Pairs",
        description = "Given a linked list, swap every two adjacent nodes and return its head.\n" +
                "\n" +
                "You may not modify the values in the list's nodes, only nodes itself may be changed.")
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nextPairHead = head.next.next;
        ListNode left = head;
        ListNode right = head.next;
        left.next = swapPairs(nextPairHead);
        right.next = left;
        return right;
    }
}
