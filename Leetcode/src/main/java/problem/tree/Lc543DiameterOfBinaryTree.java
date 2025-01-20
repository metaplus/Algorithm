package problem.tree;

import problem.tree.node.TreeNode;

import java.util.Objects;

public class Lc543DiameterOfBinaryTree {

    public int diameterOfBinaryTree(TreeNode root) {
        int[] result = dfs(root);
        return Math.max(result[0], result[1]-1);
    }

    private int[] dfs(TreeNode node) {
        if (Objects.isNull(node)) {
            return new int[]{0, 0};
        }
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
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
