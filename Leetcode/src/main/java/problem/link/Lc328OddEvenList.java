package problem.link;

import problem.link.node.ListNode;

import java.util.Objects;

public class Lc328OddEvenList {

    public ListNode oddEvenList(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return head;
        }
        ListNode oddTail = head;
        ListNode evenHead = head.next;
        ListNode evenTail = head.next;
        boolean odd = true;
        ListNode node = head.next.next;
        while (Objects.nonNull(node)) {
            if (odd) {
                oddTail.next = node;
                oddTail = node;
            } else {
                evenTail.next = node;
                evenTail = node;
            }
            node = node.next;
            odd = !odd;
        }
        evenTail.next = null;
        oddTail.next = evenHead;
        return head;
    }
}
