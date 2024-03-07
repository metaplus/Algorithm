package problem.greedy;

public class Lc738MonotoneIncreasingDigits {

    public int monotoneIncreasingDigits(int n) {
        int[] digits = new int[10];
        for (int i = n, j = 0; i > 0; i /= 10, j++) {
            digits[j] = i % 10;
        }
        int right = digits.length - 1;
        for (int i = digits.length - 1; i > 0; i--) {
            if (digits[i] <= digits[i - 1]) {
                right = i - 1;
                continue;
            }
            break;
        }
        if (right == 0) {
            return n;
        }
        int left = right;
        for (int i = right + 1; i < digits.length; i++) {
            if (digits[i] != digits[right]) {
                break;
            }
            left = i;
        }
        digits[left] = Math.max(0, digits[left] - 1);
        for (int i = left + 1; i < digits.length; i++) {
            digits[i] = Math.min(digits[i - 1], digits[i]);
        }
        for (int i = 0; i < left; i++) {
            digits[i] = 9;
        }
        int mul = 0;
        for (int i = 0, div = 1; i < digits.length; i++, div *= 10) {
            mul += div * digits[i];
        }
        return mul;
    }
}
