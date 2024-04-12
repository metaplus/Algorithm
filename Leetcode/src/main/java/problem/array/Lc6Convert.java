package problem.array;

public class Lc6Convert {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numRows && i < chars.length; i++) {
            for (int j = i; j < chars.length; ) {
                builder.append(chars[j]);
                int mod = j % (numRows * 2 - 2);
                if (mod < numRows - 1) {
                    j += (numRows - 1 - mod) * 2;
                } else {
                    j += (numRows * 2 - 2 - mod) * 2;
                }
            }
        }
        return builder.toString();
    }
}
