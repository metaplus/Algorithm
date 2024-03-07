package problem.greedy;

import java.util.Arrays;

public class Lc135Candy {
    public int candy(int[] ratings) {
        int[] indices = radixSort(ratings, new int[ratings.length]);
        int[] candies = new int[ratings.length];
        int candy = 0;
        for (int index : indices) {
            int cost = 1;
            if (index + 1 < ratings.length
                    && ratings[index + 1] < ratings[index]
                    && candies[index + 1] > 0) {
                cost += candies[index + 1];
            }
            if (index > 0
                    && ratings[index - 1] < ratings[index]
                    && candies[index - 1] > 0) {
                cost = Math.max(cost, candies[index - 1] + 1);
            }
            candies[index] = cost;
            candy += cost;
        }
        return candy;
    }

    private int[] radixSort(int[] nums, int[] indices) {
        int max = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
        }
        for (int i = 0; i < nums.length; i++) {
            indices[i] = i;
        }
        int digit = 0;
        for (int i = max; i > 0; i /= 10) {
            digit++;
        }
        int[] count = new int[10];
        int[] sort = new int[indices.length];
        int div = 1;
        for (int i = 0; i < digit; i++) {
            for (int index : indices) {
                count[(nums[index] / div) % 10]++;
            }
            for (int j = 1; j < count.length; j++) {
                count[j] += count[j - 1];
            }
            for (int j = indices.length - 1; j >= 0; j--) {
                sort[--count[(nums[indices[j]] / div) % 10]] = indices[j];
            }
            Arrays.fill(count, 0);
            System.arraycopy(sort, 0, indices, 0, indices.length);
            div *= 10;
        }
        return indices;
    }
}
