package problem.array.simulate;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc2079WateringPlantsTest {

    @Test
    void wateringPlants() {
        assertEquals(14, new Lc2079WateringPlants().wateringPlants(ArrayParse.parseIntArray("[2,2,3,3]"), 5));
    }
}