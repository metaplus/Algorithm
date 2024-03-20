package problem.tree;

import problem.tree.node.TreeNode;

import java.util.*;

public class Lc102LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (Objects.isNull(root)) {
            return new ArrayList<>();
        }
        List<List<Integer>> orders = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> list = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                list.add(node.val);
                if (Objects.nonNull(node.left)) {
                    deque.add(node.left);
                }
                if (Objects.nonNull(node.right)) {
                    deque.add(node.right);
                }
            }
            orders.add(list);
        }
        return orders;
    }
}
