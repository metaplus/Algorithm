package problem.array;

public class Lc11MaxArea {

    public int maxArea(int[] height) {
        int areaMax = 0;
        for (int left = 0, right = height.length - 1; left < right; ) {
            int area = (right - left) * Math.min(height[left], height[right]);
            areaMax = Math.max(area, areaMax);
            if (left + 1 == right) {
                break;
            }
            if (height[left] < height[right]) {
                left++;
                continue;
            }
//            if (Math.min(height[left + 1], height[right]) > Math.min(height[left], height[right - 1])) {
//                left++;
//                continue;
//            }
            right--;
        }

        return areaMax;
    }

    public int maxArea2(int[] height) {
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
