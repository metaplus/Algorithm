package problem;

public class Lc2864MaximumOddBinaryNumber {

    public String maximumOddBinaryNumber(String s) {
        char[] chars = s.toCharArray();
        int ones = 0;
        boolean zeroTail = chars[chars.length - 1] == '0';
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] != '1') {
                continue;
            }
            if (ones++ == 0) {
                if (zeroTail) {
                    swap(chars, i, chars.length - 1);
                } else {
                    swap(chars, i, ones - 1);
                }
                continue;
            }
            if(zeroTail){
                swap(chars, i, ones - 2);
                continue;
            }
            swap(chars, i, ones - 1);
        }
        return new String(chars);
    }

    private void swap(char[] arr, int i, int j) {
        if (i != j) {
            char c = arr[i];
            arr[i] = arr[j];
            arr[j] = c;
        }
    }
}
