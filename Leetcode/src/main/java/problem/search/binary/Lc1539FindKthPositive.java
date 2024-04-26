package problem.search.binary;

public class Lc1539FindKthPositive {

    public int findKthPositive(int[] arr, int k) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] - mid - 1 < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left == 0) {
            return k;
        }
        return arr[left - 1] + k - (arr[left - 1] - left);
    }
}
