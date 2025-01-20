package problem.array.pointer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lc301RemoveInvalidParentheses {

    private int removeMin = Integer.MAX_VALUE;

    public List<String> removeInvalidParentheses(String s) {
        char[] chars = s.toCharArray();
        Set<String> result = new HashSet<>(32);
        dfs(chars, 0, 0, 0, new StringBuilder(s.length()), result, 0);
        return new ArrayList<>(result);
    }

    private void dfs(char[] chars, int index, int open, int close,
                     StringBuilder builder, Set<String> result, int remove) {
        if (remove > removeMin) {
            return;
        }
        if (open < close) {
            return;
        }
        if (open - close > chars.length - index) {
            return;
        }
        if (index == chars.length) {
            if (open == close) {
                if (remove < removeMin) {
                    removeMin = remove;
                    result.clear();
                }
                result.add(builder.toString());
            }
            return;
        }

        if (chars[index] == '(') {
            builder.append('(');
            dfs(chars, index + 1, open + 1, close, builder, result, remove);
            builder.deleteCharAt(builder.length() - 1);
            dfs(chars, index + 1, open, close, builder, result, remove + 1);
            return;
        }
        if (chars[index] == ')') {
            builder.append(')');
            dfs(chars, index + 1, open, close + 1, builder, result, remove);
            builder.deleteCharAt(builder.length() - 1);
            dfs(chars, index + 1, open, close, builder, result, remove + 1);
            return;
        }
        builder.append(chars[index]);
        dfs(chars, index + 1, open, close, builder, result, remove);
        builder.deleteCharAt(builder.length() - 1);
    }


    // fail
    public List<String> removeInvalidParentheses2(String s) {
        char[] chars = s.toCharArray();
        int open = 0;
        int close = 0;
        for (char c : chars) {
            if ('(' == c) {
                open++;
                continue;
            }
            if (')' == c) {
                close++;
            }
        }
        List<String> semi = dfsClose(chars, 0);
        List<String> result = new ArrayList<>(semi.size());
        for (String string : semi) {
            List<String> next = dfsOpen(string.toCharArray(), string.length() - 1);
            result.addAll(next);
        }
        return result;
    }

    public List<String> dfsClose(char[] chars, int i) {
        if (i >= chars.length) {
            return List.of("");
        }
        int open = 0;
        int close = 0;
        List<String> result = new ArrayList<>(4);
        StringBuilder builder = new StringBuilder(chars.length - i);
        for (int j = i; j < chars.length; j++) {
            builder.append(chars[j]);
            if ('(' == chars[j]) {
                open++;
                continue;
            }
            if (')' == chars[j]) {
                close++;
            }
            if (close > open) {
                List<String> next = dfsClose(chars, j + 1);
                for (int k = i; k <= j; k++) {
                    if (k > i && chars[k - 1] == ')') {
                        continue;
                    }
                    if (')' == chars[k]) {
                        int len = builder.length();
                        builder.deleteCharAt(k - i);
                        for (String str : next) {
                            builder.append(str);
                            result.add(builder.toString());
                            builder.setLength(len - 1);
                        }
                        builder.insert(k - i, ')');
                    }
                }
                return result;
            }
        }
        result.add(builder.toString());
        return result;
    }


    public List<String> dfsOpen(char[] chars, int i) {
        if (i < 0) {
            return List.of("");
        }
        int open = 0;
        int close = 0;
        List<String> result = new ArrayList<>(4);
        StringBuilder builder = new StringBuilder(chars.length - i);
        for (int j = i; j >= 0; j--) {
            builder.append(chars[j]);
            if (')' == chars[j]) {
                close++;
                continue;
            }
            if ('(' == chars[j]) {
                open++;
            }
            if (open > close) {
                List<String> next = dfsOpen(chars, j - 1);
                for (int k = j; k <= i; k++) {
                    if ('(' == chars[k]) {
                        if (k > j && chars[k - 1] == '(') {
                            continue;
                        }
                        builder.deleteCharAt(i - k);
                        String suffix = new StringBuilder(builder).reverse().toString();
                        for (String str : next) {
                            result.add(str + suffix);
                        }
                        builder.insert(i - k, '(');
                    }
                }
                return result;
            }
        }
        result.add(builder.reverse().toString());
        return result;
    }
}
