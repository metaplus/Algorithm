package problem.tree;

import problem.tree.node.TreeNode;

import java.util.Objects;

public class Lc114Flatten {

    public void flatten(TreeNode root) {
        TreeNode[] nodes = dfs(root);
    }

    public TreeNode[] dfs(TreeNode node) {
        if (Objects.isNull(node)) {
            return null;
        }
        TreeNode[] left = dfs(node.left);
        TreeNode[] right = dfs(node.right);
        if (Objects.isNull(left)) {
            if (Objects.isNull(right)) {
                return new TreeNode[]{node, node};
            }
            node.right = right[0];
            return new TreeNode[]{node, right[1]};
        }
        if (Objects.isNull(right)) {
            node.left = null;
            node.right = left[0];
            return new TreeNode[]{node, left[1]};
        }
        node.left = null;
        node.right = left[0];
        left[1].right = right[0];
        return new TreeNode[]{node, right[1]};
    }
}
