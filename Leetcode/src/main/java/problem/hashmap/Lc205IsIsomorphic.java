package problem.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Lc205IsIsomorphic {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] map = new char[128];
        boolean[] source = new boolean[128];
        boolean[] target = new boolean[128];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char d = t.charAt(i);
            if (!source[c]) {
                if (target[d]) {
                    return false;
                }
                map[c] = d;
                source[c] = true;
                target[d] = true;
                continue;
            }
            if (map[c] != d) {
                return false;
            }
        }
        return true;
    }

    public boolean isIsomorphic2(String s, String t) {
        Map<Character, Integer> count1 = new HashMap<>();
        Map<Character, Integer> count2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            count1.put(c1, count1.getOrDefault(c1, 0) + 1);
            count2.put(c2, count2.getOrDefault(c2, 0) + 1);
        }
        if (count1.size() != count2.size()) {
            return false;
        }
        Map<Character, Character> map1 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            Integer count = count1.get(c1);
            if (!Objects.equals(count, count2.get(c2))) {
                return false;
            }
            Character c = map1.get(c1);
            if (Objects.isNull(c)) {
                map1.put(c1, c2);
            } else {
                if (c.equals(c2)) {
                    continue;
                }
                return false;
            }
        }
        return true;

    }
}
