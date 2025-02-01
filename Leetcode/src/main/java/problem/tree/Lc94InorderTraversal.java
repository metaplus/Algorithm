package problem.tree;

import problem.tree.node.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lc94InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    private void dfs(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        dfs(node.left, list);
        list.add(node.val);
        dfs(node.right, list);
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, 0, list);
        return list;
    }

    private void dfs(TreeNode node, int id, List<Integer> list) {
        if (Objects.isNull(node)) {
            return;
        }
        list.add(id, node.val);
        dfs(node.right, id + 1, list);
        dfs(node.left, id, list);
    }
}
