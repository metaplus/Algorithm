package problem.tree;

import problem.tree.node.TreeNode;

import java.util.Objects;

public class Lc124MaxPathSum {

    private static final int INF = Integer.MIN_VALUE / 2;

    public int maxPathSum(TreeNode root) {
        State state = dfs(root);
        return Math.max(state.xMax, state.yMax);
    }

    private State dfs(TreeNode node) {
        if (Objects.isNull(node)) {
            return new State(INF, INF);
        }
        if (Objects.isNull(node.left) && Objects.isNull(node.right)) {
            return new State(node.val, node.val);
        }
        State left = dfs(node.left);
        State right = dfs(node.right);
        int yMax = node.val + Math.max(left.yMax, right.yMax);
        yMax = Math.max(yMax, node.val);
        int xMax = Math.max(left.xMax, right.xMax);
        xMax = Math.max(xMax, yMax);
        xMax = Math.max(xMax, node.val + left.yMax + right.yMax);
        return new State(xMax, yMax);
    }

    public int maxPathSum2(TreeNode root) {
        State2 state = dfs2(root);
        return Math.max(state.sum, state.max);
    }

    private State2 dfs2(TreeNode node) {
        if (Objects.isNull(node)) {
            return new State2(-2000, false, Integer.MIN_VALUE);
        }
        State2 left = dfs2(node.left);
        State2 right = dfs2(node.right);
        if (!left.connect && !right.connect) {
            int max = Math.max(node.val, Math.max(left.max, right.max));
            if (max == node.val) {
                return new State2(max, true, Integer.MIN_VALUE);
            }
            return new State2(max, false, Integer.MIN_VALUE);
        }
        if (left.connect && !right.connect) {
            int sum = left.max + node.val;
            int max = Math.max(node.val, sum);
            return new State2(max, true, Math.max(Math.max(left.sum, right.max), left.max));
        }
        if (!left.connect && right.connect) {
            int sum = right.max + node.val;
            int max = Math.max(node.val, sum);
            return new State2(max, true, Math.max(Math.max(right.sum, right.max), left.max));
        }
        int sum1 = left.max + node.val;
        int sum2 = right.max + node.val;
        int max = Math.max(Math.max(node.val, sum1), sum2);
        int sum3 = left.max + right.max + node.val;
        return new State2(max, true, Math.max(Math.max(Math.max(Math.max(sum3, left.sum), right.sum), left.max), right.max));
    }

    private class State {

        private int xMax;

        private int yMax;

        public State(int xMax, int yMax) {
            this.xMax = xMax;
            this.yMax = yMax;
        }
    }

    private class State2 {
        int max;
        boolean connect;
        int sum;

        public State2(int max, boolean connect, int sum) {
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
