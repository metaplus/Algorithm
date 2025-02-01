package problem.link;

import problem.link.node.ListNode;

import java.util.Objects;

public class Lc21MergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (Objects.nonNull(list1) || Objects.nonNull(list2)) {
            if (Objects.isNull(list1)) {
                tail.next = list2;
                break;
            }
            if (Objects.isNull(list2)) {
                tail.next = list1;
                break;
            }
            if (list1.val < list2.val) {
                tail.next = list1;
                tail = list1;
                list1 = list1.next;
                continue;
            }
            tail.next = list2;
            tail = list2;
            list2 = list2.next;
        }
        return head.next;
    }

    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (Objects.isNull(list1)) {
            return list2;
        }
        if (Objects.isNull(list2)) {
            return list1;
        }
        ListNode head = null;
        ListNode tail = null;
        while (Objects.nonNull(list1) && Objects.nonNull(list2)) {
            if (list1.val <= list2.val) {
                if (Objects.isNull(head)) {
                    head = list1;
                    tail = list1;
                    list1 = list1.next;
                    tail.next = null;
                } else {
                    tail.next = list1;
                    list1 = list1.next;
                    tail.next.next = null;
                    tail = tail.next;
                }
                continue;
            }
            if (Objects.isNull(tail)) {
                head = list2;
                tail = list2;
                list2 = list2.next;
                tail.next = null;
            } else {
                tail.next = list2;
                list2 = list2.next;
                tail.next.next = null;
                tail = tail.next;
            }
        }
        while (Objects.nonNull(list1)) {
            tail.next = list1;
            list1 = list1.next;
            tail = tail.next;
        }
        while (Objects.nonNull(list2)) {
            tail.next = list2;
            list2 = list2.next;
            tail = tail.next;
        }
        return head;
    }

}
