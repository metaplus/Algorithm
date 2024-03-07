package problem.greedy;

public class Lc392IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        for (int i = 0, j = 0; i < s.length() && j < t.length(); ) {
            if (s.charAt(i) == t.charAt(j)) {
                if (i == s.length() - 1) {
                    return true;
                }
                i++;
                j++;
                continue;
            }
            j++;
        }
        return false;
    }
}
