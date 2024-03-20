package problem.link;

import problem.link.node.ListNode;

import java.util.Objects;

public class Lc206ReverseList {

    public ListNode reverseList(ListNode head) {
        if (Objects.isNull(head)) {
            return null;
        }
        ListNode tail = head;
        while (Objects.nonNull(tail.next)) {
            ListNode node = tail.next;
            tail.next = node.next;
            node.next = head;
            head = node;
        }
        return head;
    }
}
