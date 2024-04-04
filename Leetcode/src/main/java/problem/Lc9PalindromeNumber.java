package problem;

import annotation.Problem;

@Problem(index = 9)
public class Lc9PalindromeNumber {

    public boolean isPalindrome(int number) {
        if (number < 0) {
            return false;
        }
        int[] digits = new int[20];
        int index = 0;
        do {
            int digit = number % 10;
            digits[index++] = digit;
        } while ((number = number / 10) > 0);
        for (int i = 0; i < index / 2; i++) {
            if (digits[i] != digits[index - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}
