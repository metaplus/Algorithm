package problem.tree;

import problem.tree.node.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lc437PathSum {


    public int pathSum(TreeNode root, int targetSum) {
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
