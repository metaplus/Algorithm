package problem.link;

import problem.link.node.ListNode;

import java.util.Objects;

public class Lc61RotateRight {

    public ListNode rotateRight(ListNode head, int k) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return head;
        }
        int size = 0;
        ListNode node = head;
        ListNode tail = null;
        while (Objects.nonNull(node)) {
            size++;
            tail = node;
            node = node.next;
        }
        k %= size;
        k = size - k;
        if (k > 0) {
            node = head;
            for (int i = 0; i < k - 1; i++) {
                node = node.next;
            }
            tail.next = head;
            head = node.next;
            node.next = null;
        }
        return head;
    }
}
