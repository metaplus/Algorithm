package problem.tree;

import problem.tree.node.TreeNode;

public class Lc572IsSubtree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        return root != null
                && (dfs(root, subRoot)
                || isSubtree(root.left, subRoot)
                || isSubtree(root.right, subRoot));
    }

    public boolean dfs(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return subRoot == null;
        }
        return subRoot != null
                && root.val == subRoot.val
                && dfs(root.left, subRoot.left)
                && dfs(root.right, subRoot.right);
    }
}
