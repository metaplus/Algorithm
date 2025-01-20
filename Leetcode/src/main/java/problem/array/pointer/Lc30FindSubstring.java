package problem.array.pointer;

import java.util.*;

public class Lc30FindSubstring {


    // time long
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>(words.length);
        for (String word : words) {
            map.merge(word, 1, Integer::sum);
        }
        int len = words.length * words[0].length();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= s.length() - len; i++) {
            if (dfs(s, i, words[0].length(), map)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean dfs(String s, int i, int len, Map<String, Integer> map) {
        if (map.isEmpty()) {
            return true;
        }
        String str = s.substring(i, i + len);
        if (!map.containsKey(str)) {
            return false;
        }
        map.compute(str, (k, v) -> v == 1 ? null : v - 1);
        boolean result = dfs(s, i + len, len, map);
        map.merge(str, 1, Integer::sum);
        return result;
    }

    // tle
    public List<Integer> findSubstring2(String s, String[] words) {
        char[] chars = s.toCharArray();
        char[][] wordArr = new char[words.length][];
        for (int i = 0; i < words.length; i++) {
            wordArr[i] = words[i].toCharArray();
        }
        int len = words.length * words[0].length();
        boolean[] visit = new boolean[words.length];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= chars.length - len; i++) {
            Arrays.fill(visit, false);
            if (check(chars, i, wordArr, visit)) {
                res.add(i);
            }
        }
        return res;
    }


    private boolean check(char[] chars, int i, char[][] wordArr, boolean[] visit) {
        int count = 0;
        int len = wordArr[0].length;
        while (count < wordArr.length) {
            boolean fail = true;
            for (int j = 0; j < wordArr.length; j++) {
                if (visit[j]) {
                    continue;
                }
                boolean equal = true;
                int start = i + count * len;
                for (int k = start; k < start + len; k++) {
                    if (chars[k] != wordArr[j][k - i - count * len]) {
                        equal = false;
                        break;
                    }
                }
                if (equal) {
                    count++;
                    visit[j] = true;
                    fail = false;
                    break;
                }
            }
            if (fail) {
                return false;
            }
        }
        return true;
    }

}
