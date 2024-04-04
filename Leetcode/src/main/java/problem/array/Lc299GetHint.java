package problem.array;

public class Lc299GetHint {

    public String getHint(String secret, String guess) {
        int[] count = new int[10];
        char[] sec = secret.toCharArray();
        for (char c : sec) {
            count[c - '0']++;
        }
        int a = 0;
        int b = 0;
        char[] gs = guess.toCharArray();
        for (int i = 0; i < gs.length; i++) {
            if (sec[i] == gs[i]) {
                if (count[gs[i] - '0']-- > 0) {
                    a++;
                }
            }
        }
        for (int i = 0; i < gs.length; i++) {
            if (sec[i] == gs[i]) {
                continue;
            }
            if (count[gs[i] - '0']-- > 0) {
                b++;
            }
        }
        StringBuilder builder = new StringBuilder();
        builder.append(a).append("A")
                .append(b).append("B");
        return builder.toString();
    }
}
