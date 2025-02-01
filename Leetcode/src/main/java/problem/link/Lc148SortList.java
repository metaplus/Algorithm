package problem.link;

import problem.link.node.ListNode;

import java.util.Objects;

public class Lc148SortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode[] result = quickSort(head);
        return result[0];
    }

    public ListNode[] quickSort(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new ListNode[]{head, head};
        }
        ListNode leftPrev = new ListNode(0);
        ListNode leftTail = leftPrev;
        ListNode rightPrev = new ListNode(0);
        ListNode rightTail = rightPrev;
        ListNode node = head.next;
        head.next = null;
        while (node != null) {
            ListNode next = node.next;
            if (node.val < head.val) {
                leftTail.next = node;
                leftTail = node;
                leftTail.next = null;
                node = next;
                continue;
            }
            rightTail.next = node;
            rightTail = node;
            rightTail.next = null;
            node = next;
        }
        ListNode[] left = quickSort(leftPrev.next);
        ListNode[] right = quickSort(rightPrev.next);
        ListNode[] result = new ListNode[2];
        if (left != null) {
            result[0] = left[0];
            left[1].next = head;
        } else {
            result[0] = head;
        }
        if (right != null) {
            result[1] = right[1];
            head.next = right[0];
        } else {
            result[1] = head;
        }
        return result;
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
