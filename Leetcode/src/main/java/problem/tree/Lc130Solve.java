package problem.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lc130Solve {

    int[][] adj = new int[][]{
            new int[]{-1, 0},
            new int[]{0, 1},
            new int[]{1, 0},
            new int[]{0, -1}
    };

    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        Deque<int[]> deque = new ArrayDeque<>();
        for (int i = 0; i < row; i++) {
            if ('O' == board[i][0]) {
                deque.offer(new int[]{i, 0});
                board[i][0] = 0;
            }
            if ('O' == board[i][col - 1]) {
                deque.offer(new int[]{i, col - 1});
                board[i][col - 1] = 0;
            }
            bfs(board, deque, row, col);
            deque.clear();
        }
        for (int i = 1; i < col - 1; i++) {
            if ('O' == board[0][i]) {
                deque.offer(new int[]{0, i});
                board[0][i] = 0;
            }
            if ('O' == board[row - 1][i]) {
                deque.offer(new int[]{row - 1, i});
                board[row - 1][i] = 0;
            }
            bfs(board, deque, row, col);
            deque.clear();
        }
        for (char[] chars : board) {
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == 0) {
                    chars[i] = 'O';
                    continue;
                }
                if (chars[i] == 'O') {
                    chars[i] = 'X';
                }
            }
        }
    }

    private void bfs(char[][] board, Deque<int[]> deque, int row, int col) {
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int j = 0; j < size; j++) {
                int[] pos = deque.poll();
                for (int[] next : adj) {
                    int x = pos[0] + next[0];
                    int y = pos[1] + next[1];
                    if (x < 0 || y < 0 || x >= row || y >= col) {
                        continue;
                    }
                    if (board[x][y] != 'O') {
                        continue;
                    }
                    board[x][y] = 0;
                    deque.add(new int[]{x, y});
                }
            }
        }
    }


}
