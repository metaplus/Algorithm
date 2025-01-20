package problem.search.dfs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc2024MaxConsecutiveAnswersTest {

    @Test
    void maxConsecutiveAnswers() {
        assertEquals(3, new Lc2024MaxConsecutiveAnswers().maxConsecutiveAnswers("TFFT", 1));
        assertEquals(4, new Lc2024MaxConsecutiveAnswers().maxConsecutiveAnswers("TTFF", 2));
        assertEquals(5, new Lc2024MaxConsecutiveAnswers().maxConsecutiveAnswers("TTFTTFTT", 1));
        assertEquals(8, new Lc2024MaxConsecutiveAnswers().maxConsecutiveAnswers("TTTTTFTFFT", 2));
        assertEquals(8, new Lc2024MaxConsecutiveAnswers().maxConsecutiveAnswers("FFFTTFTTFT", 3));
    }
}