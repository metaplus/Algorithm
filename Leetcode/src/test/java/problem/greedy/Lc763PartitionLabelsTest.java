package problem.greedy;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;
import problem.dp.Lc763PartitionLabels;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc763PartitionLabelsTest {

    @Test
    void partitionLabels() {
        assertEquals(ArrayParse.parseIntList("[9,7,8]"), new Lc763PartitionLabels().partitionLabels("ababcbacadefegdehijhklij"));
    }
}