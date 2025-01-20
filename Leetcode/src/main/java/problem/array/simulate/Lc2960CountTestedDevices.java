package problem.array.simulate;

public class Lc2960CountTestedDevices {

    public int countTestedDevices(int[] batteryPercentages) {
        int decrement = 0;
        int count = 0;
        for (int percentage : batteryPercentages) {
            if (percentage - decrement > 0) {
                decrement++;
                count++;
                continue;
            }
        }
        return count;
    }
}
