package problem.search;

public class Lc69MySqrt {

    public int mySqrt(int x) {
        long left = 0;
        long right = x;
        while (left < right) {
            long mid = (left + right + 1) / 2;
            if (mid * mid > x) {
                right = (int) mid - 1;
            } else {
                left = (int) mid;
            }
        }
        return (int) left;
    }

    public int mySqrt2(int x) {
        long left = 0;
        long right = x;
        while (left < right) {
            long mid = left + right >> 1;
            if (mid * mid < x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left * left > x ? (int) left - 1 : (int) left;
    }
}
