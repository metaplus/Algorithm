package problem.link;

import problem.link.node.ListNode;

import java.util.Objects;

public class Lc92ReverseBetween {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return head;
        }
        ListNode node = head;
        ListNode pre = null;
        if (left > 1) {
            for (int i = 0; i < left - 2; i++) {
                node = node.next;
            }
            pre = node;
            node = node.next;
        }
        ListNode midHead = null;
        ListNode midTail = null;
        for (int i = 0; i < right - left + 1; i++) {
            if (Objects.isNull(midTail)) {
                midHead = node;
                midTail = node;
                node = node.next;
                continue;
            }
            ListNode next = node.next;
            node.next = midHead;
            midHead = node;
            node = next;
        }
        if (Objects.nonNull(pre)) {
            pre.next = midHead;
        } else {
            head = midHead;
        }
        midTail.next = node;
        return head;
    }
}
