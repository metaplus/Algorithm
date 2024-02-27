package problem.dp;

import java.util.List;

public class Lc1301PathsWithMaxScore {

    private static final int MOD = 1000_000_007;

    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int[][] scores = new int[n][n];
        int[][] paths = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    paths[0][0] = 1;
                    continue;
                }
                if (board.get(i).charAt(j) == 'X') {
                    paths[i][j] = -1;
                    scores[i][j] = -1;
                    continue;
                }
                int max = Integer.MIN_VALUE;
                int path = 0;
                if (i > 0) {
                    {
                        char code = board.get(i - 1).charAt(j);
                        if (code != 'X') {
                            int score = scores[i - 1][j];
                            if (score > max) {
                                max = score;
                                path = paths[i - 1][j];
                            }
                        }
                    }
                    if (j > 0) {
                        char code = board.get(i - 1).charAt(j - 1);
                        if (code != 'X') {
                            int score = scores[i - 1][j - 1];
                            if (score > max) {
                                max = score;
                                path = paths[i - 1][j - 1];
                            } else if (score == max) {
                                path += paths[i - 1][j - 1];
                            }
                        }
                    }
                }
                if (j > 0) {
                    char code = board.get(i).charAt(j - 1);
                    if (code != 'X') {
                        int score = scores[i][j - 1];
                        if (score > max) {
                            max = score;
                            path = paths[i][j - 1];
                        } else if (score == max) {
                            path += paths[i][j - 1];
                        }
                    }
                }
                if (max < 0) {
                    paths[i][j] = -1;
                    scores[i][j] = -1;
                    continue;
                }
                scores[i][j] = max + (i < n - 1 || j < n - 1 ? Character.getNumericValue(board.get(i).charAt(j)) : 0);
                scores[i][j] %= MOD;
                paths[i][j] = path % MOD;
            }
        }
        if (paths[n - 1][n - 1] < 0) {
            return new int[]{0, 0};
        }
        return new int[]{scores[n - 1][n - 1], paths[n - 1][n - 1]};
    }
}
