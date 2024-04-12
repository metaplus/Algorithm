package problem.tree.search;

import problem.tree.node.TreeNode;

import java.util.Objects;

public class Lc530GetMinimumDifference {

    private int diffMin = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return diffMin;
    }

    public int[] dfs(TreeNode node) {
        if (Objects.isNull(node)) {
            return null;
        }
        int[] result = new int[]{node.val, node.val};
        if (Objects.nonNull(node.left)) {
            int[] left = dfs(node.left);
            diffMin = Math.min(diffMin, node.val - left[1]);
            result[0] = left[0];
        }
        if (Objects.nonNull(node.right)) {
            int[] right = dfs(node.right);
            diffMin = Math.min(diffMin, right[0] - node.val);
            result[1] = right[1];
        }
        return result;
    }
}
