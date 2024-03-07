package problem.greedy;

public class Lc860LemonadeChange {

    public boolean lemonadeChange(int[] bills) {
        int count5 = 0;
        int count10 = 0;
        for (int bill : bills) {
            if (bill == 5) {
                count5++;
                continue;
            }
            if (bill == 10) {
                if (count5 < 1) {
                    return false;
                }
                count5--;
                count10++;
                continue;
            }
            if (count5 > 0 && count10 > 0) {
                count5--;
                count10--;
                continue;
            }
            if (count5 > 2) {
                count5 -= 3;
                continue;
            }
            return false;
        }
        return true;
    }
}
