package problem.array;

public class Lc1491Average {

    public double average(int[] salary) {
        int min = salary[0];
        int max = salary[0];
        long sum = salary[0];
        for (int i = 1; i < salary.length; i++) {
            sum += salary[i];
            min = Math.min(min, salary[i]);
            max = Math.max(max, salary[i]);
        }
        sum -= min;
        sum -= max;
        return ((double) sum) / (salary.length - 2);
    }
}
