package problem;

import base.AlgorithmTestBase;
import converter.GridConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UniquePathsIITest extends AlgorithmTestBase<UniquePathsII> {

    @Override
    public UniquePathsII get() {
        return new UniquePathsII();
    }

    @ParameterizedTest(name = CASE_NAME)
    @ValueSource(strings = "[\n"
            + "  [0,0,0],\n"
            + "  [0,1,0],\n"
            + "  [0,0,0]\n"
            + "]")
    void solve(@ConvertWith(GridConverter.class) int[][] grid) {
        assertEquals(algorithm.solve(grid), 2);
    }
}