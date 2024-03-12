package problem.hashmap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lc424CharacterReplacementTest {

    @Test
    void characterReplacement() {
        assertEquals(7, new Lc424CharacterReplacement().characterReplacement("KRSCDCSONAJNHLBMDQGIFCPEKPOHQIHLTDIQGEKLRLCQNBOHNDQGHJPNDQPERNFSSSRDEQLFPCCCARFMDLHADJADAGNNSBNCJQOF" , 4));
        assertEquals(4, new Lc424CharacterReplacement().characterReplacement("AAAA", 2));
        assertEquals(4, new Lc424CharacterReplacement().characterReplacement("AABABBA", 1));
        assertEquals(4, new Lc424CharacterReplacement().characterReplacement("ABAB", 2));
    }
}