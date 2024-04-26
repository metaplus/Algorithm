package problem.array.matrix;

import java.util.ArrayList;
import java.util.List;

public class Lc54SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int size = row * col;
        List<Integer> result = new ArrayList<>();
        Direction direction = Direction.RIGHT;
        int x = 0;
        int y = 0;
        for (int i = 0; i < size; i++) {
            result.add(matrix[x][y]);
            matrix[x][y] = Integer.MIN_VALUE;
            switch (direction) {
                case UP: {
                    if (x - 1 < 0 || matrix[x - 1][y] == Integer.MIN_VALUE) {
                        y++;
                        direction = Direction.RIGHT;
                        break;
                    }
                    x--;
                    break;

                }
                case DOWN: {
                    if (x + 1 > row - 1 || matrix[x + 1][y]  == Integer.MIN_VALUE) {
                        y--;
                        direction = Direction.LEFT;
                        break;
                    }
                    x++;
                    break;
                }
                case LEFT: {
                    if (y - 1 < 0 || matrix[x][y - 1] == Integer.MIN_VALUE) {
                        x--;
                        direction = Direction.UP;
                        break;
                    }
                    y--;
                    break;
                }
                case RIGHT: {
                    if (y + 1 > col - 1 || matrix[x][y + 1]  == Integer.MIN_VALUE) {
                        x++;
                        direction = Direction.DOWN;
                        break;
                    }
                    y++;
                    break;
                }
            }
        }
        return result;
    }

    enum Direction {
        LEFT,
        RIGHT,
        UP,
        DOWN
    }
}
