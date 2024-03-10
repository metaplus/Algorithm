package problem.array;

public class Lc345ReverseVowels {

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; ) {
            if (!isVowel(Character.toLowerCase(chars[i]))) {
                i++;
                continue;
            }
            if (!isVowel(Character.toLowerCase(chars[j]))) {
                j--;
                continue;
            }
            char c = chars[i];
            chars[i] = chars[j];
            chars[j] = c;
            i++;
            j--;
        }
        return new String(chars);
    }

    private boolean isVowel(char c) {
        return c == 'a'
                || c == 'e'
                || c == 'i'
                || c == 'o'
                || c == 'u';
    }
}
