package problem.hashmap;

import java.util.HashMap;
import java.util.Map;

public class Lc424CharacterReplacement {

    public int characterReplacement(String s, int k) {
        int width = 1;
        int[] count = new int['Z' - 'A' + 1];
        count[s.charAt(0) - 'A'] = 1;
        int left = 0;
        int countMax = 1;
        for (int i = 1; i < s.length(); i++) {
            int countRight = ++count[s.charAt(i) - 'A'];
            countMax = Math.max(countRight, countMax);
            if (i - left + 1 > countMax + k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }
            width = Math.max(width, i - left + 1);
        }
        return width;
    }
}
