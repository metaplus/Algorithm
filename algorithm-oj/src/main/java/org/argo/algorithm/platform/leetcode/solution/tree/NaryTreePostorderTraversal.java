package org.argo.algorithm.platform.leetcode.solution.tree;

import org.argo.algorithm.platform.leetcode.annotation.LeetcodeSolution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@LeetcodeSolution(order = 590)
public class NaryTreePostorderTraversal {

    public List<Integer> postorder(Node root) {
        if (Objects.isNull(root)) {
            return Collections.emptyList();
        }
        List<Integer> traversal = new ArrayList<>();
        if (Objects.nonNull(root.children)) {
            for (Node child : root.children) {
                List<Integer> childTraversal = postorder(child);
                if (Objects.nonNull(childTraversal)) {
                    traversal.addAll(childTraversal);
                }
            }
        }
        traversal.add(root.val);
        return traversal;
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
