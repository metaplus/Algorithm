package problem.array.pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc438FindAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        int[] countP = new int[26];
        int[] countS = new int[26];
        for (char c : p.toCharArray()) {
            countP[c - 'a']++;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            int count = ++countS[index];
            if (i < p.length()) {
                if (i == p.length() - 1) {
                    if (count == countP[index] && Arrays.equals(countP, countS)) {
                        result.add(i - p.length() + 1);
                    }
                }
                continue;
            }
            index = s.charAt(i - p.length()) - 'a';
            count = --countS[index];
            if (count == countP[index] && Arrays.equals(countP, countS)) {
                result.add(i - p.length() + 1);
            }
        }
        return result;
    }
}
