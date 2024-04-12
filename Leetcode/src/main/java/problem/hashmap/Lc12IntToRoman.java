package problem.hashmap;

import annotation.Problem;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

@Problem(index = 12)
public class Lc12IntToRoman {

    public String intToRoman(int num) {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
        StringBuilder builder = new StringBuilder();
        int sum = num;
        while (sum > 0) {
            Map.Entry<Integer, String> entry = map.floorEntry(sum);
            sum -= entry.getKey();
            builder.append(entry.getValue());
        }
        return builder.toString();
    }

    public String intToRoman2(int num) {
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
