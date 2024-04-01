package problem.tree;

import problem.tree.node.TreeNode;

import java.util.Objects;

public class Lc104MaxDepth {


    public int maxDepth(TreeNode root) {
        return dfs(root, 0, 0);
    }

    public int dfs(TreeNode root, int depth, int depthMax) {
        if (Objects.isNull(root)) {
            return depthMax;
        }
        depth++;
        depthMax = Math.max(depth, depthMax);
        depthMax = Math.max(dfs(root.left, depth, depthMax), depthMax);
        depthMax = Math.max(dfs(root.right, depth, depthMax), depthMax);
        return depthMax;
    }
}
