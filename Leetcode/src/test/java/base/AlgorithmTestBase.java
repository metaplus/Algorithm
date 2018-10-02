package base;

import org.junit.jupiter.api.*;

import java.util.function.Supplier;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class AlgorithmTestBase<T> implements Supplier<T> {

    protected              T      algorithm;
    protected static final String CASE_NAME = "[No.{index}] Args: {arguments}";

    @BeforeEach
    void setUp(TestInfo testInfo, TestReporter reporter) {
        reporter.publishEntry("displayName", testInfo.getDisplayName());
        algorithm = get();
    }

    @AfterEach
    void tearDown() {
        algorithm = null;
    }
}