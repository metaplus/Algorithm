package problem.link;

import java.util.Objects;

public class Lc19RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode left = head;
        ListNode right = head.next;
        for (int i = 0; i < n; i++) {
            if (Objects.isNull(right)) {
                return head.next;
            }
            right = right.next;
        }
        while (Objects.nonNull(right)) {
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;
        return head;
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
