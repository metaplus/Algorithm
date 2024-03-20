package problem.array;

public class Lc3086MinimumMoves {

    public long minimumMoves(int[] nums, int k, int maxChanges) {
        {
            int left = -1;
            int lenMax = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    left = -1;
                    continue;
                }
                if (left < 0) {
                    left = i;
                    lenMax = Math.max(lenMax, 1);
                    continue;
                }
                lenMax = Math.max(lenMax, i - left + 1);
            }
            lenMax = Math.min(lenMax, 3);
            if (lenMax == 0) {
                return 2L * k;
            }
            if (lenMax >= k) {
                return k - 1;
            }
            if (lenMax + maxChanges >= k) {
                return lenMax - 1 + 2L * (k - lenMax);
            }
        }
        int[] counts = new int[2];
        long costMin = Integer.MAX_VALUE;
        int midSum = 0;
        int win = Math.min(k, nums.length);
        for (int i = 0; i < nums.length; i++) {
            counts[nums[i]]++;
            if (nums[i] == 1) {
                midSum += i;
            }
            if (i - win >= 0) {
                counts[nums[i - win]]--;
                if (nums[i - win] == 1) {
                    midSum -= i - win;
                }
            }
            if (i - win + 1 < 0) {
                continue;
            }
            int mid = counts[1] > 0 ? midSum / counts[1] : nums.length / 2;
            int sum = nums[mid] == 1 ? 1 : 0;
            if (sum >= k) {
                return 0;
            }
            int edge = 0;
//            if (mid - 1 > i - win && nums[mid - 1] == 1) {
            if (mid - 1 >=0 && nums[mid - 1] == 1) {
                edge++;
            }
//            if (mid + 1 <= i && nums[mid + 1] == 1) {
            if (mid + 1 <nums.length && nums[mid + 1] == 1) {
                edge++;
            }
            if (sum + edge >= k) {
                costMin = Math.min(costMin, k - sum);
                continue;
            }
            long cost = edge;
            sum += edge;
            if (sum + maxChanges >= k) {
                cost += 2L * (k - sum);
                costMin = Math.min(costMin, cost);
                continue;
            }
            sum += maxChanges;
            cost += 2L * maxChanges;
            for (int left = mid - 2, right = mid + 2; sum < k; ) {
//                while (right <= i && nums[right] <= 0) {
                while (right < nums.length && nums[right] <= 0) {
                    right++;
                }
//                while (left >= i - win + 1 && nums[left] <= 0) {
                while (left >= 0 && nums[left] <= 0) {
                    left--;
                }
//                if (left < i - win + 1) {
                if (left < 0) {
                    cost += right - mid;
                    sum++;
                    right++;
                    continue;
                }
//                if (right > i) {
                if (right >= nums.length) {
                    cost += mid - left;
                    sum++;
                    left--;
                    continue;
                }
                if (mid - left < right - mid) {
                    cost += mid - left;
                    sum++;
                    left--;
                    continue;
                }
                cost += right - mid;
                sum++;
                right++;
            }
            costMin = Math.min(costMin, cost);
        }
        return costMin;
    }
}
