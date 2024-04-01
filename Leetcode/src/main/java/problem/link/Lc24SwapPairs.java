package problem.link;

import annotation.Problem;
import problem.link.node.ListNode;

import java.util.Objects;

/**
 * @Author: Jingxing Xu
 * @Date: 2019/9/14 18:38
 */
@Problem(index = 24,
        title = "Swap Nodes in Pairs",
        description = "Given a linked list, swap every two adjacent nodes and return its head.\n" +
                "\n" +
                "You may not modify the values in the list's nodes, only nodes itself may be changed.")
public class Lc24SwapPairs {

    public ListNode swapPairs(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return head;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        while (Objects.nonNull(pre.next) && Objects.nonNull(pre.next.next)) {
            ListNode left = pre.next;
            ListNode right = pre.next.next;
            ListNode next = pre.next.next.next;
            right.next = left;
            left.next = next;
            pre.next = right;
            pre = left;
        }
        return dummy.next;
    }

    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nextPairHead = head.next.next;
        ListNode left = head;
        ListNode right = head.next;
        left.next = swapPairs2(nextPairHead);
        right.next = left;
        return right;
    }
}
