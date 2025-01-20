package problem.bit;

public class Lc3007FindMaximumNumber {

//    public long findMaximumNumber(long k, int x) {
//        int left = 1;
//        int right = Integer.MAX_VALUE / 4;
//        while (left < right) {
//            int mid = left + (right - left) / 2;
//            if (sumDigits(mid, x) <= k) {
//                left = mid + 1;
//            } else {
//                right = mid;
//            }
//        }
//        return left-1;
//    }
//
//    private int sumDigits(int max, int x) {
//        int sum = 0;
//        for (int i = 1; i <= max; i++) {
//            int add = 0;
//            for (int j = i >> (x - 1); j > 0; j >>= x) {
//                add += j & 1;
//            }
//            sum += add;
//        }
//        return sum;
//    }

    // timeout
    public long findMaximumNumber(long k, int x) {
        int sum = 0;
        int result = 0;
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            int add = 0;
            for (int j = i >> (x - 1); j > 0; j >>= x) {
                add += j & 1;
            }
            if (sum + add > k) {
                break;
            }
            sum += add;
            result = i;
        }
        return result;
    }
}
