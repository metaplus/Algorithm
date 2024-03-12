package problem.array;

public class Lc340LengthOfLongestSubstringKDistinct {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int left = 0;
        int distinct = 0;
        char[] chars = s.toCharArray();
        char charMin = Character.MAX_VALUE;
        char charMax = 0;
        for (char c : chars) {
            if (c < charMin) {
                charMin = c;
            }
            if (c > charMax) {
                charMax = c;
            }
        }
        int[] counts = new int[charMax - charMin + 1];
        int lenMax = 0;
        for (int i = 0; i < chars.length; i++) {
            if (counts[chars[i] - charMin]++ == 0) {
                distinct++;
            }
            if (distinct <= k) {
                int len = i - left + 1;
                lenMax = Math.max(len, lenMax);
                continue;
            }
            for (int j = left; j < i && distinct > k; j++) {
                if (--counts[chars[j] - charMin] == 0) {
                    distinct--;
                    left = j + 1;
                }
            }
        }
        return lenMax;
    }
}
