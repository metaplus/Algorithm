package problem.tree;

import problem.tree.node.TreeNode;

import java.util.Objects;

public class Lc98IsValidBST {

    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean dfs(TreeNode node, long low, long up) {
        if (Objects.isNull(node)) {
            return true;
        }
        if (node.val <= low || node.val >= up) {
            return false;
        }
        return dfs(node.left, low, node.val) && dfs(node.right, node.val,up );
    }

    public boolean isValidBST2(TreeNode root) {
        return !dfs2(root).fail;
    }

    public Cell dfs2(TreeNode node) {
        if (Objects.isNull(node)) {
            return null;
        }
        Cell left = dfs2(node.left);
        Cell right = dfs2(node.right);
        if (Objects.isNull(left)) {
            if (Objects.isNull(right)) {
                return new Cell(node.val, node.val, false);
            }
            if (right.fail) {
                return right;
            }
            if (right.left <= node.val) {
                return new Cell(0, 0, true);
            }
            return new Cell(node.val, right.right, false);
        }
        if (left.fail) {
            return left;
        }
        if (left.right >= node.val) {
            return new Cell(0, 0, true);
        }
        if (Objects.isNull(right)) {
            return new Cell(left.left, node.val, false);
        }
        if (right.left <= node.val) {
            return new Cell(0, 0, true);
        }
        return new Cell(left.left, right.right, false);
    }

    private class Cell {
        int left;
        int right;
        boolean fail;

        public Cell(int left, int right, boolean fail) {
            this.left = left;
            this.right = right;
            this.fail = fail;
        }
    }
}
