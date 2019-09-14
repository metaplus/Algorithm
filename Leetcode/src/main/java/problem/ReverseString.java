package problem;

import annotation.Problem;

/**
 * @Author: Jingxing Xu
 * @Date: 2019/9/14 17:55
 */
@Problem(index = 344,
        title = "Reverse String",
        description = "Write a function that reverses a string. The input string is given as an array of characters char[].\n" +
                "\n" +
                "Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.\n" +
                "\n" +
                "You may assume all the characters consist of printable ascii characters.")

public class ReverseString {
    public void reverseString(char[] s) {
        if (s == null || s.length <= 1) {
            return;
        }
        int left = 0;
        int right = s.length - 1;
        swapDoubleSides(s, left, right);
    }

    private void swapDoubleSides(char[] s, int left, int right) {
        char temp = s[right];
        s[right] = s[left];
        s[left] = temp;
        if (right - left <= 2) {
            return;
        }
        swapDoubleSides(s, left + 1, right - 1);
    }
}
