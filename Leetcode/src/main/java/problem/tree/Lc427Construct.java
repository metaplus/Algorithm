package problem.tree;

public class Lc427Construct {

    public Node construct(int[][] grid) {
        return dfs(grid, 0, 0, grid.length - 1, grid[0].length - 1);
    }

    public Node dfs(int[][] grid, int i, int j, int x, int y) {
        if (i == x && j == y) {
            return new Node(grid[i][j] == 1, true);
        }
        Node topLeft = dfs(grid, i, j, (i + x) / 2, (j + y) / 2);
        Node topRight = dfs(grid, i, (j + y) / 2 + 1, (i + x) / 2, y);
        Node bottomLeft = dfs(grid, (i + x) / 2 + 1, j, x, (j + y) / 2);
        Node bottomRight = dfs(grid, (i + x) / 2 + 1, (j + y) / 2 + 1, x, y);
        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf) {
            if (topLeft.val == topRight.val
                    && topLeft.val == bottomLeft.val
                    && topLeft.val == bottomRight.val) {
                return new Node(topLeft.val, true);
            }
        }
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }
}
