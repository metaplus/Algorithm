package problem.array;

public class Lc1208EqualSubstring {
    public int equalSubstring(String s, String t, int maxCost) {
        int lenMax = 0;
        int left = 0;
        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();
        for (int i = 0; i < charsS.length; i++) {
            maxCost -= Math.abs(charsS[i] - charsT[i]);
            int len = i - left + 1;
            if (maxCost >= 0) {
                lenMax = Math.max(len, lenMax);
                continue;
            }
            for (int j = left; j <= i; j++) {
                maxCost += Math.abs(charsS[j] - charsT[j]);
                left = j + 1;
                if (maxCost >= 0) {
                    break;
                }
            }
        }
        return lenMax;
    }
}
