package problem.tree;

import problem.tree.node.TreeNode;

import java.util.Objects;

public class Lc236LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p, q);
    }

    public TreeNode dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (Objects.isNull(node)) {
            return null;
        }
        if (node == p || node == q) {
            return node;
        }
        TreeNode left = dfs(node.left, p, q);
        TreeNode right = dfs(node.right, p, q);
        if (Objects.nonNull(left) && Objects.nonNull(right)) {
            return node;
        }
        return Objects.isNull(left) ? right : left;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        return dfs2(root, p, q);
    }

    public TreeNode dfs2(TreeNode node, TreeNode p, TreeNode q) {
        if (Objects.isNull(node)) {
            return null;
        }
        TreeNode left = dfs(node.left, p, q);
        TreeNode right = dfs(node.right, p, q);
        if (Objects.nonNull(left) && Objects.nonNull(right)) {
            return node;
        }
        if (Objects.isNull(left) && Objects.isNull(right)) {
            if (node.val == p.val || node.val == q.val) {
                return node;
            }
            return null;
        }
        if (node.val == p.val || node.val == q.val) {
            return node;
        }
        return Objects.nonNull(left) ? left : right;
    }
}
