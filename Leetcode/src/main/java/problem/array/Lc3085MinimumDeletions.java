package problem.array;

public class Lc3085MinimumDeletions {

    public int minimumDeletions(String word, int k) {
        char[] chars = word.toCharArray();
        int[] counts = new int[26];
        for (char c : chars) {
            counts[c - 'a']++;
        }
        int minCount = Integer.MAX_VALUE;
        char minChar = 0;
        int countChar = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 0) {
                continue;
            }
            countChar++;
            if (counts[i] < minCount) {
                minCount = counts[i];
                minChar = (char) ('a' + i);
            }
        }
        int sum = 0;
        for (int count : counts) {
            if (count > k + minCount) {
                sum += count - k - minCount;
            }
        }
        if (minCount < sum) {
            int preCount = 0;
            for (int i = 0; i < countChar - 1; i++) {
                int sum1 = minCount + preCount;
                if (sum1 >= sum) {
                    break;
                }
                preCount += minCount;
                counts[minChar - 'a'] = 0;
                minCount = Integer.MAX_VALUE;
                for (int j = 0; j < counts.length; j++) {
                    if (counts[j] == 0) {
                        continue;
                    }
                    if (counts[j] < minCount) {
                        minCount = counts[j];
                        minChar = (char) ('a' + j);
                    }
                }
                for (int count : counts) {
                    if (count > k + minCount) {
                        sum1 += count - k - minCount;
                    }
                }
                if (sum1 <= sum) {
                    sum = sum1;
                }
            }
        }
        return sum;
    }
}
