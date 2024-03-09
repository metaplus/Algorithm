package problem.hashmap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Lc202IsHappy {

    public boolean isHappy(int n) {
        int[] dig = new int[10];
        Set<Integer> set = new HashSet<>();
        while (true) {
            if (set.contains(n)) {
                return false;
            }
            castDigits(n, dig);
            if (check(dig)) {
                return true;
            }
            set.add(n);
            int next = 0;
            int zero = 0;
            for (int i = dig.length - 1; i >= 0; i--) {
                if (dig[i] != zero) {
                    break;
                }
                zero++;
            }
            for (int i = 0; i < dig.length - zero; i++) {
                next += dig[i] * dig[i];
            }
            n = next;
        }
    }

    private void castDigits(int n, int[] dig) {
        Arrays.fill(dig, 0);
        for (int i = n, j = 0; i > 0; i /= 10, j++) {
            dig[j] = i % 10;
        }
    }

    private boolean check(int[] dig) {
        int one = 0;
        for (int i : dig) {
            if (i > 1) {
                return false;
            }
            if (i == 1) {
                one++;
            }
        }
        return one == 1;
    }
}
