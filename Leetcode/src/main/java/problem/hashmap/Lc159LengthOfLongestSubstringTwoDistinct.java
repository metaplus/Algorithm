package problem.hashmap;

import java.util.HashMap;
import java.util.Map;

public class Lc159LengthOfLongestSubstringTwoDistinct {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int widthMax = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.size() <= 2) {
                widthMax = Math.max(widthMax, i - left + 1);
                continue;
            }
            while (map.size() > 2) {
                char d = s.charAt(left);
                if (map.get(d) - 1 > 0) {
                    map.put(d, map.get(d) - 1);
                } else {
                    map.remove(d);
                }
                left++;
            }
            widthMax = Math.max(widthMax, i - left + 1);
        }
        return widthMax;
    }
}
