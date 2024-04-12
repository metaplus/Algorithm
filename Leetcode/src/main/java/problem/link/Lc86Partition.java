package problem.link;

import problem.link.node.ListNode;

import java.util.Objects;

public class Lc86Partition {


    public ListNode partition(ListNode head, int x) {
        ListNode left = null;
        ListNode leftTail = null;
        ListNode right = null;
        ListNode rightTail = null;
        ListNode node = head;
        while (Objects.nonNull(node)) {
            ListNode next = node.next;
            node.next = null;
            if (node.val < x) {
                if (Objects.isNull(left)) {
                    left = node;
                } else {
                    leftTail.next = node;
                }
                leftTail = node;
            } else {
                if (Objects.isNull(right)) {
                    right = node;
                } else {
                    rightTail.next = node;
                }
                rightTail = node;
            }
            node = next;
        }
        if (Objects.isNull(left)) {
            return right;
        }
        leftTail.next = right;
        return left;
    }
}
