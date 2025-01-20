package problem.search.binary;

public class Lc1011ShipWithinDays {

    public int shipWithinDays(int[] weights, int days) {
        int right = 0;
        int left = 0;
        for (int weight : weights) {
            right += weight;
            left = Math.max(left, weight);
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (countDays(weights, days, mid) > days) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int countDays(int[] weights, int days, int capacity) {
        int count = 1;
        int sum = 0;
        for (int weight : weights) {
            if (sum + weight <= capacity) {
                sum += weight;
                continue;
            }
            sum = weight;
            count++;
        }
        return count;
    }
}
