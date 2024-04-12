package problem.tree.search;

import problem.tree.node.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lc95GenerateTrees {

    public List<TreeNode> generateTrees(int n) {
        return dfs(1, n);
    }

    public List<TreeNode> dfs(int left, int right) {
        if (left > right) {
            return Collections.singletonList(null);
        }
        if (left == right) {
            return Collections.singletonList(new TreeNode(left));
        }
        List<TreeNode> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            List<TreeNode> leftNodes = dfs(left, i - 1);
            List<TreeNode> rightNodes = dfs(i + 1, right);
            for (TreeNode leftNode : leftNodes) {
                for (TreeNode rightNode : rightNodes) {
                    TreeNode node = new TreeNode(i);
                    node.left = leftNode;
                    node.right = rightNode;
                    result.add(node);
                }
            }
        }
        return result;
    }
}
