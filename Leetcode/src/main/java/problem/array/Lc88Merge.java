package problem.array;

public class Lc88Merge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int first = m - 1;
        int second = n - 1;
        for (int i = nums1.length - 1; i >= 0; i--) {
            if (first >= 0) {
                if (second >= 0 && nums2[second] > nums1[first]) {
                    nums1[i] = nums2[second];
                    second--;
                    continue;
                }
                nums1[i] = nums1[first];
                first--;
                continue;
            }
            nums1[i] = nums2[second];
            second--;
        }
    }
}
