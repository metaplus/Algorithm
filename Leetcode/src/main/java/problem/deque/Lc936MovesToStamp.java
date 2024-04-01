package problem.deque;

import java.util.ArrayList;
import java.util.List;

public class Lc936MovesToStamp {

    public int[] movesToStamp(String stamp, String target) {
        if (stamp.length() == target.length()) {
            return stamp.equals(target) ? new int[]{0} : new int[]{};
        }
        char[] stampChars = stamp.toCharArray();
        char[] targetChars = target.toCharArray();
        char[] moveChars = new char[targetChars.length];
        List<Integer> res = new ArrayList<>();
        int leftLast = Integer.MAX_VALUE;
        int rightLast = Integer.MAX_VALUE;
        for (int left = 0, right = targetChars.length - 1; left <= right; ) {
            int prefix = prefixCount(stampChars, left, targetChars);
            int suffix = suffixCount(stampChars, right, targetChars);
            if (prefix == 0 && suffix == 0) {
                return new int[]{};
            }
            if (prefix > 0) {
                if (suffix <= 0 || prefix < suffix) {
                    res.add(left);
                    copyStamps(stampChars, left, moveChars);
                    leftLast = left;
                    left += prefix;
                    if (left >= rightLast) {
                        res.add(rightLast);
                    }
                    if (left > right) {
                        break;
                    }
                    continue;
                }
            }
            if (suffix > 0) {
                if (right - stampChars.length + 1 < 0) {
                    return new int[0];
                }
                res.add(right - stampChars.length + 1);
                copyStamps(stampChars, right - stampChars.length + 1, moveChars);
                rightLast = right - stampChars.length + 1;
                right -= suffix;
            }
        }
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    private void copyStamps(char[] stampChars, int left, char[] targetChars) {
        for (int i = 0; i < stampChars.length; i++) {
            targetChars[i + left] = stampChars[i];
        }
    }

    private int prefixCount(char[] stampChars, int left, char[] targetChars) {
        int count = 0;
        int len = Math.min(targetChars.length, left + stampChars.length);
        for (int i = left; i < len; i++) {
            if (stampChars[i - left] == targetChars[i]) {
                count++;
                continue;
            }
            break;
        }
        return count;
    }


    private int suffixCount(char[] stampChars, int right, char[] targetChars) {
        int count = 0;
        for (int i = right; i >= Math.max(0, right - stampChars.length + 1); i--) {
            if (stampChars[stampChars.length - 1 - right + i] == targetChars[i]) {
                count++;
                continue;
            }
            break;
        }
        return count;
    }
}
