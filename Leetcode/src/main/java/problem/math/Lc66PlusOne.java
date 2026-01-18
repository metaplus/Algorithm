package problem.math;

import java.util.Arrays;

public class Lc66PlusOne {

    public int[] plusOne(int[] digits) {
        int pre = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int next = digits[i] + pre;
            if (i == digits.length - 1) {
                next++;
            }
            if (next >= 10) {
                pre = 1;
                digits[i] = next - 10;
                continue;
            }
            pre = 0;
            digits[i] = next;
        }
        if (pre == 0) {
            return digits;
        }
        int[] result = new int[digits.length + 1];
        result[0] = pre;
        System.arraycopy(digits, 0, result, 1, digits.length);
        return result;
    }

    public int[] plusOne2(int[] digits) {
        if (digits[digits.length - 1] < 9) {
            digits[digits.length - 1]++;
            return digits;
        }
        for (int i = digits.length - 2; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                Arrays.fill(digits, i + 1, digits.length, 0);
                return digits;
            }
        }
        int[] sum = new int[digits.length + 1];
        sum[0] = 1;
        return sum;
    }
}
