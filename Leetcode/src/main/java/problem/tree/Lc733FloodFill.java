package problem.tree;

public class Lc733FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int rows = image.length;
        int cols = image[0].length;
        int source = image[sr][sc];
        dfs(image, sr, sc, rows, cols, source);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (image[i][j] == -source - 1) {
                    image[i][j] = color;
                    continue;
                }
                if (image[i][j] < 0) {
                    image[i][j] = -image[i][j] - 1;
                }
            }
        }
        return image;
    }

    private void dfs(int[][] image, int i, int j, int rows, int cols, int source) {
        if (i < 0 || j < 0 || i > rows - 1 || j > cols - 1) {
            return;
        }
        if (image[i][j] != source) {
            return;
        }
        image[i][j] = -source - 1;
        dfs(image, i - 1, j, rows, cols, source);
        dfs(image, i + 1, j, rows, cols, source);
        dfs(image, i, j - 1, rows, cols, source);
        dfs(image, i, j + 1, rows, cols, source);
    }
}
