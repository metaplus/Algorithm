package problem.tree;

import problem.tree.node.TreeNode;

import java.util.Objects;

public class Lc543DiameterOfBinaryTree {

    public int diameterOfBinaryTree(TreeNode root) {
        State state = dfs(root);
        return state.diaMax;
    }

    public State dfs(TreeNode node) {
        if (Objects.isNull(node)) {
            return new State(0, 0);
        }
        State left = dfs(node.left);
        State right = dfs(node.right);
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
