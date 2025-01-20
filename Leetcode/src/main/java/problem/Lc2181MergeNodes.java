package problem;

import problem.link.node.ListNode;

import java.util.Objects;

public class Lc2181MergeNodes {

    public ListNode mergeNodes(ListNode head) {
        int sum = 0;
        ListNode node = head;
        ListNode tail = null;
        ListNode result = null;
        while (Objects.nonNull(node.next)) {
            ListNode next = node.next;
            if (next.val > 0) {
                sum += next.val;
            } else {
                if (Objects.isNull(tail)) {
                    tail = new ListNode(sum);
                    result = tail;
                } else {
                    tail.next = new ListNode(sum);
                    tail = tail.next;
                }
                sum = 0;
            }
            node = next;
        }
        return result;
    }
}
