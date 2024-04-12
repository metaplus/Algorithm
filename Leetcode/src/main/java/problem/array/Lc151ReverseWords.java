package problem.array;

public class Lc151ReverseWords {

    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        int right = s.length() - 1;
        while (right >= 0) {
            if (Character.isWhitespace(chars[right])) {
                right--;
                continue;
            }
            int left = right;
            while (left >= 0 && !Character.isWhitespace(chars[left])) {
                left--;
            }
            if (!builder.isEmpty()) {
                builder.append(' ');
            }
            builder.append(chars, left + 1, right - left);
            right = left - 1;
        }
        return builder.toString();
    }
}
