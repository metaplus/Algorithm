package problem.tree;

import problem.tree.node.TreeNode;

import java.util.Objects;

public class Lc226InvertTree {

    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }

    public void dfs(TreeNode node) {
        if (Objects.isNull(node)) {
            return;
        }
        TreeNode left = node.left;
        node.left = node.right;
        node.right = left;
        dfs(node.left);
        dfs(node.right);
    }
}
