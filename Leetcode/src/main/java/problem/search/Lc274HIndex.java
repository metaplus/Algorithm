package problem.search;

public class Lc274HIndex {
//    public int hIndex(int[] citations) {
//        Arrays.sort(citations);
//        int hMax = 0;
//        for (int i = citations.length - 1; i >= 0; i--) {
//            int val = Math.min(citations[i], citations.length - i);
//            val = Math.min(citations.length, val);
//            hMax = Math.max(val, hMax);
//        }
//        return hMax;
//    }

    public int hIndex(int[] citations) {
        int left = 0;
        int right = citations.length;
        while (left < right) {
            int mid = (left + right + 1) / 2;
//            int mid = (left + right) / 2;
            int count = hCount(citations, mid);
            if (count < mid) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public int hCount(int[] citations, int h) {
        int count = 0;
        for (int citation : citations) {
            if (citation >= h) {
                count++;
            }
        }
        return count;
    }
}
