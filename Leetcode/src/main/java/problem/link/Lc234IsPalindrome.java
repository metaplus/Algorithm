package problem.link;

import problem.link.node.ListNode;

import java.util.Objects;

public class Lc234IsPalindrome {

    public boolean isPalindrome(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return true;
        }
        ListNode half = head;
        ListNode end = head.next;
        int count = 2;
        while (Objects.nonNull(end.next)) {
            if (Objects.nonNull(end.next.next)) {
                end = end.next.next;
                count += 2;
            } else {
                end = end.next;
                count++;
            }
            half = half.next;
        }

        ListNode reverse = new ListNode(-1);
        ListNode node = head;
        half = half.next;
        while (Objects.nonNull(node) && node != half) {
            ListNode next=node.next;
            node.next = reverse.next;
            reverse.next = node;
            node = next;
        }
        if (count % 2 == 1) {
            reverse.next = reverse.next.next;
        }
        node = reverse.next;
        while (Objects.nonNull(node)) {
            if (node.val != half.val) {
                return false;
            }
            node = node.next;
            half = half.next;
        }
        return true;
    }

    public boolean isPalindrome2(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return true;
        }
        if (Objects.isNull(head.next.next)) {
            return head.val == head.next.val;
        }
        ListNode left = head;
        ListNode right = head;
        while (Objects.nonNull(right.next)
                && Objects.nonNull(right.next.next)) {
            left = left.next;
            right = right.next.next;
        }
        ListNode reverse = left.next;
        ListNode tail = left.next;
        left.next = null;
        while (Objects.nonNull(tail.next)) {
            ListNode node = tail.next;
            tail.next = node.next;
            node.next = reverse;
            reverse = node;
        }
        left = head;
        right = reverse;
        while (Objects.nonNull(left) && Objects.nonNull(right)) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }
}
