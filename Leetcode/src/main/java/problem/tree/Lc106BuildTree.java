package problem.tree;

import problem.tree.node.TreeNode;

public class Lc106BuildTree {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return dfs(inorder, postorder, 0, 0, inorder.length);
    }

    public TreeNode dfs(int[] inorder, int[] postorder, int left, int right, int len) {
        if (len == 0) {
            return null;
        }
        if (len == 1) {
            return new TreeNode(postorder[right + len - 1]);
        }
        TreeNode node = new TreeNode(postorder[right + len - 1]);
        for (int i = left + len - 1; i >= left; i--) {
            if (inorder[i] == node.val) {
                node.left = dfs(inorder, postorder, left, right, i - left);
                node.right = dfs(inorder, postorder, i + 1, right + i - left, len - (i - left + 1));
                break;
            }
        }
        return node;
    }
}
