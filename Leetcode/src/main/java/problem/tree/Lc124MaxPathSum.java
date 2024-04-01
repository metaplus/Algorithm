package problem.tree;

import problem.tree.node.TreeNode;

import java.util.Objects;

public class Lc124MaxPathSum {

    public int maxPathSum(TreeNode root) {
        State state = dfs(root);
        return Math.max(state.sum, state.max);
    }

    private State dfs(TreeNode node) {
        if (Objects.isNull(node)) {
            return new State(-2000, false, Integer.MIN_VALUE);
        }
        State left = dfs(node.left);
        State right = dfs(node.right);
        if (!left.connect && !right.connect) {
            int max = Math.max(node.val, Math.max(left.max, right.max));
            if (max == node.val) {
                return new State(max, true, Integer.MIN_VALUE);
            }
            return new State(max, false, Integer.MIN_VALUE);
        }
        if (left.connect && !right.connect) {
            int sum = left.max + node.val;
            int max = Math.max(node.val, sum);
            return new State(max, true, Math.max(Math.max(left.sum, right.max), left.max));
        }
        if (!left.connect && right.connect) {
            int sum = right.max + node.val;
            int max = Math.max(node.val, sum);
            return new State(max, true, Math.max(Math.max(right.sum, right.max), left.max));
        }
        int sum1 = left.max + node.val;
        int sum2 = right.max + node.val;
        int max = Math.max(Math.max(node.val, sum1), sum2);
        int sum3 = left.max + right.max + node.val;
        return new State(max, true, Math.max(Math.max(Math.max(Math.max(sum3, left.sum), right.sum), left.max), right.max));
    }

    private class State {
        int max;
        boolean connect;
        int sum;

        public State(int max, boolean connect, int sum) {
            this.max = max;
            this.connect = connect;
            this.sum = sum;
        }

        @Override
        public String toString() {
            return "State{" +
                    "max=" + max +
                    ", connect=" + connect +
                    ", sum=" + sum +
                    '}';
        }
    }
}
