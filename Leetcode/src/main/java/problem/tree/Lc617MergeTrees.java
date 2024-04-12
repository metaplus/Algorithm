package problem.tree;

import problem.tree.node.TreeNode;

import java.util.Objects;

public class Lc617MergeTrees {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return dfs(root1, root2);
    }

    public TreeNode dfs(TreeNode left, TreeNode right) {
        if (Objects.isNull(left)) {
            if (Objects.isNull(right)) {
                return null;
            }
            return right;
        }
        if (Objects.isNull(right)) {
            return left;
        }
        left.val += right.val;
        left.left = dfs(left.left, right.left);
        left.right = dfs(left.right, right.right);
        return left;
    }
}
