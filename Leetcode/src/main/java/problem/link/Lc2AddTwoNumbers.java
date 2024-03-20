package problem.link;

import problem.link.node.ListNode;

import java.util.Objects;

public class Lc2AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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
