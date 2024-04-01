package problem.link;

import problem.link.node.ListNode;

import java.util.Objects;

public class Lc82DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return head;
        }
        ListNode node = head;
        ListNode pre = null;
        while (Objects.nonNull(node) && Objects.nonNull(node.next)) {
            if (node.next.val == node.val) {
                while (Objects.nonNull(node.next) && node.next.val == node.val) {
                    node.next = node.next.next;
                }
                if (Objects.isNull(pre)) {
                    head = node.next;
                } else {
                    pre.next = node.next;
                }
                node = node.next;
                continue;
            }
            pre = node;
            node = node.next;
        }
        return head;
    }
}
