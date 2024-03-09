package problem.hashmap;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Lc49GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        int[] counts = new int[26];
        for (String str : strs) {
            for (int i = 0; i < str.length(); i++) {
                counts[str.charAt(i) - 'a']++;
            }
            String key = Arrays.toString(counts);
            List<String> strings = map.get(key);
            if (Objects.isNull(strings)) {
                strings = new ArrayList<>(4);
                strings.add(str);
                map.put(key, strings);
            } else {
                strings.add(str);
            }
            Arrays.fill(counts, 0);
        }
        return new ArrayList<>(map.values());
    }
}
