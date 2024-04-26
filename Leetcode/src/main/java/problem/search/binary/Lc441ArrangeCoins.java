package problem.search.binary;

public class Lc441ArrangeCoins {


    public int arrangeCoins(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if ((long) mid * (mid + 1) / 2 > n) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public int arrangeCoins2(int n) {
        long sum = 0;
        int level = 1;
        while (sum < n) {
            sum += level;
            level++;
        }
        return sum == n ? level - 1 : level - 2;
    }
}
