package problem.link;

import problem.link.node.ListNode;

import java.util.Objects;

public class Lc148SortList {

    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }


    public ListNode mergeSort(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return head;
        }
        ListNode left = head;
        ListNode right = head.next;
        while (Objects.nonNull(right) && Objects.nonNull(right.next)) {
            left = left.next;
            right = right.next;
            if (Objects.nonNull(right)) {
                right = right.next;
            }
        }
        ListNode next = left.next;
        left.next = null;
        left = mergeSort(head);
        right = mergeSort(next);
        ListNode sort = null;
        ListNode tail = null;
        while (Objects.nonNull(left) || Objects.nonNull(right)) {
            ListNode node;
            if (Objects.isNull(left)) {
                node = right;
                right = right.next;
            } else if (Objects.isNull(right)) {
                node = left;
                left = left.next;
            } else {
                if (left.val < right.val) {
                    node = left;
                    left = left.next;
                } else {
                    node = right;
                    right = right.next;
                }
            }
            if (Objects.isNull(sort)) {
                sort = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }
        return sort;
    }
}
