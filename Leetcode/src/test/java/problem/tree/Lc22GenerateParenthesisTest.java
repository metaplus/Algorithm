package problem.tree;

import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;
import problem.search.dfs.Lc22GenerateParenthesis;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc22GenerateParenthesisTest {

    @Test
    void generateParenthesis() {
        assertEquals(ArrayParse.parseStringSet("[\"((()))\",\"(()())\",\"(())()\",\"()(())\",\"()()()\"]"), UnifiedSet.newSet(new Lc22GenerateParenthesis().generateParenthesis(3)));
    }
}