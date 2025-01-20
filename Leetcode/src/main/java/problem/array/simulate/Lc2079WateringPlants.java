package problem.array.simulate;

public class Lc2079WateringPlants {

    public int wateringPlants(int[] plants, int capacity) {
        int pos = -1;
        int sum = 0;
        int remain = capacity;
        for (int i = 0; i < plants.length; i++) {
            if (remain >= plants[i]) {
                sum += i - pos;
                pos = i;
                remain -= plants[i];
                continue;
            }
            remain = capacity - plants[i];
            sum += pos + 1;
            sum += i + 1;
            pos = i;
        }
        return sum;
    }
}
