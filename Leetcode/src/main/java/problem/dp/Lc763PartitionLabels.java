package problem.dp;

import java.util.ArrayList;
import java.util.List;

public class Lc763PartitionLabels {

    public List<Integer> partitionLabels(String s) {
        char[] chars = s.toCharArray();
        int[] remain = new int[26];
        for (char c : chars) {
            remain[c - 'a']++;
        }
        int[] count = new int[26];
        int element = 0;
        List<Integer> result = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            if (count[chars[i] - 'a']++ == 0) {
                element++;
            }
            if (--remain[chars[i] - 'a'] == 0) {
                element--;
            }
            if (element == 0) {
                result.add(i + 1 - sum);
                sum = i + 1;
            }
        }
        return result;
    }
}
