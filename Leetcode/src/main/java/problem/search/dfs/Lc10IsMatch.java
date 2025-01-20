package problem.search.dfs;

public class Lc10IsMatch {

    public boolean isMatch(String s, String p) {
        return dfs(s.toCharArray(), p.toCharArray(), 0, 0);
    }

    private boolean dfs(char[] s, char[] p, int left, int right) {
        if (right == p.length) {
            return left == s.length;
        }
        boolean all = !Character.isLetter(p[right]);
        int index = right++;
        boolean many = false;
        if (right < p.length && p[right] == '*') {
            many = true;
            right++;
        }
        if (!many) {
            if (left == s.length) {
                return false;
            }
            if (all) {
                return dfs(s, p, left + 1, right);
            }
            return s[left] == p[index] && dfs(s, p, left + 1, right);
        }
        if (left == s.length) {
            return dfs(s, p, left, right);
        }
        if (all) {
            for (int i = left; i <= s.length; i++) {
                if (dfs(s, p, i, right)) {
                    return true;
                }
            }
            return false;
        }
        if (dfs(s, p, left, right)) {
            return true;
        }
        for (int i = left; i < s.length && s[i] == p[index]; i++) {
            if (dfs(s, p, i + 1, right)) {
                return true;
            }
        }
        return false;
    }
}
