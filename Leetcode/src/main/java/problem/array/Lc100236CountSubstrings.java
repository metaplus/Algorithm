package problem.array;

public class Lc100236CountSubstrings {

    public long countSubstrings(String s, char c) {
        char[] chars = s.toCharArray();
        long pre = 0;
        long sum = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != c) {
                continue;
            }
            pre++;
            sum += pre;
        }
        return sum;
    }
}
