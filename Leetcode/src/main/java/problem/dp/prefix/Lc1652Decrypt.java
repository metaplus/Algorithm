package problem.dp.prefix;

public class Lc1652Decrypt {

    public int[] decrypt(int[] code, int k) {
        if (k == 0) {
            return new int[code.length];
        }
        int[] prefix = new int[code.length];
        prefix[0] = code[0];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + code[i];
        }
        int[] result = new int[code.length];
        for (int i = 0; i < result.length; i++) {
            int left = k > 0 ? i + 1 : i + k;
            int right = k > 0 ? i + k : i - 1;
            if (left >= 0) {
                if (right < result.length) {
                    result[i] = prefix[right] - (left > 0 ? prefix[left - 1] : 0);
                    continue;
                }
                result[i] = prefix[result.length - 1] - (left > 0 ? prefix[left - 1] : 0);
                result[i] += prefix[right - result.length];
                continue;
            }
            if (right >= 0) {
                result[i] = prefix[right];
                result[i] += prefix[result.length - 1] - prefix[result.length + left - 1];
                continue;
            }
            result[i] = prefix[result.length + right] - prefix[result.length + left - 1];
        }
        return result;
    }
}
