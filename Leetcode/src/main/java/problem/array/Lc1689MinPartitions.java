package problem.array;

public class Lc1689MinPartitions {

    public int minPartitions(String n) {
        int result = 0;
        char[] chars = n.toCharArray();
        for (char c : chars) {
            result = Math.max(c - '0', result);
            if (result == 9) {
                break;
            }
        }
        return result;
    }
}
