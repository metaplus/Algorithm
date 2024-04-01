package problem.greedy;

public class Lc1969MinNonZeroProduct {


    static final int MOD = 1000000000 + 7;

    long pow(long x, long p) {
        long pow = 1;
        long mul = x % MOD;
        for (long i = 0; i < p; i++) {
            pow = pow * mul % MOD;
            mul = mul * mul % MOD;
        }
        return pow;
    }

    public int minNonZeroProduct(int p) {
        long max = (1L << p) - 1;
        long pow = pow(max - 1, p - 1);
        return (int) (max % MOD * pow % MOD);
    }
}
