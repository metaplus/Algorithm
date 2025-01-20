package problem.search.dfs;


public class Lc2024MaxConsecutiveAnswers {


    private int maxGain = 0;

    public int maxConsecutiveAnswers(String answerKey, int k) {
        char[] chars = answerKey.toCharArray();
        int tCount = 0;
        int fCount = 0;
        int win = 1;
        int left = 0;
        for (int right = 0; right < chars.length; right++) {
            if (chars[right] == 'T') {
                tCount++;
            } else {
                fCount++;
            }
            while (tCount > k && fCount > k) {
                if (chars[left] == 'T') {
                    tCount--;
                } else {
                    fCount--;
                }
                left++;
            }
            win = Math.max(win, right - left + 1);
        }
        return win;
    }

    //tle
    public int maxConsecutiveAnswers2(String answerKey, int k) {
        char[] chars = answerKey.toCharArray();
        dfs(chars, 0, k, 0);
        return maxGain;
    }

    private void dfs(char[] chars, int index, int k, int preSame) {
        if (index >= chars.length) {
            return;
        }

        int countSame = (index > 0 && chars[index] == chars[index - 1]) ? preSame + 1 : 1;
        maxGain = Math.max(maxGain, countSame);
        dfs(chars, index + 1, k, countSame);
        if (k > 0) {
            int countSame1 = (index > 0 && chars[index] != chars[index - 1]) ? preSame + 1 : 1;
            maxGain = Math.max(maxGain, countSame1);
            char c = chars[index];
            chars[index] = c == 'T' ? 'F' : 'T';
            dfs(chars, index + 1, k - 1, countSame1);
            chars[index] = c;
        }
    }
}
