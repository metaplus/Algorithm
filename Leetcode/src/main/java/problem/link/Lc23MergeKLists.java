package problem.link;

import problem.link.node.ListNode;

import java.util.Objects;

public class Lc23MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        int interval = 1;
        do {
            interval *= 2;
            for (int i = 0; i * interval < lists.length; i++) {
                int left = i * interval;
                int right = i * interval + interval / 2;
                ListNode merge = merge(lists[left], right >= lists.length ? null : lists[right]);
                lists[left] = merge;
                if (right < lists.length) {
                    lists[right] = null;
                }
            }
        } while (interval < lists.length);
        return lists[0];
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode head = null;
        ListNode tail = null;
        while (Objects.nonNull(left) || Objects.nonNull(right)) {
            ListNode node = null;
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
            if (Objects.isNull(head)) {
                head = tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }
        return head;
    }

    // has better
    public ListNode mergeKLists2(ListNode[] lists) {
        ListNode head = null;
        ListNode tail = null;
        while (true) {
            ListNode node = null;
            int id = -1;
            for (int i = 0; i < lists.length; i++) {
                if (Objects.isNull(lists[i])) {
                    continue;
                }
                if (Objects.isNull(node) || lists[i].val < node.val) {
                    node = lists[i];
                    id = i;
                }
            }
            if (Objects.isNull(node)) {
                break;
            }
            if (Objects.isNull(head)) {
                head = tail = node;
                lists[id] = node.next;
                node.next = null;
                continue;
            }
            tail.next = node;
            tail = tail.next;
            lists[id] = node.next;
            node.next = null;
        }
        return head;
    }
}
