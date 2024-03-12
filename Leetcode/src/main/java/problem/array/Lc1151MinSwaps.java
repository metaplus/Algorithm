package problem.array;

public class Lc1151MinSwaps {

    public int minSwaps(int[] data) {
        int allOne = 0;
        for (int datum : data) {
            if (datum > 0) {
                allOne++;
            }
        }
        if (allOne < 2) {
            return 0;
        }
        int left = 0;
        int countZero = 0;
        int countMin = Integer.MAX_VALUE;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == 0) {
                countZero++;
            }
            int len = i - left + 1;
            if (len < allOne) {
                continue;
            }
            if (len == allOne) {
                countMin = Math.min(countMin, countZero);
                if (data[left] == 0) {
                    countZero--;
                }
                left++;
            }
        }
        return countMin;
    }
}
