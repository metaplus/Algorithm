package problem.array;

public class Lc925IsLongPressedName {

    public boolean isLongPressedName(String name, String typed) {
        char[] charsName = name.toCharArray();
        char[] charsType = typed.toCharArray();
        int i = 0, j = 0;
        while (i < charsName.length && j < charsType.length) {
            if (charsName[i] != charsType[j]) {
                return false;
            }
            int i1 = i + 1;
            for (int k = i + 1; k < charsName.length && charsName[i] == charsName[k]; k++) {
                i1 = k + 1;
            }
            int j1 = j + 1;
            for (int k = j + 1; k < charsType.length && charsType[j] == charsType[k]; k++) {
                j1 = k + 1;
            }
            if (i1 - i > j1 - j) {
                return false;
            }
            i = i1;
            j = j1;
        }
        return i == charsName.length && j == charsType.length;
    }
}
