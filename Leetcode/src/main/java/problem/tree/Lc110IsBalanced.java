package problem.tree;

import problem.tree.node.TreeNode;

public class Lc110IsBalanced {

    private boolean balance = true;

    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return balance;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = dfs(node.left);
        int rightDepth = dfs(node.right);
        if (!balance) {
            return 0;
        }
        balance =Math.abs(leftDepth - rightDepth) < 2;
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
