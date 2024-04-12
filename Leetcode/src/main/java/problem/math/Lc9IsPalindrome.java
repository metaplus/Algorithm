package problem.math;

import annotation.Problem;

@Problem(index = 9)
public class Lc9IsPalindrome {

    public boolean isPalindrome2(int number) {
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


    public boolean isPalindrome(int number) {
        if (number < 0) {
            return false;
        }
        long div = 1;
        while (div * 10 <= number) {
            div *= 10;
        }
        return dfs(number, number, (int) div);
    }

    private boolean dfs(int left, int right, int div) {
        if (left == right && left < 10) {
            return true;
        }
        int up = left / div;
        int down = right % 10;
        if (up != down) {
            return false;
        }
        return dfs(left % div, right / 10, div / 10);
    }
}
