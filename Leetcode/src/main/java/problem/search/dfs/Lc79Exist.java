package problem.search.dfs;

public class Lc79Exist {

    private final int[][] dims = new int[][]{
            new int[]{0, 1},
            new int[]{0, -1},
            new int[]{1, 0},
            new int[]{-1, 0},
    };

    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (chars[0] == board[i][j]) {
                    if (dfs(board, chars, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] word, int x, int y, int index) {
        if (index == word.length) {
            return true;
        }
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
            return false;
        }
        if (board[x][y] == 0) {
            return false;
        }
        if (board[x][y] != word[index]) {
            return false;
        }
        char c = board[x][y];
        board[x][y] = 0;
        boolean result = false;
        for (int[] dim : dims) {
            if (dfs(board, word, x + dim[0], y + dim[1], index + 1)) {
                result = true;
                break;
            }
        }
        board[x][y] = c;
        return result;
    }


    public boolean exist2(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs2(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs2(char[][] board, int i, int j, String word, int k) {
        if (k == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        if (board[i][j] == 0 || board[i][j] != word.charAt(k)) {
            return false;
        }
        char c = board[i][j];
        board[i][j] = 0;
        if (dfs2(board, i - 1, j, word, k + 1)
                || dfs2(board, i + 1, j, word, k + 1)
                || dfs2(board, i, j - 1, word, k + 1)
                || dfs2(board, i, j + 1, word, k + 1)) {
            board[i][j] = c;
            return true;
        }
        board[i][j] = c;
        return false;
    }
}
