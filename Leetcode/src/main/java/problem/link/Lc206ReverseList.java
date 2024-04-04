package problem.link;

import problem.link.node.ListNode;

import java.util.Objects;

public class Lc206ReverseList {

    public ListNode reverseList(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return head;
        }
        ListNode reverse = null;
        ListNode node = head;
        while (Objects.nonNull(node)) {
            ListNode next = node.next;
            if (Objects.isNull(reverse)) {
                reverse = node;
                reverse.next = null;
                node = next;
                continue;
            }
            node.next = reverse;
            reverse = node;
            node = next;
        }
        return reverse;
    }

    public ListNode reverseList2(ListNode head) {
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
