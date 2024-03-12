package problem.array;

public class Lc1456MaxVowels {

    public int maxVowels(String s, int k) {
        char[] chars = s.toCharArray();
        int countMax = 0;
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i < k) {
                if (isVowel(chars[i])) {
                    count++;
                    countMax = count;
                }
                continue;
            }
            if (isVowel(chars[i])) {
                count++;
            }
            if (isVowel(chars[i - k])) {
                count--;
            }
            countMax = Math.max(count, countMax);
        }
        return countMax;
    }

    private boolean isVowel(char c) {
        return c == 'a'
                || c == 'e'
                || c == 'i'
                || c == 'o'
                || c == 'u';
    }
}
