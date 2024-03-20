package problem.link;

import java.util.HashMap;
import java.util.Objects;

public class Lc138CopyRandomList {

    public Node copyRandomList(Node head) {
        if (Objects.isNull(head)) {
            return null;
        }
        Node left = head;
        Node copy = null;
        Node right = null;
        HashMap<Node, Node> map = new HashMap<>();
        while (Objects.nonNull(left)) {
            if (Objects.isNull(copy)) {
                copy = new Node(left.val);
                right = copy;
                map.put(left, right);
                left = left.next;
                continue;
            }
            right.next = new Node(left.val);
            map.put(left, right.next);
            left = left.next;
            right = right.next;
        }
        left = head;
        right = copy;
        while (Objects.nonNull(left)) {
            if (Objects.nonNull(left.random)) {
                right.random = map.get(left.random);
            }
            left = left.next;
            right = right.next;
        }
        return copy;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
