package problem.sort;


import java.util.List;
import java.util.Objects;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Lc147InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        ListNode first = new ListNode(head.val);
        ListNode move = head.next;
        while (Objects.nonNull(move)) {
            ListNode current = first;
            ListNode previous = null;
            while (true) {
                if (current.val > move.val) {
                    if (Objects.isNull(previous)) {
                        first = new ListNode(move.val, first);
                    } else {
                        previous.next = new ListNode(move.val, previous.next);
                    }
                    break;
                }
                if (current.val < move.val
                        && (Objects.isNull(current.next) || current.next.val > move.val)) {
                    current.next = new ListNode(move.val, current.next);
                    break;
                }
                if (Objects.isNull(current.next)) {
                    current.next = new ListNode(move.val);
                    break;
                }
                previous = current;
                current = current.next;
            }
            move = move.next;
        }
        return first;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
