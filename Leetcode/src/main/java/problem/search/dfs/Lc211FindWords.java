package problem.search.dfs;

import java.util.*;

public class Lc211FindWords {

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>(words.length);
        Set<String> set = new HashSet<>();
        Collections.addAll(set, words);
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int count = 0;
                for (String word : set) {
                    if (dfs(board, word, i, j, 0, rows, cols)) {
                        count++;
                        result.add(word);
                    }
                }
                while (count > 0) {
                    set.remove(result.get(result.size() - count--));
                }
            }
        }
        return result;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int k, int rows, int cols) {
        if (k == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= rows || j >= cols) {
            return false;
        }
        if (board[i][j] == 0 || board[i][j] != word.charAt(k)) {
            return false;
        }
        char c = board[i][j];
        board[i][j] = 0;
        boolean result = dfs(board, word, i - 1, j, k + 1, rows, cols) ||
                dfs(board, word, i + 1, j, k + 1, rows, cols) ||
                dfs(board, word, i, j - 1, k + 1, rows, cols) ||
                dfs(board, word, i, j + 1, k + 1, rows, cols);
        board[i][j] = c;
        return result;
    }
}
