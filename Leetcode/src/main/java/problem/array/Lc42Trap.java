package problem.array;

public class Lc42Trap {

    public int trap(int[] height) {
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
