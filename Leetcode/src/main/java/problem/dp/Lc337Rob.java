package problem.dp;

import problem.tree.node.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Lc337Rob {

    private static final int[] leaf = new int[]{0, 0};

    private static int[] dfs(TreeNode node) {
        if (Objects.isNull(node)) {
            return leaf;
        }
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        return new int[]{Math.max(left[0], left[1]) + Math.max(right[0], right[1]),
                node.val + left[0] + right[0]};
    }

    public int rob(TreeNode root) {
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }

        public int rob2(TreeNode root) {
        Map<TreeNode, int[]> dp = new HashMap<>();
        int[] result = dfs(root, dp);
        return Math.max(result[0], result[1]);
    }

    public int[] dfs(TreeNode node, Map<TreeNode, int[]> dp) {
        if (Objects.isNull(node)) {
            return new int[]{0, 0};
        }
        int[] left = dfs(node.left, dp);
        int[] right = dfs(node.right, dp);
        int[] state = new int[]{
                Math.max(left[0], left[1]) + Math.max(right[0], right[1]),
                left[0] + right[0] + node.val,
        };
        return state;
    }
}
