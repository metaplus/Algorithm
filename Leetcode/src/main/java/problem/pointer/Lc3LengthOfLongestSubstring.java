package problem.pointer;

public class Lc3LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int[] count = new int[128];
        int lenMax = 0;
        char[] chars = s.toCharArray();
        int left = 0;
        for (int i = 0; i < chars.length; i++) {
            if (count[chars[i]]++ < 1) {
                int len = i - left + 1;
                lenMax = Math.max(len, lenMax);
                continue;
            }
            for (int j = left; j < i; j++) {
                count[chars[j]]--;
                if (chars[j] == chars[i]) {
                    left = j + 1;
                    break;
                }
            }
        }
        return lenMax;
    }

}
