package problem.link;

import problem.link.node.ListNode;

import java.util.Objects;

public class Lc141HasCycle {

    public boolean hasCycle(ListNode head) {
        if (Objects.isNull(head)) {
            return false;
        }
        ListNode left = head;
        ListNode right = head.next;
        while (Objects.nonNull(right)) {
            if (left == right) {
                return true;
            }
            left = left.next;
            right = right.next;
            if (Objects.isNull(right)) {
                return false;
            }
            right = right.next;
        }
        return false;
    }



}
