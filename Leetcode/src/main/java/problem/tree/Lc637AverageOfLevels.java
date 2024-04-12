package problem.tree;

import problem.tree.node.TreeNode;

import java.util.*;

public class Lc637AverageOfLevels {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                sum += deque.peek().val;
                if (Objects.nonNull(deque.peek().left)) {
                    deque.offer(deque.peek().left);
                }
                if (Objects.nonNull(deque.peek().right)) {
                    deque.offer(deque.peek().right);
                }
                deque.poll();
            }
            result.add(sum / size);
        }
        return result;
    }
}
