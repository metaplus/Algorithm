package problem.dp;

import org.junit.jupiter.api.Test;
import problem.dp.sequence.Lc516LongestPalindromeSubseq;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc516LongestPalindromeSubseqTest {

    @Test
    void longestPalindromeSubseq() {
        assertEquals(159, new Lc516LongestPalindromeSubseq().longestPalindromeSubseq("euazbipzncptldueeuechubrcourfpftcebikrxhybkymimgvldiwqvkszfycvqyvtiwfckexmowcxztkfyzqovbtmzpxojfofbvwnncajvrvdbvjhcrameamcfmcoxryjukhpljwszknhiypvyskmsujkuggpztltpgoczafmfelahqwjbhxtjmebnymdyxoeodqmvkxittxjnlltmoobsgzdfhismogqfpfhvqnxeuosjqqalvwhsidgiavcatjjgeztrjuoixxxoznklcxolgpuktirmduxdywwlbikaqkqajzbsjvdgjcnbtfksqhquiwnwflkldgdrqrnwmshdpykicozfowmumzeuznolmgjlltypyufpzjpuvucmesnnrwppheizkapovoloneaxpfinaontwtdqsdvzmqlgkdxlbeguackbdkftzbnynmcejtwudocemcfnuzbttcoew"));
        assertEquals(4, new Lc516LongestPalindromeSubseq().longestPalindromeSubseq("bbbab"));
    }
}