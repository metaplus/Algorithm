package problem.array.pointer;

public class Lc3176MaximumLength {

    //fail
    public int maximumLength(int[] nums, int k) {
        int left = 0;
        int p = k;
        if (nums[nums.length - 1] == nums[0] || k > 0) {
            left = nums.length - 1;
            if (nums[nums.length - 1] != nums[0]) {
                k--;
            }
            while (left > 1) {
                if (nums[left] == nums[left - 1]) {
                    left--;
                    continue;
                }
                if (k == 0) {
                    break;
                }
                k--;
                left--;
//                if (left == 1
//                        && k == 0
//                        && nums[1] != nums[0]
//                        && p != k) {
//                    left++;
//                }
            }
        }
        int lenMax = 1;
        if (left > 0) {

//            if (left == 1
//                    && nums[left] != nums[0]
//                    && nums.length > 2
//                    && k == 0) {
//                left = (left + 1) % nums.length;
//            }
            lenMax += nums.length - left;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                if (k > 0) {
                    k--;
                } else {
                    while (true) {
                        int next = (left + 1) % nums.length;
                        if (nums[next] != nums[left]) {
                            left = next;
                            break;
                        }
                        left = next;
                    }
                }
            }
            if (left <= i) {
                int len = i - left + 1;
                lenMax = Math.max(len, lenMax);
                continue;
            }
            int len = i + 1;
            len += nums.length - left;
            lenMax = Math.max(len, lenMax);
        }
        return lenMax;
    }
}
