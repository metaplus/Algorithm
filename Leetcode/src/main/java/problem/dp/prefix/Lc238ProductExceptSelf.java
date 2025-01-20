package problem.dp.prefix;

public class Lc238ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] preMul = new int[nums.length];
        int[] sufMul = new int[nums.length];
        preMul[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preMul[i] = preMul[i - 1] * nums[i];
        }
        sufMul[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            sufMul[i] = sufMul[i + 1] * nums[i];
        }
        int[] res = new int[nums.length];
        res[0] = sufMul[1];
        res[nums.length - 1] = preMul[nums.length - 2];
        for (int i = 1; i < nums.length - 1; i++) {
            res[i] = preMul[i - 1] * sufMul[i + 1];
        }
        return res;
    }
}
