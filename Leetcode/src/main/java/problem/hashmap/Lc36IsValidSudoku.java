package problem.hashmap;

import java.util.HashSet;
import java.util.Set;

public class Lc36IsValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if ('.' == board[i][j] || set.add(board[i][j])) {
                    continue;
                }
                return false;
            }
            set.clear();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if ('.' == board[j][i] || set.add(board[j][i])) {
                    continue;
                }
                return false;
            }
            set.clear();
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        if ('.' == board[3 * i + x][3 * j + y] || set.add(board[3 * i + x][3 * j + y])) {
                            continue;
                        }
                        return false;
                    }
                }
                set.clear();
            }
        }
        return true;
    }
}
