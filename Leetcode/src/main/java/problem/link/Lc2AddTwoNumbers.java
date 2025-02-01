package problem.link;

import problem.link.node.ListNode;

import java.util.Objects;

public class Lc2AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int pre = 0;
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (l1 != null || l2 != null) {
            int val = 0;
            if (l1 == null) {
                val = pre + l2.val;
            } else if (l2 == null) {
                val = pre + l1.val;
            } else {
                val = pre + l1.val + l2.val;
            }
            pre = val / 10;
            val %= 10;
            ListNode node = new ListNode();
            node.val = val;
            tail.next = node;
            tail = node;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (pre > 0) {
            ListNode node = new ListNode();
            node.val = pre;
            tail.next = node;
        }
        return head.next;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode left = l1;
        ListNode right = l2;
        int pre = 0;
        ListNode tail = null;
        while (Objects.nonNull(left) && Objects.nonNull(right)) {
            left.val += right.val + pre;
            pre = left.val / 10;
            left.val %= 10;
            tail = left;
            left = left.next;
            right = right.next;
        }
        if (Objects.nonNull(right)) {
            tail.next = right;
            left = right;
        }
        while (Objects.nonNull(left)) {
            left.val += pre;
            pre = left.val / 10;
            left.val %= 10;
            tail = left;
            left = left.next;
        }
        if (pre > 0) {
            tail.next = new ListNode(pre);
        }
        return l1;
    }
}
