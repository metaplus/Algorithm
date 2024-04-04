package problem.tree;

import problem.tree.node.TreeNode;

import java.util.Objects;

public class Lc98IsValidBST {


    public boolean isValidBST(TreeNode root) {
        return !dfs(root).fail;
    }

    public Cell dfs(TreeNode node) {
        if (Objects.isNull(node)) {
            return null;
        }
        Cell left = dfs(node.left);
        Cell right = dfs(node.right);
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
