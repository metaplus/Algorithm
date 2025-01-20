package problem.hashmap;

import java.util.*;

public class Lc49GroupAnagrams {


    public List<List<String>> groupAnagrams(String[] strs) {
        Map<BitSet, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            BitSet bitSet = new BitSet(26 * 7);
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            for (int i = 0; i < count.length; i++) {
                if (count[i] == 0) {
                    continue;
                }
                for (int j = 0; j < 7; j++) {
                    if ((count[i] & (1 << j)) > 0) {
                        bitSet.set(i * 7 + j);
                    }
                }
            }
            map.computeIfAbsent(bitSet, ignore -> new ArrayList<>(4)).add(str);
        }
        List<List<String>> result = new ArrayList<>(map.size());
        for (Map.Entry<BitSet, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
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
