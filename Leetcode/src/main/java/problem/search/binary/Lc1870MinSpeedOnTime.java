package problem.search.binary;

public class Lc1870MinSpeedOnTime {

    public int minSpeedOnTime(int[] dist, double hour) {
        int left = 1;
        int right = Integer.MAX_VALUE / 2 + 1;
        int bound = right;
        while (left < right) {
            int mid = left + (right - left) / 2;
            double sum = 0;
            for (int i = 0; i < dist.length; i++) {
                if (i < dist.length - 1) {
                    sum += (dist[i] + mid - 1) / mid;
                    continue;
                }
                sum += ((double) dist[i]) / mid;
            }
            if (sum > hour) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left == bound) {
            return -1;
        }
        return left;
    }
}
