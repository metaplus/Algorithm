package problem.search.binary;

public class Lc4FindMedianSortedArrays {


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size = nums1.length + nums2.length;
        if (size % 2 == 1) {
            return search(nums1, nums2, size / 2 + 1);
        }
        int left = search(nums1, nums2, size / 2);
        int right = search(nums1, nums2, size / 2 + 1);
        return (left + right) / 2.0;
    }

    public int search(int[] nums1, int[] nums2, int remain) {
        int len1 = 0;
        int len2 = 0;
        while (remain > 0) {
            if (len1 == nums1.length) {
                return nums2[len2 + remain - 1];
            }
            if (len2 == nums2.length) {
                return nums1[len1 + remain - 1];
            }
            if (remain == 1) {
                return Math.min(nums1[len1], nums2[len2]);
            }
            int left = Math.min(len1 + remain / 2, nums1.length);
            int right = Math.min(len2 + remain / 2, nums2.length);
            if (nums1[left - 1] < nums2[right - 1]) {
                remain -= left - len1;
                len1 = left;
                continue;
            }
            remain -= right - len2;
            len2 = right;
        }
        return Integer.MAX_VALUE / 2;
    }


    public double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            int[] nums = nums1.length == 0 ? nums2 : nums1;
            int len = nums1.length == 0 ? nums2.length : nums1.length;
            if (len % 2 == 1) {
                return nums[len / 2];
            }
            return ((double) nums[len / 2 - 1] + nums[len / 2]) / 2;
        }
        int total = nums1.length + nums2.length;
        int left = Math.min(nums1[0], nums2[0]);
        int right = Math.max(nums1[nums1.length - 1], nums2[nums2.length - 1]);
        while (left < right) {
            int mid = left + (right - left) / 2;
            int less1 = searchLessEqual(nums1, mid);
            int less2 = searchLessEqual(nums2, mid);
            if (less1 + less2 < total - less1 - less2) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (total % 2 == 1) {
            return left;
        }
        int half = left;
        right = Math.max(nums1[nums1.length - 1], nums2[nums2.length - 1]);
        while (left < right) {
            int mid = left + (right - left) / 2;
            int less1 = searchLessEqual(nums1, mid);
            int less2 = searchLessEqual(nums2, mid);
            if (less1 + less2 < total - less1 - less2 + 2) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return ((double) half + left) / 2;
    }

    public int searchLessEqual(int[] arr, int val) {
        int left = -1;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (arr[mid] > val) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left + 1;
    }

    // fail
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            if (nums2.length % 2 == 1) {
                return nums2[nums2.length / 2];
            }
            return ((double) nums2[nums2.length / 2 - 1] + nums2[nums2.length / 2]) / 2;
        }
        if (nums2.length == 0) {
            if (nums1.length % 2 == 1) {
                return nums1[nums1.length / 2];
            }
            return ((double) nums1[nums1.length / 2 - 1] + nums1[nums1.length / 2]) / 2;
        }
        int left = Math.min(nums1[0], nums2[0]);
        int right = Math.max(nums1[nums1.length - 1], nums2[nums2.length - 1]);
        double result = ((double) left + right) / 2;
        while (left < right) {
            double mid = ((double) left + right) / 2;
            int less1 = countLess(nums1, mid);
            int less2 = countLess(nums2, mid);
            int great1 = countGreater(nums1, mid);
            int great2 = countGreater(nums2, mid);
            if (less1 + less2 == great1 + great2) {
                return mid;
            } else if (less1 + less2 < great1 + great2) {
//                left = (int) mid + 1;
                left++;
            } else {
                result = mid;
//                right = (int) Math.floor(mid);
                right--;
            }
        }
//        return ((double) left + right) / 2;
        return left;
    }

    private int countLess(int[] nums, double value) {
        if (nums[nums.length - 1] < value) {
            return nums.length;
        }
        if (nums[0] > value) {
            return 0;
        }
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < value) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int countGreater(int[] nums, double value) {
        if (nums[0] > value) {
            return nums.length;
        }
        if (nums[nums.length - 1] < value) {
            return 0;
        }
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= value) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums.length - left;
    }
}
