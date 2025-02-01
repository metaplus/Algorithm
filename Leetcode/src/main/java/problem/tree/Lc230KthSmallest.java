package problem.tree;

import problem.tree.node.TreeNode;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class Lc230KthSmallest {

    int id = 0;
    TreeNode result;

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k,0);
        return result.val;
    }

    public int dfs(TreeNode node, int k, int pre) {
        if (node == null) {
            return 0;
        }
        if (result != null) {
            return 0;
        }
        int left = dfs(node.left, k, pre);
        if (pre + left + 1 == k) {
            result = node;
            return left + 1;
        }
        return left + 1 + dfs(node.right, k, pre + left + 1);
    }

    public int kthSmallest3(TreeNode root, int k) {
        dfs3(root, k);
        return result.val;
    }

    public int dfs3(TreeNode node, int k) {
        if (Objects.isNull(node)) {
            return -1;
        }
        int left = dfs3(node.left, k);
        if (left == k) {
            return left;
        }
        if (++id == k) {
            result = node;
            return k;
        }
        return dfs3(node.right, k);
    }

    public int kthSmallest2(TreeNode root, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, Comparator.reverseOrder());
        dfs3(root, k, queue);
        return queue.peek();
    }

    public void dfs3(TreeNode root, int k, PriorityQueue<Integer> queue) {
        if (Objects.isNull(root)) {
            return;
        }
        if (queue.size() < k) {
            queue.add(root.val);
        } else if (queue.peek() > root.val) {
            queue.remove();
            queue.offer(root.val);
        }
        dfs3(root.left, k, queue);
        dfs3(root.right, k, queue);
    }
}
