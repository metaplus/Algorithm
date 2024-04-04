package problem.tree;

import problem.tree.node.TreeNode;

import java.util.*;

public class Lc101IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        TreeNode nil = new TreeNode(-200);
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            if (size % 2 == 1 && deque.peek() != root) {
                return false;
            }
            List<TreeNode> list = new ArrayList<>(size);

            for (int i = 0; i < size; i++) {
                list.add(deque.poll());
            }
            for (int i = 0; i < size / 2; i++) {
                if (list.get(i).val != list.get(size - 1 - i).val) {
                    return false;
                }
            }
            for (TreeNode node : list) {
                if (Objects.isNull(node) || node == nil) {
                    continue;
                }
                deque.add(Objects.isNull(node.left) ? nil : node.left);
                deque.add(Objects.isNull(node.right) ? nil : node.right);
            }
        }
        return true;
    }
}
