package problem.search.dfs;

public class Lc1274CountShips {

    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        return dfs(sea, topRight, bottomLeft);
    }


    public int dfs(Sea sea, int[] topRight, int[] bottomLeft) {
        if (topRight[0] < bottomLeft[0]
                || topRight[1] < bottomLeft[1]) {
            return 0;
        }
        if (!sea.hasShips(topRight, bottomLeft)) {
            return 0;
        }
        if (topRight[0] == bottomLeft[0]
                && topRight[1] == bottomLeft[1]) {
            return 1;
        }
        int xMid = (topRight[0] + bottomLeft[0]) / 2;
        int yMid = (topRight[1] + bottomLeft[1]) / 2;
        return dfs(sea, new int[]{xMid, yMid}, bottomLeft)
                + dfs(sea, new int[]{topRight[0], yMid}, new int[]{xMid + 1, bottomLeft[1]})
                + dfs(sea, new int[]{xMid, topRight[1]}, new int[]{bottomLeft[0], yMid + 1})
                + dfs(sea, topRight, new int[]{xMid + 1, yMid + 1});
    }

    // This is Sea's API interface.
    // You should not implement it, or speculate about its implementation
    interface Sea {
        public boolean hasShips(int[] topRight, int[] bottomLeft);
    }

}
