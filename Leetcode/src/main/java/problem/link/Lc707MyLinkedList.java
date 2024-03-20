package problem.link;

import java.util.Objects;

public class Lc707MyLinkedList {

    static class MyLinkedList {

        Node head;
        Node tail;

        public MyLinkedList() {

        }

        public int get(int index) {
            if (Objects.isNull(head)) {
                return -1;
            }
            Node node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
                if (Objects.isNull(node)) {
                    return -1;
                }
            }
            return node.val;
        }

        public void addAtHead(int val) {
            if (Objects.isNull(head)) {
                head = new Node(val, null);
                tail = head;
                return;
            }
            head = new Node(val, head);
        }

        public void addAtTail(int val) {
            if (Objects.isNull(head)) {
                addAtHead(val);
                return;
            }
            tail.next = new Node(val, null);
            tail = tail.next;
        }

        public void addAtIndex(int index, int val) {
            if (index == 0) {
                addAtHead(val);
                return;
            }
            if (Objects.isNull(head)) {
                return;
            }
            Node pre = head;
            for (int i = 0; i < index - 1; i++) {
                pre = pre.next;
                if (Objects.isNull(pre)) {
                    return;
                }
            }
            Node node = new Node(val, pre.next);
            pre.next = node;
            if (Objects.isNull(node.next)) {
                tail = node;
            }
        }

        public void deleteAtIndex(int index) {
            if (Objects.isNull(head)) {
                return;
            }
            if (index == 0) {
                head = head.next;
                if (Objects.isNull(head)) {
                    tail = null;
                }
                return;
            }
            Node pre = head;
            for (int i = 0; i < index - 1; i++) {
                pre = pre.next;
            }
            if (Objects.isNull(pre) || Objects.isNull(pre.next)) {
                return;
            }
            pre.next = pre.next.next;
            if (Objects.isNull(pre.next)) {
                tail = pre;
            }
        }
    }

    static class Node {

        int val;
        Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
}
