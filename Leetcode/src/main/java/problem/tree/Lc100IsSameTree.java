package problem.tree;

import problem.tree.node.TreeNode;

import java.util.Objects;

public class Lc100IsSameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (Objects.isNull(p)) {
            return Objects.isNull(q);
        }
        if (Objects.isNull(q)) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
