package problem.search.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc131Partition {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[chars.length][chars.length];
        for (boolean[] row : dp) {
            Arrays.fill(row, true);
        }
        for (int i = 0; i < chars.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                dp[j][i] = chars[i] == chars[j] && dp[j + 1][i - 1];
            }
        }
        dfs(chars, 0, dp, new ArrayList<>(), result);
        return result;
    }


    private boolean isPalindrome(char[] chars, int i, int j) {
        while (i <= j) {
            if (chars[i] != chars[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private void dfs(char[] chars, int i, boolean[][] dp, List<String> path, List<List<String>> result) {
        if (i >= chars.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j < chars.length; j++) {
            if (!dp[i][j]) {
                continue;
            }
            path.add(new String(chars, i, j - i + 1));
            dfs(chars, j + 1, dp, path, result);
            path.remove(path.size() - 1);
        }
    }
}
