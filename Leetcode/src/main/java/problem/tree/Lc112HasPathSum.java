package problem.tree;

import problem.tree.node.TreeNode;

import java.util.Objects;

public class Lc112HasPathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum, 0);
    }

    public boolean dfs(TreeNode root, int targetSum, int preSum) {
        if (Objects.isNull(root)) {
            return false;
        }
        if (Objects.isNull(root.left) && Objects.isNull(root.right)) {
            return targetSum == preSum + root.val;
        }
        return dfs(root.left, targetSum, preSum + root.val)
                || dfs(root.right, targetSum, preSum + root.val);
    }
}
