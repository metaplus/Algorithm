package problem.tree;

public class Lc365CanMeasureWater {

    boolean[][] visit;

    public boolean canMeasureWater(int x, int y, int target) {
        if (x + y < target) {
            return false;
        }
        visit = new boolean[x + 1][y + 1];
        boolean[] water = new boolean[x + y + 1];
        dfs(0, 0, x, y, water);
        return water[target];
    }

    private void dfs(int left, int right, int x, int y, boolean[] water) {
        if (visit[left][right]) {
            return;
        }
        water[left + right] = true;
        visit[left][right] = true;
        if (left > 0) {
            dfs(0, right, x, y, water);
        }
        if (left < x) {
            dfs(x, right, x, y, water);
            if (right > 0) {
                int left1 = Math.min(x, left + right);
                dfs(left1, right - left1 + left, x, y, water);
            }
        }
        if (right > 0) {
            dfs(left, 0, x, y, water);
        }
        if (right < y) {
            dfs(left, y, x, y, water);
            if (left > 0) {
                int right1 = Math.min(y, left + right);
                dfs(left - right1 + right, right1, x, y, water);
            }
        }
    }
}
