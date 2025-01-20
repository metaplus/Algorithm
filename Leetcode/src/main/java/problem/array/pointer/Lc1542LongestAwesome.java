package problem.array.pointer;

import java.util.Objects;

public class Lc1542LongestAwesome {

    // tle
    public int longestAwesome(String s) {
        if (Objects.isNull(s) || s.isEmpty()) {
            return 0;
        }
        char[] chars = s.toCharArray();
        for (int i = chars.length; i >= 2; i--) {
            if (matchWindow(chars, i)) {
                return i;
            }
        }
        return 1;
    }

    private boolean matchWindow(char[] chars, int window) {
        int[] count = new int[10];
        int odd = 0;
        for (int i = 0; i < chars.length; i++) {
            if ((++count[chars[i] - '0']) % 2 == 1) {
                odd++;
            } else {
                odd--;
            }
            if (i < window - 1) {
                continue;
            }
            if (i > window - 1) {
                if ((--count[chars[i - window] - '0']) % 2 == 1) {
                    odd++;
                } else {
                    odd--;
                }
            }
            if (odd <= 1) {
                return true;
            }
        }
        return false;
    }

    //fail
    public int longestAwesome2(String s) {
        if (Objects.isNull(s) || s.isEmpty()) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int[] count = new int[10];
        int odd = 0;
        int left = 0;
        int lenMax = 0;
        for (int i = 0; i < chars.length; i++) {
            if ((++count[chars[i] - '0']) % 2 == 1) {
                odd++;
            } else {
                odd--;
            }
            if (odd <= 1) {
                int len = i - left + 1;
                lenMax = Math.max(len, lenMax);
                continue;
            }
            while (odd > 1 && left < i) {
                if ((--count[chars[left] - '0']) % 2 == 1) {
                    odd++;
                } else {
                    odd--;
                }
                left++;
            }
            if (odd <= 1) {
                int len = i - left + 1;
                lenMax = Math.max(len, lenMax);
            }
        }
        return lenMax;
    }
}
