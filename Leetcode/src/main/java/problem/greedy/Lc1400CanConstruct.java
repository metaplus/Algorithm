package problem.greedy;

public class Lc1400CanConstruct {
    public boolean canConstruct(String s, int k) {
        int[] count = new int['z' - 'a' + 1];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) {
                continue;
            }
            if (count[i] % 2 == 1) {
                if ((--k) < 0) {
                    return false;
                }
                count[i]--;
            }
        }
        for (int i = 0; i < count.length && k > 0; i++) {
            if (count[i] == 0) {
                continue;
            }
            k -= Math.min(count[i], k);
        }
        return k == 0;
    }
}
