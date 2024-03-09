package problem.hashmap;

import org.checkerframework.checker.units.qual.A;

import java.util.*;

public class Lc249GroupStrings {

    public List<List<String>> groupStrings(String[] strings) {
        List<Integer> offsets = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String string : strings) {
            for (int i = 1; i < string.length(); i++) {
                int offset = string.charAt(i) - string.charAt(i - 1);
                if (offset < 0) {
                    offset += 26;
                }
                offsets.add(offset);
            }
            String key = offsets.toString();
            map.computeIfAbsent(key, k -> new ArrayList<>(4))
                    .add(string);
            offsets.clear();
        }
        return new ArrayList<>(map.values());
    }
}
