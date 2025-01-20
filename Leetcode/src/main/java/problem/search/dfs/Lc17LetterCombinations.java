package problem.search.dfs;

import java.util.ArrayList;
import java.util.List;

public class Lc17LetterCombinations {


    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>(2);
        }
        char[][] words = new char[10][];
        words[2] = new char[]{'a', 'b', 'c'};
        words[3] = new char[]{'d', 'e', 'f'};
        words[4] = new char[]{'g', 'h', 'i'};
        words[5] = new char[]{'j', 'k', 'l'};
        words[6] = new char[]{'m', 'n', 'o'};
        words[7] = new char[]{'p', 'q', 'r', 's'};
        words[8] = new char[]{'t', 'u', 'v'};
        words[9] = new char[]{'w', 'x', 'y', 'z'};

        char[] chars = digits.toCharArray();
        List<String> result = new ArrayList<>(32);
        dfs(chars, words, 0, new StringBuilder(), result);
        return result;
    }

    private void dfs(char[] chars, char[][] words, int index, StringBuilder builder, List<String> result) {
        if (index >= chars.length) {
            result.add(builder.toString());
            return;
        }
        for (char c : words[chars[index] - '0']) {
            builder.append(c);
            dfs(chars, words, index + 1, builder, result);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    public List<String> letterCombinations2(String digits) {
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
