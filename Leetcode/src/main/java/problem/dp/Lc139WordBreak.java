package problem.dp;

import java.util.ArrayList;
import java.util.List;

public class Lc139WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        char[] chars = s.toCharArray();
        List<char[]> words = new ArrayList<>(wordDict.size());
        for (String string : wordDict) {
            words.add(string.toCharArray());
        }
        boolean[] dp = new boolean[chars.length + 1];
        dp[0] = true;
        for (int i = 1; i <= chars.length; i++) {
            for (char[] word : words) {
                int pre = i - word.length;
                if (pre < 0 || !dp[pre]) {
                    continue;
                }
                boolean accept = true;
                for (int j = 0; j < word.length; j++) {
                    if (chars[pre + j] != word[j]) {
                        accept = false;
                        break;
                    }
                }
                if (accept) {
                    dp[i] = true;
                    break;
                }
            }
        }


        return dp[chars.length];
    }

    // timeout
    public boolean wordBreak3(String s, List<String> wordDict) {
        char[] chars = s.toCharArray();
        List<char[]> words = new ArrayList<>(wordDict.size());
        for (String string : wordDict) {
            words.add(string.toCharArray());
        }
        return dfs(chars, 0, words);
    }

    private boolean dfs(char[] chars, int index, List<char[]> words) {
        if (index == chars.length) {
            return true;
        }
        for (char[] s : words) {
            if (s.length + index > chars.length) {
                continue;
            }
            boolean accept = true;
            for (int i = 0; i < s.length; i++) {
                if (chars[index + i] != s[i]) {
                    accept = false;
                    break;
                }
            }
            if (accept) {
                accept = dfs(chars, index + s.length, words);
                if (accept) {
                    return true;
                }
            }

        }
        return false;
    }

    public boolean wordBreak2(String s, List<String> wordDict) {
//        List<Integer>[] indices = new List[wordDict.size()];
//        Arrays.setAll(indices, i -> new ArrayList<>(4));
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int j = 0; j < wordDict.size(); j++) {
            for (int i = 0; i < s.length(); ) {
                if (match(s, i, wordDict.get(j))) {
//                    indices[j].add(i);
                    dp[i][i + wordDict.get(j).length() - 1] = true;
//                    i += wordDict.get(j).length();
                    i++;
                    continue;
                }
                i++;
            }
        }
        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < dp.length; j++) {
                if (dp[i][j]) {
                    continue;
                }
                for (int k = i; k < j; k++) {
                    if (dp[i][k] && dp[k + 1][j]) {
                        dp[i][j] = true;
                        break;
                    }
                }
            }
        }
        return dp[0][s.length() - 1];
    }

    private boolean match(String s, int i, String word) {
        if (s.length() - i < word.length()) {
            return false;
        }
        for (int j = i; j < i + word.length(); j++) {
            if (s.charAt(j) != word.charAt(j - i)) {
                return false;
            }
        }
        return true;
    }
}
