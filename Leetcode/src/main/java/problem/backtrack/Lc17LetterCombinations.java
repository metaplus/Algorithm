package problem.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Lc17LetterCombinations {


    public List<String> letterCombinations(String digits) {
        char[][] map = new char[10][];
        map[2] = "abc".toCharArray();
        map[3] = "def".toCharArray();
        map[4] = "ghi".toCharArray();
        map[5] = "jkl".toCharArray();
        map[6] = "mno".toCharArray();
        map[7] = "pqrs".toCharArray();
        map[8] = "tuv".toCharArray();
        map[9] = "wxyz".toCharArray();
        List<String> res = new ArrayList<>();
        dfs(digits, 0, new StringBuilder(), res, map);
        return res;
    }

    private void dfs(String text, int i, StringBuilder builder, List<String> res, char[][] map) {
        if (i > text.length() - 1) {
            return;
        }
        int digit = text.charAt(i) - '0';
        builder.append(map[digit][0]);
        if (i == text.length() - 1) {
            for (char c : map[digit]) {
                builder.setCharAt(i, c);
                res.add(builder.toString());
            }
            builder.deleteCharAt(i);
            return;
        }
        for (char c : map[digit]) {
            builder.setCharAt(i, c);
            dfs(text, i + 1, builder, res, map);
        }
        builder.deleteCharAt(i);
    }
}
