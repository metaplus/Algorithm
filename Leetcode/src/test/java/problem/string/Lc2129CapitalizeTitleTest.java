package problem.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lc2129CapitalizeTitleTest {

    @Test
    void capitalizeTitle() {
        assertEquals("l hv",new Lc2129CapitalizeTitle().capitalizeTitle("L hV"));
        assertEquals("Capitalize The Title",new Lc2129CapitalizeTitle().capitalizeTitle("capiTalIze tHe titLe"));
        assertEquals("First Letter of Each Word",new Lc2129CapitalizeTitle().capitalizeTitle("First leTTeR of EACH Word"));
    }
}