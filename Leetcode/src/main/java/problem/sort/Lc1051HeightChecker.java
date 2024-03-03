package problem.sort;

public class Lc1051HeightChecker {

    public int heightChecker(int[] heights) {
        int min = heights[0];
        int max = heights[0];
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > max) {
                max = heights[i];
                continue;
            }
            if (heights[i] < min) {
                min = heights[i];
            }
        }
        int[] counts = new int[max - min + 1];
        for (int height : heights) {
            counts[height - min]++;
        }
        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }
        int result = 0;
        for (int i = 0; i < heights.length; i++) {
            if (i >= counts[heights[i] - min]) {
                result++;
                continue;
            }
            if (heights[i] - min > 0 && i < counts[heights[i] - min - 1]) {
                result++;
            }
        }
        return result;
    }

}
