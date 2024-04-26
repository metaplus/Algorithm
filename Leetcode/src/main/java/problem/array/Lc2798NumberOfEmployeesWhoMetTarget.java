package problem.array;

import java.util.Objects;

public class Lc2798NumberOfEmployeesWhoMetTarget {

    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        if (Objects.isNull(hours) || hours.length == 0) {
            return 0;
        }
        int count = 0;
        for (int hour : hours) {
            if (hour >= target) {
                count++;
            }
        }
        return count;
    }
}
