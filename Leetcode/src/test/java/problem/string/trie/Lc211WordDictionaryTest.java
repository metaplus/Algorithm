package problem.string.trie;

import org.junit.jupiter.api.Test;
import problem.string.trie.Lc211WordDictionary.WordDictionary;

import static org.junit.jupiter.api.Assertions.*;

class Lc211WordDictionaryTest {

    @Test
    void searchDict(){
        WordDictionary dictionary = new WordDictionary();
        dictionary.addWord("bad");
        dictionary.addWord("dad");
        dictionary.addWord("mad");
        assertTrue(dictionary.search("bad"));
        assertFalse(dictionary.search("pad"));
        assertTrue(dictionary.search(".ad"));
        assertTrue(dictionary.search("b.."));
    }
}