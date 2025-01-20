package problem.array.simulate;

public class Lc1103DistributeCandies {

    public int[] distributeCandies(int candies, int numPeople) {
        int[] result = new int[numPeople];
        int index = 0;
        int cost = 1;
        while (candies > 0) {
            int increment = Math.min(cost, candies);
            result[index] += increment;
            candies -= increment;
            cost++;
            index = (index + 1) % numPeople;
        }
        return result;
    }
}
