package problem.tree;

import problem.tree.node.TreeNode;

import java.util.*;

public class Lc103ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (Objects.isNull(root)) {
            return new ArrayList<>();
        }
        List<List<Integer>> orders = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            Deque<Integer> level = new ArrayDeque<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                if (orders.size() % 2 == 1) {
                    level.offerFirst(node.val);
                } else {
                    level.offerLast(node.val);
                }
                if (Objects.nonNull(node.left)) {
                    deque.offer(node.left);
                }
                if (Objects.nonNull(node.right)) {
                    deque.offer(node.right);
                }
            }
            orders.add(new ArrayList<>(level));
        }
        return orders;
    }
}
