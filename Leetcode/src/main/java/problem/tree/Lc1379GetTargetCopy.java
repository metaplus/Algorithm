package problem.tree;

import problem.tree.node.TreeNode;

import java.util.Objects;

public class Lc1379GetTargetCopy {

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return dfs(original, cloned, target);
    }

    public final TreeNode dfs(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (Objects.isNull(original)) {
            return null;
        }
        if (original == target) {
            return cloned;
        }
        TreeNode next = dfs(original.left, cloned.left, target);
        if (Objects.nonNull(next)) {
            return next;
        }
        return dfs(original.right, cloned.right, target);
    }
}
