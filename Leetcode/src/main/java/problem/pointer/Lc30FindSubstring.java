package problem.pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc30FindSubstring {

    public List<Integer> findSubstring(String s, String[] words) {
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


    //timeout
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
