package problem.greedy;

public class Lc1247MinimumSwap {

    public int minimumSwap(String s1, String s2) {
        char[] x = s1.toCharArray();
        char[] y = s2.toCharArray();
        int swap = 0;
        for (int i = 0; i < x.length; i++) {
            if (x[i] == y[i]) {
                continue;
            }
            boolean fail = true;
            for (int j = i + 1; j < x.length; j++) {
                if (x[j] == y[j] || x[j] == y[i]) {
                    continue;
                }
                char c = x[j];
                x[j] = y[i];
                y[i] = c;
                swap++;
                fail = false;
                break;
            }
            if (fail) {
                for (int j = i + 1; j < x.length; j++) {
                    if (x[j] == y[j] || x[j] == x[i]) {
                        continue;
                    }
                    swap += 2;
                    fail = false;
                    char c = x[j];
                    x[j] = x[i];
                    x[i] = c;
                    break;
                }
                if (fail) {
                    return -1;
                }
            }
        }
        return swap;
    }
}
