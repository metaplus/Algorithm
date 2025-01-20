package base;

import java.util.List;
import java.util.Objects;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AlgorithmTest {


    protected static void assertSortedEquals(List<?> a, List<?> b) {
        if (Objects.isNull(a) || Objects.isNull(b)) {
            assertEquals(a, b);
            return;
        }
        assertEquals(new TreeSet<>(a), new TreeSet<>(b));
    }
}
