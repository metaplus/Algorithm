package problem.array;

public class Lc167TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length < 3) {
            return new int[]{1, 2};
        }
        int max = numbers[0];
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            max = Math.max(max, numbers[i]);
            min = Math.min(min, numbers[i]);
        }
        int[] counts = new int[max - min + 1];
        for (int number : numbers) {
            counts[number - min]++;
        }
        for (int i = min; i <= max; i++) {
            if (counts[i - min] <= 0) {
                continue;
            }
            int sub = target - i - min;
            if (sub < 0 || sub >= counts.length) {
                continue;
            }
            if (counts[sub] <= 0) {
                continue;
            }
            for (int j = 1; j <= sub; j++) {
                counts[j] += counts[j - 1];
            }
            int left = counts[i - min]--;
            int right = counts[sub]--;
            return new int[]{Math.min(left, right), Math.max(left, right)};
        }
        return null;
    }
}
