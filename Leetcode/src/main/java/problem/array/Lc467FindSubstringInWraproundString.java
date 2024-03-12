package problem.array;

public class Lc467FindSubstringInWraproundString {

    public int findSubstringInWraproundString(String s) {
        char[] chars = s.toCharArray();
        int[] lenMax = new int[26];
        int left = 0;
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            if (lenMax[index] == 0) {
                count++;
                lenMax[index] = 1;
            }
            if (i < 1) {
                continue;
            }
            if (index == chars[i - 1] - 'a' + 1
                    || (chars[i] == 'a' && chars[i - 1] == 'z')) {
                int len = i - left + 1;
                if (len > lenMax[index]) {
                    count += len - lenMax[index];
                    lenMax[index] = len;
                }
                continue;
            }
            left = i;
        }
        return count;
    }
}
