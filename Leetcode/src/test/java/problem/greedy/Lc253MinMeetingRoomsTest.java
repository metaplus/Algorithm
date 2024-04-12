package problem.greedy;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.*;

class Lc253MinMeetingRoomsTest {

    @Test
    void minMeetingRooms() {
        assertEquals(2,new Lc253MinMeetingRooms().minMeetingRooms(ArrayParse.parse2DIntArray("[[2,15],[36,45],[9,29],[16,23],[4,9]]")));
        assertEquals(2,new Lc253MinMeetingRooms().minMeetingRooms(ArrayParse.parse2DIntArray("[[0,30],[5,10],[15,20]]")));
    }
}