package problem.dp;

public class Lc63UniquePathsWithObstacles {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] paths = new int[obstacleGrid.length][obstacleGrid[0].length];
        paths[0][0] = 1;
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    paths[i][j] = 0;
                    continue;
                }
                if (j > 0 && obstacleGrid[i][j - 1] == 0) {
                    paths[i][j] += paths[i][j - 1];
                }
                if (i > 0 && obstacleGrid[i - 1][j] == 0) {
                    paths[i][j] += paths[i - 1][j];
                }
            }
        }
        return paths[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
