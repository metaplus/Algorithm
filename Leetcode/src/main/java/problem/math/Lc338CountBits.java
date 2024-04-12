package problem.math;

public class Lc338CountBits {

    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i < result.length; i++) {
            if (i >= 2 && i % 2 == 0) {
                result[i] = result[i / 2];
                continue;
            }
            int val = i;
            while (val > 0) {
                if ((val & 1) == 1) {
                    result[i]++;
                }
                val >>= 1;
            }
        }
        return result;
    }
}
