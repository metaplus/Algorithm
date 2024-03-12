package problem.array;

public class Lc904TotalFruit {

    public int totalFruit(int[] fruits) {
        if (fruits.length < 3) {
            return fruits.length;
        }
        int[] freq = new int[fruits.length + 1];
        int distinct = 0;
        int left = 0;
        int lenMax = 0;
        for (int i = 0; i < fruits.length; i++) {
            if (freq[fruits[i]]++ == 0) {
                distinct++;
            }
            int len = i - left + 1;
            if (distinct == 2) {
                lenMax = Math.max(len, lenMax);
                continue;
            }
            for (int j = left; j <= i && distinct > 2; j++) {
                if (freq[fruits[j]]-- == 1) {
                    distinct--;
                    left = j + 1;
                }
            }
        }
        return lenMax;
    }
}
