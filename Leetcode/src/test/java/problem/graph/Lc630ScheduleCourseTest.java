package problem.graph;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc630ScheduleCourseTest {

    @Test
    void scheduleCourse() {
        assertEquals(18, new Lc630ScheduleCourse().scheduleCourse(ArrayParse.parse2DIntArray("[[277,920],[96,7037],[707,7967],[924,4803],[175,9258],[471,6829],[572,2194],[524,9739],[908,2786],[86,7136],[702,963],[685,9322],[495,4101],[537,886],[195,1970],[409,6991],[634,6742],[805,8007],[773,6631]]")));
        assertEquals(3, new Lc630ScheduleCourse().scheduleCourse(ArrayParse.parse2DIntArray("[[9,14],[7,12],[1,11],[4,7]]")));
        assertEquals(5, new Lc630ScheduleCourse().scheduleCourse(ArrayParse.parse2DIntArray("[[5,15],[3,19],[6,7],[2,10],[5,16],[8,14],[10,11],[2,19]]")));
        assertEquals(0, new Lc630ScheduleCourse().scheduleCourse(ArrayParse.parse2DIntArray("[[3,2],[4,3]]")));
        assertEquals(18, new Lc630ScheduleCourse().scheduleCourse(ArrayParse.parse2DIntArray("[[914,9927],[333,712],[163,5455],[835,5040],[905,8433],[417,8249],[921,9553],[913,7394],[303,7525],[582,8658],[86,957],[40,9152],[600,6941],[466,5775],[718,8485],[34,3903],[380,9996],[316,7755]]")));
        assertEquals(3, new Lc630ScheduleCourse().scheduleCourse(ArrayParse.parse2DIntArray("[[100, 200], [200, 1300], [1000, 1250], [2000, 3200]]")));
    }
}