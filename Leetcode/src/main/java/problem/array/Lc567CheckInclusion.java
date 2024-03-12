package problem.array;

import java.util.Arrays;

public class Lc567CheckInclusion {

    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (char c : s1.toCharArray()) {
            count1[c - 'a']++;
        }
        char[] chars = s2.toCharArray();
        int left = 0;
        for (int i = 0; i < chars.length; i++) {
            if (count1[chars[i] - 'a'] == 0) {
                Arrays.fill(count2, 0);
                left = i + 1;
                continue;
            }
            int len = i - left + 1;
            count2[chars[i] - 'a']++;
            if (len < s1.length()) {
                continue;
            }
            if (len > s1.length()) {
                count2[chars[left] - 'a']--;
                left++;
            }
            if (Arrays.equals(count1, count2)) {
                return true;
            }
        }
        return false;
    }
}
