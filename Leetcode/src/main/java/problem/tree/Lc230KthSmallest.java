package problem.tree;

import problem.tree.node.TreeNode;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class Lc230KthSmallest {

    int id = 0;
    TreeNode result;

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return result.val;
    }

    public int dfs(TreeNode node, int k) {
        if (Objects.isNull(node)) {
            return -1;
        }
        int left = dfs(node.left, k);
        if (left == k) {
            return left;
        }
        if (++id == k) {
            result = node;
            return k;
        }
        return dfs(node.right, k);
    }

    public int kthSmallest2(TreeNode root, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, Comparator.reverseOrder());
        dfs2(root, k, queue);
        return queue.peek();
    }

    public void dfs2(TreeNode root, int k, PriorityQueue<Integer> queue) {
        if (Objects.isNull(root)) {
            return;
        }
        if (queue.size() < k) {
            queue.add(root.val);
        } else if (queue.peek() > root.val) {
            queue.remove();
            queue.offer(root.val);
        }
        dfs2(root.left, k, queue);
        dfs2(root.right, k, queue);
    }
}
