package problem.array.simulate;

public class Lc2739DistanceTraveled {

    public int distanceTraveled(int mainTank, int additionalTank) {
        int dist = 0;
        int count = 0;
        while (mainTank-- > 0) {
            dist += 10;
            if (additionalTank > 0 && ++count == 5) {
                mainTank++;
                additionalTank--;
                count = 0;
            }
        }
        return dist;
    }
}
