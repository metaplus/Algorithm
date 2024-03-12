package problem.string;

public class Lc2129CapitalizeTitle {
    public String capitalizeTitle(String title) {
        char[] chars = title.toCharArray();
        int left = 0;
        for (int i = 0; i < chars.length; i++) {
            if (Character.isWhitespace(chars[i])) {
                left = i + 1;
                continue;
            }
            if (left == i - 2) {
                chars[left] = Character.toUpperCase(chars[left]);
            }
            chars[i] = Character.toLowerCase(chars[i]);
        }
        return new String(chars);
    }

}
