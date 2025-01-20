package problem.array.simulate;

public class Lc2644MaxDivScore {

    public int maxDivScore(int[] nums, int[] divisors) {
        int scoreMax = 0;
        int divMax = 0;
        int divMin = divisors[0];
        for (int divisor : divisors) {
            if (divMax > 0 && divisor % divMax == 0) {
                continue;
            }
            int count = 0;
            divMin = Math.min(divMin, divisor);
            for (int num : nums) {
                if (num % divisor == 0) {
                    count++;
                }
            }
            if (count > scoreMax
                    || (count == scoreMax && divMax > divisor)) {
                scoreMax = count;
                divMax = divisor;
            }
        }
        return divMax > 0 ? divMax : divMin;
    }

}
