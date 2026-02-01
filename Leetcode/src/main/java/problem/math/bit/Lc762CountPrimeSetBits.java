package problem.math.bit;

import java.util.Arrays;

public class Lc762CountPrimeSetBits {

    private static boolean[] primes;


    public int countPrimeSetBits(int left, int right) {
        preparePrime();
        int count = 0;
        for (int i = left; i <= right; i++) {
//            int bits = countBit(i, true);
            int bits = Integer.bitCount(i);
            if (primes[bits]) {
                count++;
            }
        }
        return count;
    }

    private int countBit(int num, boolean checkMask) {
        int bit = 0;
        while (num > 0) {
            if (!checkMask || ((num & 1) == 1)) {
                bit++;
            }
            num >>= 1;
        }
        return bit;
    }

    private void preparePrime() {
        if (primes == null) {
            primes = new boolean[countBit(100_0000, false) + 1];
            Arrays.fill(primes, true);
            primes[0] = false;
            primes[1] = false;
            for (int i = 2; i < primes.length; i++) {
                if (primes[i]) {
                    for (int j = i + i; j < primes.length; j += i) {
                        primes[j] = false;
                    }
                }
            }
        }
    }
}
