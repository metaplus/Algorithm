package problem.greedy;

import java.util.Arrays;

public class Lc1710MaximumUnits {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        countSort(boxTypes);
        int sum = 0;
        for (int i = boxTypes.length - 1; i >= 0 && truckSize > 0; i--) {
            int cost = Math.min(truckSize, boxTypes[i][0]);
            sum += boxTypes[i][1] * cost;
            truckSize -= cost;
        }
        return sum;
    }

    private void countSort(int[][] boxTypes) {
        if (boxTypes.length < 2) {
            return;
        }
        int min = boxTypes[0][1];
        int max = boxTypes[0][1];
        for (int i = 1; i < boxTypes.length; i++) {
            max = Math.max(max, boxTypes[i][1]);
            min = Math.min(min, boxTypes[i][1]);
        }
        int[] counts = new int[max - min + 1];
        for (int[] boxType : boxTypes) {
            counts[boxType[1] - min]++;
        }
        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }
        int[][] sort = new int[boxTypes.length][2];
        for (int[] boxType : boxTypes) {
            sort[--counts[boxType[1] - min]] = boxType;
        }
        System.arraycopy(sort, 0, boxTypes, 0, boxTypes.length);
    }
}
