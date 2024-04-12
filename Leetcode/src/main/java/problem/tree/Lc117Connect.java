package problem.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class Lc117Connect {

    public Node connect(Node root) {
        if (Objects.isNull(root)) {
            return root;
        }
        Deque<Node> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            Node pre = null;
            while (size-- > 0) {
                Node node = deque.poll();
                if (Objects.nonNull(pre)) {
                    pre.next = node;
                }
                if (Objects.nonNull(node.left)) {
                    deque.offer(node.left);
                }
                if (Objects.nonNull(node.right)) {
                    deque.offer(node.right);
                }
                pre = node;
            }
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;
}
