package problem.tree;

import problem.tree.node.TreeNode;

public class Lc105BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, inorder, 0, 0, preorder.length);
    }

    public TreeNode dfs(int[] preorder, int[] inorder, int left, int right, int len) {
        if (len == 0) {
            return null;
        }
        if (len == 1) {
            return new TreeNode(preorder[left]);
        }
        int mid = right;
        while (preorder[left] != inorder[mid]) {
            mid++;
        }
        TreeNode node = new TreeNode(preorder[left]);
        node.left = dfs(preorder, inorder, left + 1, right, mid - right);
        node.right = dfs(preorder, inorder, left + mid - right + 1, mid + 1, len - (mid - right + 1));
        return node;
    }
}
