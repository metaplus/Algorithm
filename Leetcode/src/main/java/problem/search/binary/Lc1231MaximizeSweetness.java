package problem.search.binary;

public class Lc1231MaximizeSweetness {

    public int maximizeSweetness(int[] sweetness, int k) {
        int left = 1;
        int right = Integer.MAX_VALUE/2;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 1;
            int sum = 0;
            for (int j : sweetness) {
                if (sum < mid) {
                    sum += j;
                    continue;
                }
                count++;
                sum = j;
            }
            if (sum < mid && sum > 0) {
                count--;
            }
            if (count >= k + 1) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left - 1;
    }
}
