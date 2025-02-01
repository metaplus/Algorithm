package problem.array.pointer;

public class Lc3LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int[] count = new int[128];
        int lenMax = 1;
        int left = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            count[chars[i]]++;
            while (count[chars[i]] > 1 && left < i) {
                count[chars[left++]]--;
            }
            lenMax = Math.max(lenMax, i - left + 1);
        }
        return lenMax;
    }

    public int lengthOfLongestSubstring2(String s) {
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
