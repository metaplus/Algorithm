package problem.pointer;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc301RemoveInvalidParenthesesTest {

    @Test
    void removeInvalidParentheses() {
        assertEquals(ArrayParse.parseStringList("[\"r()()\",\"r(())\",\"(r)()\",\"(r())\"]"), new Lc301RemoveInvalidParentheses().removeInvalidParentheses("(r(()()("));
        assertEquals(ArrayParse.parseStringList("[\"()\"]"), new Lc301RemoveInvalidParentheses().removeInvalidParentheses("()"));
        assertEquals(ArrayParse.parseStringList("[\"\"]"), new Lc301RemoveInvalidParentheses().removeInvalidParentheses("))("));
        assertEquals(ArrayParse.parseStringList("[\"\"]"), new Lc301RemoveInvalidParentheses().removeInvalidParentheses("))"));
        assertEquals(ArrayParse.parseStringList("[\"\"]"), new Lc301RemoveInvalidParentheses().removeInvalidParentheses(")("));
        assertEquals(ArrayParse.parseStringList("[\"()\"]"), new Lc301RemoveInvalidParentheses().removeInvalidParentheses("(()"));
        assertEquals(ArrayParse.parseStringList("[\"x\"]"), new Lc301RemoveInvalidParentheses().removeInvalidParentheses("x("));
        assertEquals(ArrayParse.parseStringList("[\"(a())()\",\"(a)()()\"]"), new Lc301RemoveInvalidParentheses().removeInvalidParentheses("(a)())()"));
    }
}