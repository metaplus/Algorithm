package problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc299GetHintTest {

    @Test
    void getHint() {
        assertEquals("3A0B", new Lc299GetHint().getHint("1122", "1222"));
    }
}