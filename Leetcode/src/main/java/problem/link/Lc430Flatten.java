package problem.link;

import java.util.Objects;

public class Lc430Flatten {

    public Node flatten(Node head) {
        if (Objects.isNull(head)) {
            return null;
        }
        recursion(head);
        return head;
    }

    private Node recursion(Node head) {
        if (Objects.isNull(head)) {
            return null;
        }
        if (Objects.isNull(head.child) && Objects.isNull(head.next)) {
            return head;
        }
        Node node = head;
        Node tail = head;
        while (Objects.nonNull(node)) {
            Node nextHead = node.next;
            tail = node;
            if (Objects.nonNull(node.child)) {
                Node childHead = node.child;
                Node childTail = recursion(node.child);
                if (Objects.nonNull(nextHead)) {
                    nextHead.prev = childTail;
                } else {
                    tail = childTail;
                }
                childTail.next = nextHead;
                childHead.prev = node;
                node.next = childHead;
                node.child = null;
            }
            node = nextHead;
        }
        return tail;
    }

    public static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int val, Node prev, Node next, Node child) {
            this.val = val;
            this.prev = prev;
            this.next = next;
            this.child = child;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }

    ;
}
