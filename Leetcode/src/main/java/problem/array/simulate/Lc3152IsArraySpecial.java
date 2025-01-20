package problem.array.simulate;

import java.util.Arrays;

public class Lc3152IsArraySpecial {

    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i] % 2 == 0) ^ (nums[i - 1] % 2 == 0)) {
                dp[i] = dp[i - 1] + 1;
            }
        }

        boolean[] result = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = queries[i][1] - dp[queries[i][1]] + 1 <= queries[i][0];
        }
        return result;
    }

    public boolean[] isArraySpecial3(int[] nums, int[][] queries) {
        boolean[][] dp = new boolean[nums.length][nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            dp[i][i] = true;
            if (i == nums.length - 1) {
                continue;
            }
            boolean diff = (nums[i] % 2 == 0) ^ (nums[i + 1] % 2 == 0);
            for (int j = i + 1; j < nums.length; j++) {
                dp[i][j] = diff && dp[i + 1][j];
            }
        }
        boolean[] result = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = dp[queries[i][0]][queries[i][1]];
        }
        return result;
    }

    public boolean[] isArraySpecial2(int[] nums, int[][] queries) {
        Cell[] cells = new Cell[queries.length];
        Arrays.setAll(cells, i -> new Cell(queries[i], i));
        Arrays.sort(cells, (a, b) -> {
            if (a.query[1] != b.query[1]) {
                return Integer.compare(a.query[1], b.query[1]);
            }
            return Integer.compare(b.query[0], a.query[0]);
        });
        boolean[] result = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (i > 0 && cells[i].query[1] == cells[i - 1].query[1]) {
                if (result[cells[i - 1].index]) {
                    result[cells[i].index] = isArraySpecial(nums, cells[i].query[0], cells[i - 1].query[0]);
                }
                continue;
            }
            result[cells[i].index] = isArraySpecial(nums, cells[i].query[0], cells[i].query[1]);
        }
        return result;
    }

    public boolean isArraySpecial(int[] nums, int from, int to) {
        if (from == to) {
            return true;
        }
        for (int i = from + 1; i <= to; i++) {
            if (((nums[i] & 1) > 0) ^ ((nums[i - 1] & 1) > 0)) {
                continue;
            }
            return false;
        }
        return true;
    }

    private static class Cell {

        private int[] query;
        private int index;

        public Cell(int[] query, int index) {
            this.query = query;
            this.index = index;
        }

        @Override
        public String toString() {
            return "Cell{" +
                    "query=" + Arrays.toString(query) +
                    ", index=" + index +
                    '}';
        }
    }
}
