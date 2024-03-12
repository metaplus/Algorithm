package problem.array;

public class Lc845LongestMountain {

    public int longestMountain(int[] arr) {
        int left = -1;
        int mid = 0;
        int lenMax = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                if (left < 0) {
                    left = i - 1;
                }
                if (i > mid + 1) {
                    left = i - 1;
                }
                mid = i;
                continue;
            }
            if (arr[i] == arr[i - 1]) {
                left = -1;
                mid = -1;
                continue;
            }
            if (left < 0) {
                continue;
            }
            int len = i - left + 1;
            lenMax = Math.max(len, lenMax);
        }
        return lenMax;
    }
}
