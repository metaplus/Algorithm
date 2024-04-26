package problem.math;

public class Lc1017BaseNeg2 {

    public String baseNeg2(int n) {
        if (n == 0) {
            return "0";
        }
        int remain = n;
        StringBuilder builder = new StringBuilder();
        while (remain != 0) {
            if (Math.abs(remain) % 2 == 1) {
                remain -= 1;
                builder.append('1');
                remain /= -2;
                continue;
            }
            builder.append('0');
            remain /= -2;
        }
        return builder.reverse().toString();
    }
}
