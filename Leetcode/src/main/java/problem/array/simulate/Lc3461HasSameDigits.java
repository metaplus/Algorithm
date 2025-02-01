package problem.array.simulate;

public class Lc3461HasSameDigits {

    public boolean hasSameDigits(String s) {

        int[] row = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            row[i] = s.charAt(i) - '0';
        }
        while (row.length > 2) {
            int[] next = new int[row.length - 1];
            for (int i = 1; i < row.length; i++) {
                next[i - 1] = (row[i] + row[i - 1]) % 10;
            }
            row = next;
        }
        return row[0] == row[1];
    }
}
