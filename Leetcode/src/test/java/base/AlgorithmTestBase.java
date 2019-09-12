package base;

import annotation.Problem;
import com.google.common.reflect.TypeToken;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.*;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class AlgorithmTestBase<T> {

    protected final static String CASE_NAME = "[No.{index}] Args: {arguments}";

    @SuppressWarnings({"unchecked", "UnstableApiUsage"})
    private final Class<T> algorithmClazz = (Class<T>) new TypeToken<T>(getClass()) {
    }.getRawType();
    protected T algorithm;

    @BeforeEach
    void setUp(TestInfo testInfo, TestReporter reporter) {
        reporter.publishEntry("displayName", testInfo.getDisplayName());
        assertNull(algorithm);
        try {
            algorithm = algorithmClazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            fail("algorithm instance initialized failure");
        }
    }

    @AfterEach
    void tearDown() {
        algorithm = null;
    }
}