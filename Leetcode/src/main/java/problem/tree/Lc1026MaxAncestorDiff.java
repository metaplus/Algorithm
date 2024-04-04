package problem.tree;

import problem.tree.node.TreeNode;

import java.util.Objects;

public class Lc1026MaxAncestorDiff {

    public int maxAncestorDiff(TreeNode root) {
        State state = dfs(root);
        return state.diffMax;
    }

    private State dfs(TreeNode node) {
        if (Objects.isNull(node)) {
            return null;
        }
        State left = dfs(node.left);
        State right = dfs(node.right);
        if (Objects.isNull(left)) {
            if (Objects.isNull(right)) {
                return new State(node.val, node.val, 0);
            }
            return new State(Math.min(node.val, right.left),
                    Math.max(node.val, right.right),
                    Math.max(right.diffMax, Math.max(Math.abs(node.val - right.left), Math.abs(node.val - right.right))));
        }
        if (Objects.isNull(right)) {
            return new State(Math.min(node.val, left.left),
                    Math.max(node.val, left.right),
                    Math.max(left.diffMax, Math.max(Math.abs(node.val - left.left), Math.abs(node.val - left.right))));
        }
        int diffMax = Math.max(left.diffMax, right.diffMax);
        diffMax = Math.max(diffMax, Math.max(Math.abs(node.val - left.left), Math.abs(node.val - left.right)));
        diffMax = Math.max(diffMax, Math.max(Math.abs(node.val - right.left), Math.abs(node.val - right.right)));
        return new State(Math.min(Math.min(node.val, left.left), right.left),
                Math.max(Math.max(node.val, left.right), right.right),
                diffMax);
    }

    private class State {
        int left;
        int right;
        int diffMax;

        public State(int left, int right, int diffMax) {
            this.left = left;
            this.right = right;
            this.diffMax = diffMax;
        }
    }
}
