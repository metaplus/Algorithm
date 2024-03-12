package problem.array;

public class Lc1358NumberOfSubstrings {

    public int numberOfSubstrings(String s) {
        char[] chars = s.toCharArray();
        int[] leftFreq = new int[3];
        int[] rightFreq = new int[3];
        int leftDistinct = 0;
        int rightDistinct = 0;
        int left = 0;
        int right = 0;
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (leftFreq[chars[i] - 'a']++ == 0) {
                leftDistinct++;
            }
            for (int j = left; j < i && leftDistinct > 3; j++) {
                if (leftFreq[chars[j] - 'a']-- == 1) {
                    leftDistinct--;
                    left = j + 1;
                }
            }
            if (rightFreq[chars[i] - 'a']++ == 0) {
                rightDistinct++;
            }
            for (int j = right; j < i && rightDistinct > 2; j++) {
                if (rightFreq[chars[j] - 'a']-- == 1) {
                    rightDistinct--;
                    right = j + 1;
                }
            }
            if (leftDistinct == 3) {
                count += right - left;
            }
        }
        return count;
    }
}
