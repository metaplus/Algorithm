package problem.dp.prefix;

public class Lc1014MaxScoreSightseeingPair {

    public int maxScoreSightseeingPair(int[] values) {
        int[] pre = new int[values.length];
        int result = Integer.MIN_VALUE;
        pre[0] = values[0];
        for (int i = 1; i < values.length; i++) {
            result = Math.max(result, pre[i - 1] + values[i] - i);
            pre[i] = Math.max(pre[i - 1], values[i] + i);
        }
        return result;
    }
}
