package problem.hashmap;

import java.util.*;

public class Lc288ValidWordAbbr {

    class ValidWordAbbr {


        private Map<String, Set<String>> map = new HashMap<>();


        public ValidWordAbbr(String[] dictionary) {
            for (String s : dictionary) {
                map.computeIfAbsent(abbr(s), k -> new HashSet<>(2))
                        .add(s);
            }
        }

        private String abbr(String s) {
            if (s.length() < 3) {
                return s;
            }
            StringBuilder builder = new StringBuilder();
            builder.append(s.charAt(0));
            builder.append(s.length() - 2);
            builder.append(s.charAt(s.length() - 1));
            return builder.toString();
        }

        public boolean isUnique(String word) {
            String key = abbr(word);
            Set<String> set = map.get(key);
            if (Objects.isNull(set)) {
                return true;
            }
            return set.size() == 1 && set.contains(word);
        }
    }

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
}
