package problem.greedy;

public class Lc409LongestPalindrome {

    public int longestPalindrome(String s) {
        int[] counts = new int['z' - 'A' + 1];
        for (char c : s.toCharArray()) {
            counts[c - 'A']++;
        }
        int sum = 0;
        int odd = 0;
        for (int count : counts) {

            if (count % 2 == 0) {
                sum += count;
                continue;
            }
            sum += count - 1;
            odd = 1;
        }
        return sum + odd;
    }
}
