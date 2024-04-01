package problem.link;

import problem.link.node.ListNode;

import java.util.Objects;

public class Lc143ReorderList {

    public void reorderList(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return;
        }
        int size = 0;
        ListNode node = head;
        while (Objects.nonNull(node)) {
            size++;
            node = node.next;
        }
        ListNode leftHead = null;
        ListNode leftTail = null;
        ListNode right = null;
        node = head;
        for (int i = 0; i < (size + 1) / 2; i++) {
            ListNode next = node.next;
            if (Objects.isNull(leftTail)) {
                leftHead = node;
                leftTail = node;
                leftTail.next = null;
            } else {
                leftTail.next = node;
                leftTail = node;
                leftTail.next = null;
            }
            node = next;
        }
        while (Objects.nonNull(node) ) {
            ListNode next = node.next;
            if (Objects.isNull(right)) {
                right = node;
                right.next = null;
            } else {
                node.next = right;
                right = node;
            }
            node = next;
        }
        node = right;
        ListNode left = leftHead;
        while (Objects.nonNull(node)) {
            ListNode left1 = left.next;
            ListNode node1 = node.next;
            left.next = node;
            node.next = left1;
            left = left1;
            node = node1;
        }
    }
}
