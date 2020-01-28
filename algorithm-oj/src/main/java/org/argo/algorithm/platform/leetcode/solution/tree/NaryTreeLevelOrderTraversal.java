package org.argo.algorithm.platform.leetcode.solution.tree;

import org.argo.algorithm.platform.leetcode.annotation.LeetcodeSolution;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@LeetcodeSolution(order = 429)
public class NaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> traversal = new ArrayList<>();
        levelOrderChild(root, 0, traversal);
        return traversal;
    }

    private void levelOrderChild(Node node, int depth, List<List<Integer>> traversal) {
        if (Objects.isNull(node)) {
            return;
        }
        while (traversal.size() <= depth) {
            traversal.add(new ArrayList<>());
        }
        List<Integer> levelTraversal = traversal.get(depth);
        levelTraversal.add(node.val);
        if (Objects.nonNull(node.children)) {
            for (Node child : node.children) {
                levelOrderChild(child, depth + 1, traversal);
            }
        }
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
