package problem.array;

public class Lc58LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int right = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (Character.isWhitespace(s.charAt(i))) {
                if (right == s.length()) {
                    continue;
                }
                return right - i;
            } else {
                if (right == s.length()) {
                    right = i;
                }
            }
        }
        return right + 1;
    }
}
