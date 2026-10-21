
package com.example.wordcounter;

import org.junit.Test;
import static org.junit.Assert.*;

public class ExampleUnitTest {

    TextMetricsCounter counter = new TextMetricsCounter();

    @Test
    public void testWords() {
        assertEquals(3, counter.countWords("Hello world today"));
    }

    @Test
    public void testSentences() {
        assertEquals(2, counter.countSentences("Hello. How are you?"));
    }

    @Test
    public void testCharacters() {
        assertEquals(5, counter.countCharacters("Hello"));
    }

    @Test
    public void testNumbers() {
        assertEquals(2, counter.countNumbers("I have 12 apples and 3.5 oranges"));
    }

    @Test
    public void testEmptyText() {
        assertEquals(0, counter.countWords(""));
    }
}
