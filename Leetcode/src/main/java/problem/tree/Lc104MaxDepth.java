package problem.tree;

import problem.tree.node.TreeNode;

import java.util.Objects;

public class Lc104MaxDepth {


    public int maxDepth(TreeNode root) {
        return dfs(root);
    }


    private int dfs(TreeNode node) {
        if (Objects.isNull(node)) {
            return 0;
        }
        return 1 + Math.max(dfs(node.left), dfs(node.right));
    }

    public int maxDepth2(TreeNode root) {
        return dfs2(root, 0, 0);
    }


    public int dfs2(TreeNode root, int depth, int depthMax) {
        if (Objects.isNull(root)) {
            return depthMax;
        }
        depth++;
        depthMax = Math.max(depth, depthMax);
        depthMax = Math.max(dfs2(root.left, depth, depthMax), depthMax);
        depthMax = Math.max(dfs2(root.right, depth, depthMax), depthMax);
        return depthMax;
    }
}
