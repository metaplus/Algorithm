package problem;

import base.AlgorithmTestBase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import problem.dp.Lc32LongestValidParentheses;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc32LongestValidParenthesesTest extends AlgorithmTestBase<Lc32LongestValidParentheses> {

    @ParameterizedTest(name = CASE_NAME)
    @CsvSource({
            "((), 2",
            ")()()), 4",
            "()(()), 6",
            "()((), 2"
    })
    void solve(String str, int expect) {
        assertEquals(algorithm.solve(str), expect);
        assertEquals(algorithm.solve2(str), expect);
    }
}