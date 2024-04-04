package problem.dp;

import java.util.List;

public class Lc139WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
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
