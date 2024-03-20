package problem.array;

public class Lc1793MaximumScore {

    public int maximumScore(int[] nums, int k) {
        int[][] preMin = new int[nums.length][2];
        preMin[k][0] = nums[k];
        preMin[k][1] = k;
        for (int i = k + 1; i < nums.length; i++) {
            if (nums[i] > preMin[i - 1][0]) {
                preMin[i][0] = preMin[i - 1][0];
                preMin[i][1] = preMin[i - 1][1];
                continue;
            }
            preMin[i][0] = nums[i];
            preMin[i][1] = i;
        }
        for (int i = k - 1; i >= 0; i--) {
            if (nums[i] > preMin[i + 1][0]) {
                preMin[i][0] = preMin[i + 1][0];
                preMin[i][1] = preMin[i + 1][1];
                continue;
            }
            preMin[i][0] = nums[i];
            preMin[i][1] = i;
        }
        if (preMin[0][0] == preMin[k][0]
                && preMin[nums.length - 1][0] == preMin[k][0]) {
            return preMin[k][0] * nums.length;
        }
        int scoreMax = 0;
        for (int left = 0, right = nums.length - 1; left <= k && k <= right; ) {
            if (preMin[left][0] < preMin[right][0]) {
                scoreMax = Math.max(scoreMax, preMin[left][0] * (right - left + 1));
                left = preMin[left][1] + 1;
                continue;
            }
            scoreMax = Math.max(scoreMax, preMin[right][0] * (right - left + 1));
            right = preMin[right][1] - 1;
        }
        return scoreMax;
    }

    //        for (int left = 0, right = nums.length - 1; left <= k && k <= right; ) {
//            if (idMin < k) {
//                if (left <= idMin) {
//                    scoreMax = Math.max(scoreMax, valMin * (right - left + 1));
//                    left = idMin + 1;
//                    continue;
//                }
//                valMin = Integer.MAX_VALUE;
//                idMin = -1;
//                for (int i = left; i <= right; i++) {
//                    if (nums[i] < valMin) {
//                        valMin = nums[i];
//                        idMin = i;
//                    }
//                }
//                scoreMax = Math.max(scoreMax, valMin * (right - left + 1));
//                if (idMin > k) {
//                    right = idMin - 1;
//                    continue;
//                }
//                if (idMin < k) {
//                    left = idMin + 1;
//                    continue;
//                }
//                break;
//            }
//            if (right >= idMin) {
//                scoreMax = Math.max(scoreMax, valMin * (right - left + 1));
//                right = idMin - 1;
//                continue;
//            }
//            valMin = Integer.MAX_VALUE;
//            idMin = -1;
//            for (int i = left; i <= right; i++) {
//                if (nums[i] < valMin) {
//                    valMin = nums[i];
//                    idMin = i;
//                }
//            }
//            scoreMax = Math.max(scoreMax, valMin * (right - left + 1));
//            if (idMin > k) {
//                right = idMin - 1;
//                continue;
//            }
//            if (idMin < k) {
//                left = idMin + 1;
//                continue;
//            }
//            break;
//        }
}
