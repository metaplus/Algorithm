package problem.search.binary;

public class Lc702Search {

    public int search(ArrayReader reader, int target) {
        int inf = 2 << 31 - 1;
        int left = 0;
        int right = Integer.MAX_VALUE;
        int val = -1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            val = reader.get(mid);
            if (val == inf) {
                right = mid - 1;
                continue;
            }
            if (val < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return reader.get(left) == target ? left : -1;
    }

    // This is ArrayReader's API interface.
    // You should not implement it, or speculate about its implementation
    interface ArrayReader {
        public int get(int index);
    }
}
