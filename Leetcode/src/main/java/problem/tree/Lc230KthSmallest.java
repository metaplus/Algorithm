package problem.tree;

import problem.tree.node.TreeNode;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class Lc230KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, Comparator.reverseOrder());
        dfs(root, k, queue);
        return queue.peek();
    }

    public void dfs(TreeNode root, int k, PriorityQueue<Integer> queue) {
        if (Objects.isNull(root)) {
            return;
        }
        if (queue.size() < k) {
            queue.add(root.val);
        } else if (queue.peek() > root.val) {
            queue.remove();
            queue.offer(root.val);
        }
        dfs(root.left, k, queue);
        dfs(root.right, k, queue);
    }
}
