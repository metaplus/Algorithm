package problem.pointer;

import base.AlgorithmTest;
import base.AlgorithmTestBase;
import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;
import problem.array.pointer.Lc301RemoveInvalidParentheses;

import java.util.List;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc301RemoveInvalidParenthesesTest extends AlgorithmTest {

    @Test
    void removeInvalidParentheses() {
        assertSortedEquals(ArrayParse.parseStringList("[\"r()()\",\"r(())\",\"(r)()\",\"(r())\"]"), new Lc301RemoveInvalidParentheses().removeInvalidParentheses("(r(()()("));
        assertSortedEquals(ArrayParse.parseStringList("[\"()\"]"), new Lc301RemoveInvalidParentheses().removeInvalidParentheses("()"));
        assertSortedEquals(ArrayParse.parseStringList("[\"\"]"), new Lc301RemoveInvalidParentheses().removeInvalidParentheses("))("));
        assertSortedEquals(ArrayParse.parseStringList("[\"\"]"), new Lc301RemoveInvalidParentheses().removeInvalidParentheses("))"));
        assertSortedEquals(ArrayParse.parseStringList("[\"\"]"), new Lc301RemoveInvalidParentheses().removeInvalidParentheses(")("));
        assertSortedEquals(ArrayParse.parseStringList("[\"()\"]"), new Lc301RemoveInvalidParentheses().removeInvalidParentheses("(()"));
        assertSortedEquals(ArrayParse.parseStringList("[\"x\"]"), new Lc301RemoveInvalidParentheses().removeInvalidParentheses("x("));
        assertSortedEquals(ArrayParse.parseStringList("[\"(a())()\",\"(a)()()\"]"), new Lc301RemoveInvalidParentheses().removeInvalidParentheses("(a)())()"));
    }
}