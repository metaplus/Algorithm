package problem.array;

public class Lc42Trap {

    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        left[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }
        right[right.length - 1] = height[height.length - 1];
        for (int i = right.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            sum += Math.min(left[i], right[i]) - height[i];
        }
        return sum;
    }

    public int trap3(int[] height) {
        int[] preMax = new int[height.length];
        int[] sufMax = new int[height.length];
        preMax[0] = height[0];
        for (int i = 1; i < preMax.length; i++) {
            preMax[i] = Math.max(height[i], preMax[i - 1]);
        }
        sufMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            sufMax[i] = Math.max(height[i], sufMax[i + 1]);
        }
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int top = Math.min(preMax[i - 1], sufMax[i + 1]);
            if (top > height[i]) {
                sum += top - height[i];
            }
        }
        return sum;
    }

    public int trap2(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int water = 0;
        int preMax = 0;
        int subMax = 0;
        for (int left = 0, right = height.length - 1; left < right; ) {
            preMax = Math.max(height[left], preMax);
            subMax = Math.max(height[right], subMax);
            if (preMax < subMax) {
                water += preMax - height[left];
                left++;
                continue;
            }
            water += subMax - height[right];
            right--;
        }
        return water;
    }


}
