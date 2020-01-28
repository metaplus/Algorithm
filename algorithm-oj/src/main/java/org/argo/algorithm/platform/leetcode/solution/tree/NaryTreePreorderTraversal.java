package org.argo.algorithm.platform.leetcode.solution.tree;

import org.argo.algorithm.platform.leetcode.annotation.LeetcodeSolution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@LeetcodeSolution(order = 589)
public class NaryTreePreorderTraversal {

    public List<Integer> preorder(Node root) {
        if (Objects.isNull(root)) {
            return Collections.emptyList();
        }
        List<Integer> traversal = new ArrayList<>();
        traversal.add(root.val);
        if (Objects.nonNull(root.children)) {
            for (Node child : root.children) {
                List<Integer> childTraversal = preorder(child);
                if (Objects.nonNull(childTraversal)) {
                    traversal.addAll(childTraversal);
                }
            }
        }
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
