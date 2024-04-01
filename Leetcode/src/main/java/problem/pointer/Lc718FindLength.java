package problem.pointer;

public class Lc718FindLength {

    public int findLength(int[] nums1, int[] nums2) {
        int lenMax = 0;
        for (int i = -nums2.length + 1; i <= nums1.length - 1; i++) {
            int left = Math.max(0, i);
            int right = Math.min(nums1.length - 1, i + nums2.length - 1);
            if (i < 0) {
                int len = zipCount(nums1, left, nums2, -i, right - left + 1);
                lenMax = Math.max(len, lenMax);
                continue;
            }
            int len = zipCount(nums1, left, nums2, 0, right - left + 1);
            lenMax = Math.max(len, lenMax);
        }
        return lenMax;
    }

    private int zipCount(int[] arr1, int left, int[] arr2, int right, int len) {
        int count = 0;
        int countMax = 0;
        for (int i = 0; i < len; i++) {
            if (arr1[left + i] == arr2[right + i]) {
                count++;
                countMax = Math.max(count, countMax);
            } else {
                count = 0;
            }
        }
        return countMax;
    }

    //timeout
    public int findLength2(int[] nums1, int[] nums2) {
        for (int win = Math.min(nums1.length, nums2.length); win > 0; win--) {
            for (int i = 0; i < nums1.length - win + 1; i++) {
                for (int j = 0; j < nums2.length - win + 1; j++) {
                    if (equal(nums1, i, nums2, j, win)) {
                        return win;
                    }
                }
            }
        }

        return 0;
    }

    private boolean equal(int[] nums1, int i, int[] nums2, int j, int length) {
        for (int left = i, right = j; left < i + length; left++, right++) {
            if (nums1[left] != nums2[right]) {
                return false;
            }
        }
        return true;
    }
}
