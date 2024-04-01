package problem.graph;

public class Lc547FindCircleNum {

    private static void dfs(int[][] isConnected, int i, int rows) {
        if (isConnected[i][i] == 0) {
            return;
        }
        isConnected[i][i] = 0;
        for (int j = 0; j < rows; j++) {
            if (i == j) {
                continue;
            }
            if (isConnected[i][j] == 1 || isConnected[j][i] == 1) {
                isConnected[i][j] = 0;
                isConnected[j][i] = 0;
                dfs(isConnected, j, rows);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int rows = isConnected.length;
        int count = 0;
        for (int i = 0; i < rows; i++) {
            if (isConnected[i][i] == 0) {
                continue;
            }
            count++;
            dfs(isConnected, i, rows);
        }
        return count;
    }
}
