package problem.greedy;

public class Lc402RemoveKdigits {

    public String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }
        char[] dig = new char[num.length() - k];
        for (int i = 0; i < dig.length; i++) {
            dig[dig.length - 1 - i] = num.charAt(num.length() - 1 - i);
        }
        for (int i = k - 1; i >= 0; i--) {
            if (num.charAt(i) > dig[0]) {
                continue;
            }
            int right = 0;
            for (int j = 1; j < dig.length; j++) {
                if (dig[j] >= dig[j - 1]) {
                    right = j;
                    continue;
                }
                break;
            }
            for (int l = right; l > 0; l--) {
                dig[l] = dig[l - 1];
            }
            dig[0] = num.charAt(i);
        }
        int zero = 0;
        for (int i = 0; i < dig.length && dig[i] == '0'; i++) {
            zero++;
        }
        if (zero == dig.length) {
            return "0";
        }
        return new String(dig, zero, dig.length - zero);
    }
}
