package problem.link;

import problem.link.node.ListNode;

import java.util.Objects;

public class Lc25ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (Objects.isNull(head) || Objects.isNull(head.next) || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        while (Objects.nonNull(pre)) {
            ListNode node = pre;
            for (int i = 0; i < k; i++) {
                node = node.next;
                if (Objects.isNull(node)) {
                    return dummy.next;
                }
            }
            ListNode next = node.next;
            node.next = null;
            ListNode preNext = pre.next;
            reverseList(pre);
            pre = preNext;
            pre.next = next;
        }
        return dummy.next;
    }

    private void reverseList(ListNode pre) {
        ListNode reverse = null;
        ListNode node = pre.next;
        while (Objects.nonNull(node)) {
            ListNode next = node.next;
            node.next = reverse;
            reverse = node;
            node = next;
        }
        pre.next = reverse;
    }

    public ListNode reverseKGroup2(ListNode head, int k) {
        if (Objects.isNull(head) || Objects.isNull(head.next) || k == 1) {
            return head;
        }
        ListNode node = head;
        int size = 0;
        while (Objects.nonNull(node)) {
            size++;
            node = node.next;
        }
        int steps = size - size % k;
        node = head;
        ListNode reverse = null;
        ListNode reversePre = null;
        ListNode reverseHead = null;
        ListNode reverseTail = null;
        for (int i = 0; i < steps; i++) {
            ListNode next = node.next;
            if (Objects.isNull(reverseHead)) {
                reverseHead = node;
                reverseTail = node;
                reverseTail.next = null;
                node = next;
            } else {
                node.next = reverseHead;
                reverseHead = node;
                node = next;
            }
            if ((i + 1) % k == 0) {
                if (Objects.isNull(reversePre)) {
                    reverse = reverseHead;
                    reversePre = reverseTail;
                } else {
                    reversePre.next = reverseHead;
                    reversePre = reverseTail;
                }
                if (i + 1 < steps) {
                    reverseHead = null;
                    reverseTail = null;
                } else {
                    reverseHead = null;
                    reverseTail.next = node;
                }

            }
        }
        return reverse;
    }
}
