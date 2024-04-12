package problem.tree;

import problem.tree.node.TreeNode;

import java.util.Objects;

public class Lc222CountNodes {

    public int countNodes(TreeNode root) {
        return dfs(root);
    }

    public int dfs(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        return dfs(root.left) + 1 + dfs(root.right);
    }
}
