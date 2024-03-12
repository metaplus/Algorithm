package problem.array;

public class Lc992SubArraysWithKDistinct {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int[] counts = new int[nums.length + 1];
        int distinct = 0;
        int comb = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (counts[nums[i]]++ == 0) {
                distinct++;
            }
            if (distinct < k) {
                continue;
            }
            if (distinct == k) {
                comb++;
                for (int j = left; j <= i; j++) {
                    if (counts[nums[j]] > 1) {
                        counts[nums[j]]--;
                        comb++;
                        continue;
                    }
                    for (int l = left; l < j; l++) {
                        counts[nums[l]]++;
                    }
                    break;
                }
            }
            for (int j = left; j < i && distinct > k; j++) {
                left = j + 1;
                if (counts[nums[j]]-- == 1) {
                    if (--distinct == k) {
                        comb++;
                        for (int l = left; l <= i; l++) {
                            if (counts[nums[l]] > 1) {
                                counts[nums[l]]--;
                                comb++;
                                continue;
                            }
                            for (int m = left; m < l; m++) {
                                counts[nums[m]]++;
                            }
                            break;
                        }
                        break;
                    }
                }
            }
        }
        return comb;
    }
}
