package problem.hashmap;

import java.util.*;

public class Lc2273RemoveAnagrams {

    private static void resetMap(Map<Character, Integer> map, String words) {
        map.clear();
        for (char c : words.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }
    }

    public List<String> removeAnagrams(String[] words) {
        if (words == null || words.length == 0) {
            return Collections.emptyList();
        }
        List<String> result = new ArrayList<>();
        Map<Character, Integer> compare = new HashMap<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (compare.isEmpty()) {
                result.add(words[i]);
                resetMap(compare, words[i]);
                continue;
            }
            if (words[i].length() < compare.size()) {
                result.add(words[i]);
                resetMap(compare, words[i]);
                continue;
            }
            map.clear();
            boolean equal = true;
            for (char c : words[i].toCharArray()) {
                if (!compare.containsKey(c)) {
                    equal = false;
                    break;
                }
                map.merge(c, 1, Integer::sum);
            }
            if (equal && map.equals(compare)) {
                continue;
            }
            result.add(words[i]);
            resetMap(compare, words[i]);
        }
        return result;
    }
}
