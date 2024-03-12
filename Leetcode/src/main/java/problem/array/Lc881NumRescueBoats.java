package problem.array;

import java.util.Arrays;

public class Lc881NumRescueBoats {

    public int numRescueBoats(int[] people, int limit) {
        if (people.length < 2) {
            return 1;
        }
        Arrays.sort(people);
        int boat = 0;
        for (int left = 0, right = people.length - 1; left <= right; ) {
            if (left == right) {
                boat++;
                break;
            }
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            boat++;
        }
        return boat;
    }
}
