package problem.hashmap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lc2671FrequencyTrackerTest {


    @Test
    void track(){
        Lc2671FrequencyTracker.FrequencyTracker tracker=new Lc2671FrequencyTracker.FrequencyTracker();
        tracker.deleteOne(5);
        tracker.hasFrequency(1);
        tracker.hasFrequency(1);
        tracker.deleteOne(3);
        tracker.hasFrequency(1);
        tracker.hasFrequency(1);
        tracker.add(7);
        tracker.deleteOne(7);
        tracker.deleteOne(7);

    }
}