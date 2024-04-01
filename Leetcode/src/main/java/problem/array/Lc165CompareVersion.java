package problem.array;

import java.util.Objects;

public class Lc165CompareVersion {

    public int compareVersion(String version1, String version2) {
        Find left = null;
        Find right = null;
        while (true) {
            if (Objects.isNull(left)) {
                left = parse(version1, 0);
            } else {
                left = parse(version1, left.next);
            }
            if (Objects.isNull(right)) {
                right = parse(version2, 0);
            } else {
                right = parse(version2, right.next);
            }
            if (left.val != right.val) {
                return left.val < right.val ? -1 : 1;
            }
            if (left.next < 0 && right.next < 0) {
                return 0;
            }
//            if (left.next < 0) {
//                return right.val > 0 ? -1 : 0;
//            }
//            if (right.next < 0) {
//                return left.val > 0 ? 1 : 0;
//            }
        }
    }

    private Find parse(String ver, int id) {
        if (id < 0) {
            return new Find(-1, 0);
        }
        int index = ver.indexOf('.', id);
        if (index < 0) {
            if (id < 0 || id > ver.length() - 1) {
                return new Find(-1, 0);
            }
            return new Find(-1, Integer.parseInt(ver.substring(id)));
        }
        for (int i = id; i < index; i++) {
            if (ver.charAt(i) == '0') {
                continue;
            }
            return new Find(index + 1, Integer.parseInt(ver.substring(i, index)));
        }
        return new Find(index + 1, 0);
    }

    class Find {
        int next;
        int val;

        public Find(int next, int val) {
            this.next = next;
            this.val = val;
        }
    }
}
