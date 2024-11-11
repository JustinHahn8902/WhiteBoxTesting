package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StringManipulationTestAI {

    // AI TESTS:

    @Test
    public void testMaxSingleDigitFrequency() {
        char[] inputArr = {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'};
        int expectedLen = 2;  // Expected compression output would be "x" "9"

        int res;
        StringManipulation sm = new StringManipulation();
        res = sm.compress(inputArr);

        assertEquals(expectedLen, res, "Length should be 2 because 'x' appears 9 times, fitting within a single digit count.");
    }

    @Test
    public void testMixedRepetitions() {
        char[] inputArr = {'a', 'a', 'b', 'b', 'b', 'c', 'd', 'd', 'd', 'd', 'e'};
        int expectedLen = 8;

        int res;
        StringManipulation sm = new StringManipulation();
        res = sm.compress(inputArr);

        assertEquals(expectedLen, res, "The compressed length should match the varying repetitions for each character group based on function behavior.");
    }

    @Test
    public void testEmptyArray() {
        char[] inputArr = {};
        int expectedLen = 0;  // Expected length is 0 for an empty array

        int res;
        StringManipulation sm = new StringManipulation();
        res = sm.compress(inputArr);

        assertEquals(expectedLen, res, "Length should be 0 for an empty character array.");
    }

    @Test
    public void testAllUniqueCharacters() {
        char[] inputArr = {'a', 'b', 'c', 'd', 'e'};
        int expectedLen = 5;  // Expected length remains unchanged for unique characters

        int res;
        StringManipulation sm = new StringManipulation();
        res = sm.compress(inputArr);

        assertEquals(expectedLen, res, "Length should be 5 as there are no consecutive characters to compress.");
    }

    @Test
    public void testSingleCharacter() {
        char[] inputArr = {'a'};
        int expectedLen = 1;  // Expected length for a single character

        int res;
        StringManipulation sm = new StringManipulation();
        res = sm.compress(inputArr);

        assertEquals(expectedLen, res, "Length should be 1 for a single character without repetition.");
    }
}
