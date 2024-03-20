package problem.link;

import problem.link.node.ListNode;

import java.util.Objects;

public class Lc203RemoveElements {

    public ListNode removeElements(ListNode head, int val) {
        if (Objects.isNull(head)) {
            return null;
        }
        if (Objects.isNull(head.next)) {
            return head.val == val ? null : head;
        }
        ListNode pre = head;
        ListNode node = head.next;
        ListNode head1 = head.val == val ? null : head;
        while (Objects.nonNull(node)) {
            if (node.val == val) {
                pre.next = node.next;
                node = node.next;
                continue;
            }
            if (Objects.isNull(head1)) {
                head1 = node;
            }
            pre = node;
            node = node.next;
        }
        return head1;
    }
}
