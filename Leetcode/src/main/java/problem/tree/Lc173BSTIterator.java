package problem.tree;

import problem.tree.node.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lc173BSTIterator {

    class BSTIterator {

        List<TreeNode> path = new ArrayList<>();

        public BSTIterator(TreeNode root) {
            path.add(root);
        }

        public int next() {
            if (path.isEmpty()) {
                return -1;
            }
            TreeNode node = path.get(path.size() - 1);
            path.remove(path.size() - 1);
            if (Objects.nonNull(node.right)) {
                path.add(node.right);
            }
            if (Objects.isNull(node.left)) {
                return node.val;
            }
            path.add(new TreeNode(node.val));
            if (Objects.nonNull(node.left)) {
                path.add(node.left);
            }
            return next();
        }

        public boolean hasNext() {
            return !path.isEmpty();
        }
    }

}
