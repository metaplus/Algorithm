package problem.array;

public class Lc1176DietPlanPerformance {

    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int score = 0;
        int sum = 0;
        for (int i = 0; i < calories.length; i++) {
            sum += calories[i];
            if (i < k - 1) {
                continue;
            }
            if (i - k >= 0) {
                sum -= calories[i - k];
            }
            if (sum > upper) {
                score++;
            }
            if (sum < lower) {
                score--;
            }
        }
        return score;
    }
}
