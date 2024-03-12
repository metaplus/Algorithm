package problem.array;

public class Lc1423MaxScore {

    public int maxScore(int[] cardPoints, int k) {
        int lenMax = cardPoints.length - k;
        int sum = 0;
        for (int point : cardPoints) {
            sum += point;
        }
        int sumMin = sum;
        int sumWindow = 0;
        for (int i = 0; i < cardPoints.length; i++) {
            if (i < lenMax) {
                sumWindow += cardPoints[i];
                sumMin = sumWindow;
                continue;
            }
            sumWindow += cardPoints[i];
            sumWindow -= cardPoints[i - lenMax];
            sumMin = Math.min(sumWindow, sumMin);
        }
        return sum - sumMin;
    }
}
