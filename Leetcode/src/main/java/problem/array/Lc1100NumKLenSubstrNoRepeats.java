package problem.array;

public class Lc1100NumKLenSubstrNoRepeats {

    private static boolean unique(int[] counts) {
        for (int count : counts) {
            if (count > 1) {
                return false;
            }
        }
        return true;
    }

    public int numKLenSubstrNoRepeats(String s, int k) {
        if (k > s.length()) {
            return 0;
        }
        int[] counts = new int[26];
        char[] chars = s.toCharArray();
        int substring = 0;
        for (int i = 0; i < chars.length; i++) {
            ++counts[chars[i] - 'a'];
            if (i < k - 1) {
                continue;
            }
            if (i - k >= 0) {
                --counts[chars[i - k] - 'a'];
            }
            if (unique(counts)) {
                substring++;
            }
        }
        return substring;
    }
}
