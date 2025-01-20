package problem.tree;

import problem.tree.node.TreeNode;

import java.util.*;

public class Lc437PathSum {

    public Map<Long, Integer> state = new HashMap<>(32);

    public int  pathSum(TreeNode root, int targetSum) {
        dfs(root);
        return state.getOrDefault(Long.valueOf(targetSum) , 0);
    }

    public Map<Long, Integer> dfs(TreeNode node) {
        if (Objects.isNull(node)) {
            return Collections.emptyMap();
        }
        Map<Long, Integer> left = dfs(node.left);
        Map<Long, Integer> right = dfs(node.right);
        Map<Long, Integer> count = new HashMap<>(Math.max(left.size(), right.size()));
        for (Map.Entry<Long, Integer> entry : left.entrySet()) {
            count.merge(entry.getKey() + node.val, entry.getValue(), Integer::sum);
        }
        for (Map.Entry<Long, Integer> entry : right.entrySet()) {
            count.merge(entry.getKey() + node.val, entry.getValue(), Integer::sum);
        }
        count.merge((long) node.val, 1, Integer::sum);
        for (Map.Entry<Long, Integer> entry : count.entrySet()) {
            state.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }
        return count;
    }

    public int pathSum2(TreeNode root, int targetSum) {
        return dfs(root, targetSum, new ArrayList<>());
    }

    public int dfs(TreeNode node, int targetSum, List<Integer> path) {
        if (Objects.isNull(node)) {
            return 0;
        }
        path.add(node.val);
        int count = 0;
        long sum = 0;
        for (int i = path.size() - 1; i >= 0; i--) {
            sum += (long) path.get(i);
            if (targetSum == sum) {
                count++;
            }
        }
        count += dfs(node.left, targetSum, path);
        count += dfs(node.right, targetSum, path);
        path.remove(path.size() - 1);
        return count;
    }
}
