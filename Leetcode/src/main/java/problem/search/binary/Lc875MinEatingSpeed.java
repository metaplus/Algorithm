package problem.search.binary;

public class Lc875MinEatingSpeed {

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int pile : piles) {
            right = Integer.max(right, pile);
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (countHours(piles, mid) > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int countHours(int[] piles, int k) {
        int sum = 0;
        for (int pile : piles) {
            sum += (pile + k - 1) / k;
//            if (pile % k != 0) {
//                sum += 1;
//            }
        }
        return sum;
    }
}
