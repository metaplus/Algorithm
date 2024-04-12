package problem.tree.search;

import problem.tree.node.TreeNode;

import java.util.Objects;

public class Lc538ConvertBST {

    public TreeNode convertBST(TreeNode root) {
        dfsGreat(root, 0);
        return root;
    }


    private int dfsGreat(TreeNode node, int preSum) {
        if (Objects.isNull(node)) {
            return 0;
        }
        int val = node.val;
        int right = dfsGreat(node.right, preSum);
        int left = dfsGreat(node.left, preSum + right + val);
        node.val = preSum + right + val;
        return val + left + right;
    }
}
