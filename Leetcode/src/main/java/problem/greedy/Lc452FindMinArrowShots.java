package problem.greedy;

import java.util.Arrays;

public class Lc452FindMinArrowShots {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> {
//            if (a[0] != b[0]) {
//                return Integer.compare(a[0], b[0]);
//            }
            return Integer.compare(a[1], b[1]);
        });
        int count = 1;
        int[] interval = points[0];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > interval[1]) {
                count++;
                interval = points[i];
            }
        }
        return count;
    }

    public int findMinArrowShots2(int[][] points) {
        radixSort(points);
        int arrow = 1;
        int right = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= right) {
                continue;
            }
            arrow++;
            right = points[i][1];
        }
        return arrow;
    }

    private void radixSort(int[][] points) {
        if (points.length < 2) {
            return;
        }
        int max = points[0][0];
        for (int[] row : points) {
            max = Math.max(max, row[1]);
        }
        int digit = findDigit(max);
        int[] counts = new int[19];
        int[][] sort = new int[points.length][2];
        int div = 1;
        for (int i = 0; i < digit; i++) {
            for (int[] row : points) {
                counts[(row[1] / div) % 10 + 9]++;
            }
            for (int j = 1; j < counts.length; j++) {
                counts[j] += counts[j - 1];
            }
            for (int j = points.length - 1; j >= 0; j--) {
                sort[--counts[(points[j][1] / div) % 10 + 9]] = points[j];
            }
            div *= 10;
            Arrays.fill(counts, 0);
            System.arraycopy(sort, 0, points, 0, points.length);
        }
    }

    private int findDigit(int max) {
        int digit = 0;
        for (int i = max; i > 0; i /= 10) {
            digit++;
        }
        return digit;
    }
}
