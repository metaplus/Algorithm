package problem.tree;

import problem.tree.node.TreeNode;

import java.util.*;

public class Lc107LevelOrderBottom {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (Objects.isNull(root)) {
            return new ArrayList<>();
        }
        Deque<List<Integer>> orders = new ArrayDeque<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> list = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                list.add(node.val);
                if (Objects.nonNull(node.left)) {
                    deque.offer(node.left);
                }
                if (Objects.nonNull(node.right)) {
                    deque.offer(node.right);
                }
            }
            orders.offerFirst(list);
        }
        return new ArrayList<>(orders);
    }
}
