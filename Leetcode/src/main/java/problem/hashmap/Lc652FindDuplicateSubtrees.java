package problem.hashmap;

import org.checkerframework.checker.units.qual.A;

import java.util.*;

public class Lc652FindDuplicateSubtrees {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Count> map = new HashMap<>();
        recursion(root, null, map);
        List<TreeNode> nodes = new ArrayList<>();
        for (Count count : map.values()) {
            if (count.count > 1) {
                nodes.add(count.node);
            }
        }
        return nodes;
    }

    public StringBuilder recursion(TreeNode node, TreeNode parent, Map<String, Count> map) {
        if (Objects.isNull(node)) {
            return null;
        }
        StringBuilder left = recursion(node.left, node, map);
        StringBuilder right = recursion(node.right, node, map);
        if (Objects.isNull(parent)) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(node.val);
        builder.append('-');
        if (Objects.isNull(left)) {
            builder.append('#');
        } else {
            builder.append(left);
        }
        builder.append('+');
        if (Objects.isNull(right)) {
            builder.append('#');
        } else {
            builder.append(right);
        }
        String key = builder.toString();
        map.computeIfAbsent(key, k -> new Count(node, 0)).count++;
        return builder;
    }

    public static class Count {
        TreeNode node;
        int count;

        public Count(TreeNode node, int count) {
            this.node = node;
            this.count = count;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
