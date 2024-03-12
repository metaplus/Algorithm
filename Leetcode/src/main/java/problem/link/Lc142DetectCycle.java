package problem.link;

import java.util.Objects;

public class Lc142DetectCycle {

    public ListNode detectCycle(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return null;
        }
        ListNode left = head;
        ListNode right = head;
        do {
            left = left.next;
            if (Objects.isNull(right.next)
                    || Objects.isNull(right.next.next)) {
                return null;
            }
            right = right.next.next;
        } while (left != right);
        ListNode node = head;
        while (node != left) {
            node = node.next;
            left = left.next;
        }
        return node;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
