package problem.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Lc76MinWindow {


    private boolean satisfyWindow(Map<Character, Integer> countWin, Map<Character, Integer> mapT) {
        if (countWin.size() < mapT.size()) {
            return false;
        }
        for (Map.Entry<Character, Integer> entry : countWin.entrySet()) {
            if (entry.getValue() < mapT.get(entry.getKey())) {
                return false;
            }
        }
        return true;
    }

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> mapT = new HashMap<>(t.length());
        for (char c : t.toCharArray()) {
            mapT.put(c, mapT.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> countWin = new HashMap<>(mapT.size());
        int left = -1;
        char[] chars = s.toCharArray();
        int lenMin = s.length() + 1;
        int leftMin = 0;
        for (int i = 0; i < chars.length; i++) {
            Integer countT = mapT.get(chars[i]);
            if (Objects.isNull(countT)) {
                continue;
            }
            if (left < 0) {
                left = i;
            }
            Integer count = countWin.compute(chars[i], (key, c) -> Objects.isNull(c) ? 1 : c + 1);
            if (count < countT) {
                continue;
            }
            if (!satisfyWindow(countWin, mapT)) {
                continue;
            }
            int len = i - left + 1;
            if (len < lenMin) {
                leftMin = left;
                lenMin = len;
            }
            for (int j = left; j < i; j++) {
                if (!mapT.containsKey(chars[j])) {
                    left = j + 1;
                    continue;
                }
                Integer countJ = countWin.compute(chars[j], (key, c) -> c - 1);
                if (countJ < mapT.get(chars[j])) {
                    left = j;
                    countWin.put(chars[j], countJ + 1);
                    if (satisfyWindow(countWin, mapT)) {
                        len = i - left + 1;
                        if (len < lenMin) {
                            leftMin = left;
                            lenMin = len;
                        }
                    }
                    break;
                }

            }
        }
        if (lenMin > s.length()) {
            return "";
        }
        return s.substring(leftMin, leftMin + lenMin);
    }
}
