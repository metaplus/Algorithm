package problem.greedy;

public class Lc1029TwoCitySchedCost {

    public int twoCitySchedCost(int[][] costs) {
        int[][] sorts = countSort(costs);
        int count = 0;
        for (int i = 0; i < sorts.length / 2; i++) {
            count += sorts[i][0];
        }
        for (int i = sorts.length / 2; i < sorts.length; i++) {
            count += sorts[i][1];
        }
        return count;
    }

    private static int[][] countSort(int[][] costs) {
        int minA = costs[0][0] - costs[0][1];
        int maxA = minA;
        for (int i = 1; i < costs.length; i++) {
            minA = Math.min(minA, costs[i][0] - costs[i][1]);
            maxA = Math.max(maxA, costs[i][0] - costs[i][1]);
        }
        int[] countA = new int[maxA - minA + 1];
        for (int[] cost : costs) {
            countA[cost[0] - cost[1] - minA]++;
        }
        for (int i = 1; i < countA.length; i++) {
            countA[i] += countA[i - 1];
        }
        int[][] sorts = new int[costs.length][2];
        for (int i = costs.length - 1; i >= 0; i--) {
            sorts[--countA[costs[i][0] - costs[i][1] - minA]] = costs[i];
        }
        return sorts;
    }
}
