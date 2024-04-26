package problem.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lc1506FindRoot {

    public Node findRoot(List<Node> tree) {
        int xor = 0;
        for (Node node : tree) {
            xor ^= node.val;
            for (Node child : node.children) {
                xor ^= child.val;
            }
        }
        for (Node node : tree) {
            if (node.val == xor) {
                return node;
            }
        }
        return null;
    }


    public Node findRoot2(List<Node> tree) {
        Set<Integer> set = new HashSet<>(tree.size());
        for (Node node : tree) {
            for (Node child : node.children) {
                set.add(child.val);
            }
        }
        for (Node node : tree) {
            if (!set.contains(node.val)) {
                return node;
            }
        }
        return null;
    }

    class Node {
        public int val;
        public List<Node> children;


        public Node() {
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;
}
