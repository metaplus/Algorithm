package problem.bit;

public class Lc67AddBinary {

    public String addBinary(String a, String b) {
        int width = Math.max(a.length(), b.length());
        int pre = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < width; i++) {
            int val = pre;
            pre = 0;
            if (a.length() - 1 - i >= 0) {
                val += a.charAt(a.length() - 1 - i) - '0';
            }
            if (b.length() - 1 - i >= 0) {
                val += b.charAt(b.length() - 1 - i) - '0';
            }
            if (val >= 2) {
                pre = 1;
                val -= 2;
            }
            builder.append(val);
        }
        if (pre > 0) {
            builder.append(pre);
        }
        return builder.reverse().toString();
    }
}
