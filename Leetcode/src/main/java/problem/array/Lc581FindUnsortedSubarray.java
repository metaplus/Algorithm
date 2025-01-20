package problem.array;

public class Lc581FindUnsortedSubarray {


    public int findUnsortedSubarray(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int[] preMax = new int[nums.length];
        int[] suffixMin = new int[nums.length];
        preMax[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preMax[i] = Math.max(preMax[i - 1], nums[i]);
        }
        suffixMin[nums.length - 1] = nums[nums.length - 1];
        for (int j = nums.length - 2; j >= 0; j--) {
            suffixMin[j] = Math.min(suffixMin[j + 1], nums[j]);
        }
        int left = -1;
        for (int i = 0; i < nums.length; i++) {
            if ( nums[i] <= suffixMin[i ]) {
                left = i;
                continue;
            }
            break;
        }
        int right=nums.length;
        for (int i = nums.length-1; i >left && i>1  ; i--) {
            if( nums[i]>=preMax[i]){
                right=i;
                continue;
            }
            break;
        }
        return right-left-1;
    }


    public int findUnsortedSubarray2(int[] nums) {
        int n = nums.length;
        int maxn = Integer.MIN_VALUE, right = -1;
        int minn = Integer.MAX_VALUE, left = -1;
        for (int i = 0; i < n; i++) {
            if (maxn > nums[i]) {
                right = i;
            } else {
                maxn = nums[i];
            }
            if (minn < nums[n - i - 1]) {
                left = n - i - 1;
            } else {
                minn = nums[n - i - 1];
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }


}
