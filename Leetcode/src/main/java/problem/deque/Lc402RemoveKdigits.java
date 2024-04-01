package problem.deque;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Lc402RemoveKdigits {

    public String removeKdigits(String num, int k) {
        if (num.length() <= k) {
            return "0";
        }
        Deque<Character> deque = new ArrayDeque<>();
        char[] chars = num.toCharArray();
        int del = 0;
        for (int i = 0; i < chars.length; i++) {
            if (deque.isEmpty()) {
                deque.offer(chars[i]);
                continue;
            }
            while (!deque.isEmpty() && chars[i] < deque.peekLast() && del < k) {
                deque.pollLast();
                del++;
            }
            deque.offer(chars[i]);
        }
        if (del < k) {
            for (int i = 0; i < k - del; i++) {
                deque.pollLast();
            }
        }
        while (!deque.isEmpty() && deque.peek() == '0') {
            deque.pollFirst();
        }
        if (deque.isEmpty()) {
            return "0";
        }
        StringBuilder builder = new StringBuilder(deque.size());
        while (!deque.isEmpty()) {
            builder.append(deque.pollFirst());
        }
        return builder.toString();
    }

    public String removeKdigits2(String num, int k) {
        if (num.length() <= k) {
            return "0";
        }
        List<Character> list = new ArrayList<>();
        char[] chars = num.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (list.size() < num.length() - k) {
                list.add(0, chars[i]);
                continue;
            }
            if (chars[i] > list.get(0).charValue()) {
                continue;
            }
            if (list.size() == 1) {
                list.set(0, chars[i]);
                continue;
            }
            for (int j = 0; j < list.size(); j++) {
                if (j < 1) {
                    continue;
                }
                if (list.get(j) < list.get(j - 1)) {
                    list.remove(j - 1);
                    list.add(0, chars[i]);
                    break;
                }
                if (j == list.size() - 1) {
                    list.remove(list.size() - 1);
                    list.add(0, chars[i]);
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == '0') {
                continue;
            }
            char[] chars1 = new char[list.size() - i];
            for (int j = i; j < list.size(); j++) {
                chars1[j - i] = list.get(j);
            }
            return new String(chars1);
        }
        return "0";
    }

    public String removeKdigits1(String num, int k) {
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
