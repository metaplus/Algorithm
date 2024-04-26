package problem.search.binary;

public class Lc275HIndex {

    public int hIndex(int[] citations) {
        int left = 0;
        int right = citations.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] < citations.length - mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return citations.length - left;
    }
}
