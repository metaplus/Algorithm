package problem.link;

import java.util.Objects;

public class Lc876MiddleNode {

    public ListNode middleNode(ListNode head) {
        if (Objects.isNull(head.next)) {
            return head;
        }
        ListNode left = head;
        ListNode right = head;
        while (true) {
            left = left.next;
            right = right.next;
            if (Objects.isNull(right.next) || Objects.isNull(right.next.next)) {
                return left;
            }
            right = right.next;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
