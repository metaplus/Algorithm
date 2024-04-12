package problem.tree;

import problem.tree.node.TreeNode;

import java.util.Objects;

public class Lc129SumNumbers {

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int preSum) {
        if (Objects.isNull(root)) {
            return 0;
        }
        int next = preSum * 10 + root.val;
        if (Objects.isNull(root.left) && Objects.isNull(root.right)) {
            return next;
        }
        return dfs(root.left, next) + dfs(root.right, next);
    }
}
