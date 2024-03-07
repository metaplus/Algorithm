package problem.greedy;

public class Lc921MinAddToMakeValid {

    public int minAddToMakeValid(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int left = 0;
        int add = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
                continue;
            }
            if (left > 0) {
                left--;
            } else {
                add++;
            }
        }
        return add + left;
    }
}
