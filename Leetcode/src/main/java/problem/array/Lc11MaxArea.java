package problem.array;

public class Lc11MaxArea {

    public int maxArea(int[] height) {
        int result = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            int area = (j - i) * Math.min(height[i], height[j]);
            if (area > result) {
                result = area;
            }
            if (height[i] < height[j]) {
                i++;
                continue;
            }
            if (height[i] > height[j]) {
                j--;
                continue;
            }
            if (i + 2 == j) {
                i++;
                continue;
            }
            if (height[i + 1] > height[j - 1]) {
                i++;
            } else {
                j--;
            }
        }
        return result;
    }
}
