package problem.array;

public class Lc1052MaxSatisfied {

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int sum = 0;
        if (minutes == customers.length) {
            for (int customer : customers) {
                sum += customer;
            }
            return sum;
        }
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] > 0) {
                continue;
            }
            sum += customers[i];
        }
        int happy = sum;
        int happyMax = 0;
        for (int i = 0; i < customers.length; i++) {
            if (i < minutes) {
                if (grumpy[i] == 1) {
                    happy += customers[i];
                    happyMax = happy;
                }
                continue;
            }
            if (grumpy[i] == 1) {
                happy += customers[i];
            }
            if (grumpy[i - minutes] == 1) {
                happy -= customers[i - minutes];
            }
            happyMax = Math.max(happyMax, happy);
        }
        return happyMax;
    }
}
