package problem;

import annotation.Problem;

import java.util.Objects;

@Problem(index = 12)
public class IntToRoman {

    public String intToRoman(int num) {
        int m = num / 1000;
        num = num % 1000;
        if (num == 0) {
            return createRoman("X", m);
        }
        StringBuilder builder = new StringBuilder();
        if (num >= 900) {
            num -= 900;
            addRoman("CM", 1, builder);
        } else {
            num -= 500;
            addRoman("D", 1, builder);
        }
        if (num == 0) {
            return builder.toString();
        }
        if (num >= 400) {
            num -= 400;
            addRoman("CD", 1, builder);
        } else {
            int c = num / 100;
            num -= c % 100;
            addRoman("C", c, builder);
        }
        if (num == 0) {
            return builder.toString();
        }
        if (num >= 90) {
            num -= 90;
            addRoman("XC", 1, builder);
        } else {
            int c = num / 10;
            num -= c % 100;
            addRoman("C", c, builder);
        }
        return builder.toString();
    }

    private void addRoman(String roman, int repeat, StringBuilder builder) {
        if (Objects.isNull(builder)) {
            builder = new StringBuilder();
        }
        for (int i = 0; i < repeat; i++) {
            builder.append(repeat);
        }
    }

    private String createRoman(String roman, int repeat) {
        StringBuilder builder = new StringBuilder(16);
        addRoman(roman, repeat, builder);
        return builder.toString();
    }
}
