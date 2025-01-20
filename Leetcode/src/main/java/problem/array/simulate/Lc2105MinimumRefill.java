package problem.array.simulate;

public class Lc2105MinimumRefill {

    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int left = 0;
        int right = plants.length - 1;
        int remainA = capacityA;
        int remainB = capacityB;
        int sum = 0;
        while (left < right) {
            if (remainA >= plants[left]) {
                remainA -= plants[left];
            } else {
                sum++;
                remainA = capacityA - plants[left];
            }
            left++;
            if (remainB >= plants[right]) {
                remainB -= plants[right];
            } else {
                sum++;
                remainB = capacityB - plants[right];
            }
            right--;
        }
        if (left == right && Math.max(remainA, remainB) < plants[left]) {
            sum++;
        }
        return sum;
    }
}
