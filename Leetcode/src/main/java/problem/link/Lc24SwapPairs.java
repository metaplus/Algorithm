package problem.link;

import problem.link.node.ListNode;

import java.util.Objects;


public class Lc24SwapPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = new ListNode(0);
        ListNode tail = prev;
        ListNode node = head;
        while (node != null) {
            ListNode left = node;
            node = node.next;
            if (node != null) {
                ListNode next = node.next;
                ListNode right = node;
                right.next = left;
                left.next = null;
                tail.next = right;
                tail = left;
                node = next;
            } else {
                tail.next = left;
                tail = tail.next;
            }
            tail.next = null;
        }
        return prev.next;
    }

    public ListNode swapPairs3(ListNode head) {
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
