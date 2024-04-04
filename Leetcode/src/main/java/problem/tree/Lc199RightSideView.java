package problem.tree;

import problem.tree.node.TreeNode;

import java.util.*;

public class Lc199RightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        if (Objects.isNull(root)) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                TreeNode node = deque.poll();
                if (size == 0) {
                    result.add(node.val);
                }
                if (Objects.nonNull(node.left)) {
                    deque.add(node.left);
                }
                if (Objects.nonNull(node.right)) {
                    deque.add(node.right);
                }
            }
        }
        return result;
    }
}
