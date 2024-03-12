package problem.array;

public class Lc643FindMaxAverage {

    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int sumMax = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                sum += nums[i];
                sumMax = sum;
                continue;
            }
            sum += nums[i];
            sum -= nums[i - k];
            sumMax = Math.max(sumMax, sum);
        }
        return (double) sumMax / k;
    }
}
