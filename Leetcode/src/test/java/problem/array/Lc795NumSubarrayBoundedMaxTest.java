package problem.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc795NumSubarrayBoundedMaxTest {

    @Test
    void numSubarrayBoundedMax() {
        assertEquals(19, new Lc795NumSubarrayBoundedMax().numSubarrayBoundedMax(
                new int[]{876,880,482,260,132,421,732,703,795,420,871,445,400,291,358,589,617,202,755,810,227,813,549,791,418,528,835,401,526,584,873,662,13,314,988,101,299,816,833,224,160,852,179,769,646,558,661,808,651,982,878,918,406,551,467,87,139,387,16,531,307,389,939,551,613,36,528,460,404,314,66,111,458,531,944,461,951,419,82,896,467,353,704,905,705,760,61,422,395,298,127,516,153,299,801,341,668,598,98,241}, 658, 719));
        assertEquals(0, new Lc795NumSubarrayBoundedMax().numSubarrayBoundedMax(
                new int[]{16, 69, 88, 85, 79, 87, 37, 33, 39, 34}, 55, 57));
        assertEquals(3, new Lc795NumSubarrayBoundedMax().numSubarrayBoundedMax(
                new int[]{2, 1, 4, 3}, 2, 3));
        // 55 36 55 52
        // 55-36 36-5 5-55 55-14
        // 55-36-5 36-5-55 5-55-14 55-14-9
        // 55-36-5-55 36-5-55-14 5-55-14-9 55-14-9-7
        // 55-36-5-55-14 36-5-55-14-9 5-55-14-9-7
        // 55-36-5-55-14-9 36-5-55-14-9-7
        // 55-36-5-55-5-55-14-7
        assertEquals(22, new Lc795NumSubarrayBoundedMax().numSubarrayBoundedMax(
                new int[]{73, 55, 36, 5, 55, 14, 9, 7, 72, 52}, 32, 69));


    }
}