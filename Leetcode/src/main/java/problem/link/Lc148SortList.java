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
            right = right.next.next;
        }
        ListNode next = left.next;
        left.next = null;
        left = mergeSort(head);
        right = mergeSort(next);
        ListNode prev = new ListNode(0);
        ListNode tail = prev;
        while (Objects.nonNull(left) || Objects.nonNull(right)) {
            if (Objects.isNull(left)) {
                tail.next = right;
                break;
            }
            if (Objects.isNull(right)) {
                tail.next = left;
                break;
            }
            if (left.val < right.val) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }
        return prev.next;
    }
}
