package problem.pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc301RemoveInvalidParentheses {

    // fail
    public List<String> removeInvalidParentheses(String s) {
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
            return Arrays.asList("");
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
            return Arrays.asList("");
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
