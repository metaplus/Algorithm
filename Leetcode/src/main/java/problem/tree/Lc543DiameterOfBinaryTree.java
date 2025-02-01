package problem.tree;

import problem.tree.node.TreeNode;

import java.util.Objects;

public class Lc543DiameterOfBinaryTree {

    private int diameterMax = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return diameterMax - 1;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        diameterMax = Math.max(diameterMax, left + right + 1);
        return Math.max(left, right) + 1;
    }

    public int diameterOfBinaryTree3(TreeNode root) {
        int[] result = dfs3(root);
        return Math.max(result[0], result[1] - 1);
    }

    private int[] dfs3(TreeNode node) {
        if (Objects.isNull(node)) {
            return new int[]{0, 0};
        }
        int[] left = dfs3(node.left);
        int[] right = dfs3(node.right);
        return new int[]{
                Math.max(left[1] + right[1], Math.max(left[0], right[0])),
                Math.max(left[1], right[1]) + 1,
        };
    }


    public int diameterOfBinaryTree2(TreeNode root) {
        State state = dfs2(root);
        return state.diaMax;
    }

    public State dfs2(TreeNode node) {
        if (Objects.isNull(node)) {
            return new State(0, 0);
        }
        State left = dfs2(node.left);
        State right = dfs2(node.right);
        int diaMax = Math.max(left.diaMax, right.diaMax);
        diaMax = Math.max(diaMax, left.pathMax + right.pathMax);
        return new State(Math.max(left.pathMax, right.pathMax) + 1, diaMax);
    }

    private class State {

        int pathMax;
        int diaMax;

        public State(int pathMax, int diaMax) {
            this.pathMax = pathMax;
            this.diaMax = diaMax;
        }
    }
}
