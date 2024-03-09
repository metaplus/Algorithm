package problem.hashmap;

public class Lc311Multiply {

    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int[][] mul = new int[mat1.length][mat2[0].length];
        for (int i = 0; i < mat1.length; i++) {
            for (int y = 0; y < mat2[0].length; y++) {
                int val = 0;
                for (int j = 0; j < mat1[0].length; j++) {
                    val += mat1[i][j] * mat2[j][y];
                }
                mul[i][y] = val;
            }
        }
        return mul;
    }
}
