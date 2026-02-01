package problem.deque.priority;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;
import problem.heap.priority.Lc2402MostBooked;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc2402MostBookedTest {

    @Test
    void mostBooked() {
        assertEquals(0, new Lc2402MostBooked()
                .mostBooked(4, ArrayParse.parse2DIntArray("[[18,19],[3,12],[17,19],[2,13],[7,10]]")));
        assertEquals(1, new Lc2402MostBooked()
                .mostBooked(3, ArrayParse.parse2DIntArray("[[1,20],[2,10],[3,5],[4,9],[6,8]]")));
    }
}