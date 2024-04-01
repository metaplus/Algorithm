package problem.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class Lc22GenerateParenthesisTest {

    @Test
    void generateParenthesis() {
        assertNotNull(new Lc22GenerateParenthesis().generateParenthesis(3));
    }
}