package problem.hashmap;

public class Lc13RomanToInt {
    public int romanToInt(String s) {
        int sum = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case 'I': {
                    if (i + 1 < chars.length
                            && (chars[i + 1] == 'V' || chars[i + 1] == 'X')) {
                        sum -= 1;
                        break;
                    }
                    sum += 1;
                    break;
                }
                case 'X': {
                    if (i + 1 < chars.length
                            && (chars[i + 1] == 'L' || chars[i + 1] == 'C')) {
                        sum -= 10;
                        break;
                    }
                    sum += 10;

                    break;
                }
                case 'C': {
                    if (i + 1 < chars.length
                            && (chars[i + 1] == 'D' || chars[i + 1] == 'M')) {
                        sum -= 100;
                        break;
                    }
                    sum += 100;
                    break;
                }
                case 'L': {
                    sum += 50;
                    break;
                }
                case 'V': {
                    sum += 5;
                    break;
                }
                case 'D': {
                    sum += 500;
                    break;
                }
                case 'M': {
                    sum += 1000;
                    break;
                }
            }
        }
        return sum;
    }
}
