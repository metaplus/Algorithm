package problem.hashmap;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Lc290WordPattern {

    public boolean wordPattern(String pattern, String s) {
        String[] map = new String[26];
        int pre = -1;
        int index = 0;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            index = s.indexOf(' ', pre + 1);
            String str = index < 0 ? s.substring(pre + 1) : s.substring(pre + 1, index);
            char c = pattern.charAt(i);
            if (Objects.isNull(map[c - 'a'])) {
                if (!set.add(str)) {
                    return false;
                }
                map[c - 'a'] = str;
            } else {
                if (!str.equals(map[c - 'a'])) {
                    return false;
                }
            }
            pre = index;
        }
        return index < 0;
    }
}
