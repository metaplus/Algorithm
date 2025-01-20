package problem.dp.state;

import java.util.Arrays;
import java.util.Comparator;

public class Lc1235JobScheduling {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        Cell[] cells = new Cell[startTime.length];
        Arrays.setAll(cells, i -> new Cell(startTime[i], endTime[i], profit[i]));
        Arrays.sort(cells, Comparator.comparingInt(cell -> cell.endTime));
        int[] dp = new int[startTime.length];
        dp[0] = cells[0].profit;
        for (int i = 1; i < cells.length; i++) {
            dp[i] = Math.max(cells[i].profit, dp[i - 1]);
            int left = -1;
            int right = i - 1;
            while (left < right) {
                int mid = left + (right - left + 1) / 2;
                if (cells[mid].endTime > cells[i].startTime) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }
            if (left >= 0) {
                dp[i] = Math.max(dp[i], dp[left] + cells[i].profit);
            }
        }
        return dp[startTime.length-1];
    }


    private static class Cell {

        private int startTime;
        private int endTime;
        private int profit;

        public Cell(int startTime, int endTime, int profit) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }

        @Override
        public String toString() {
            return "Cell{" +
                    "startTime=" + startTime +
                    ", endTime=" + endTime +
                    ", profit=" + profit +
                    '}';
        }
    }
}
