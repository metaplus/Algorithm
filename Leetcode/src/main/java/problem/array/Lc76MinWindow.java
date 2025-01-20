package problem.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Lc76MinWindow {

    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        int[] sCount = new int['z' - 'A' + 1];
        int[] tCount = new int['z' - 'A' + 1];
        for (char c : t.toCharArray()) {
            tCount[c - 'A']++;
        }
        char[] chars = s.toCharArray();
        int left = -1;
        for (int i = 0; i < t.length(); i++) {
            if (tCount[chars[i] - 'A'] > 0) {
                if (left < 0) {
                    left = i;
                }
                sCount[chars[i] - 'A']++;
            }
        }
        if (Arrays.equals(sCount, tCount)) {
            return s.substring(0, t.length());
        }
        int[] window = new int[2];
        for (int i = t.length(); i < chars.length; i++) {
            if (tCount[chars[i] - 'A'] > 0) {
                if (left < 0) {
                    left = i;
                }
                if (++sCount[chars[i] - 'A'] == tCount[chars[i] - 'A']) {
                    if (match(sCount, tCount)) {
                        updateWindow(i, left, window);
                        for (int j = left; j < i; j++) {
                            if (tCount[chars[j] - 'A'] > 0) {
                                if (!match(sCount, tCount)) {
                                    left = j;
                                    break;
                                }
                                updateWindow(i, left, window);
                                --sCount[chars[j] - 'A'];
                            }
                            left = j + 1;
                        }
                    }

                }
            }
        }
        if (window[1] == 0) {
            return "";
        }
        return s.substring(window[0], window[0] + window[1]);
    }

    private void updateWindow(int i, int left, int[] window) {
        int len = i - left + 1;
        if (window[1] == 0 || len < window[1]) {
            window[1] = len;
            window[0] = left;
        }
    }

    private boolean match(int[] sCount, int[] tCount) {
        for (int i = 0; i < tCount.length; i++) {
            if (tCount[i] > 0 && sCount[i] < tCount[i]) {
                return false;
            }
        }
        return true;
    }

    public String minWindow3(String s, String t) {
        int[] counts = new int[128];
        int[] countsT = new int[128];
        int charT = 0;
        for (char c : t.toCharArray()) {
            if (countsT[c]++ == 0) {
                charT++;
            }
        }
        int[] window = new int[2];
        Arrays.fill(window, -1);
        char[] chars = s.toCharArray();
        int lenMax = Integer.MAX_VALUE;
        int charS = 0;
        int left = 0;
        for (int i = 0; i < chars.length; i++) {
            if (++counts[chars[i]] < countsT[chars[i]]) {
                continue;
            }
            if (counts[chars[i]] == countsT[chars[i]]) {
                if (++charS == charT) {
                    int len = i - left + 1;
                    if (len < lenMax) {
                        lenMax = len;
                        window[0] = left;
                        window[1] = i;
                    }
                }
                continue;
            }
            while (left <= i && counts[chars[left]] > countsT[chars[left]]) {
                --counts[chars[left]];
                left++;
            }
            if (charS == charT) {
                int len = i - left + 1;
                if (len < lenMax) {
                    lenMax = len;
                    window[0] = left;
                    window[1] = i;
                }
            }
        }
        return window[1] >= 0 ? s.substring(window[0], window[1] + 1) : "";
    }


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

    public String minWindow2(String s, String t) {
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
