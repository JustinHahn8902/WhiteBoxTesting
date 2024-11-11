package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StringManipulationTest {

    // MANUAL TESTS:

    @Test
    public void testSimpleCompress() {
        char[] inputArr = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        String[] outputArr = {"a", "2", "b", "2", "c", "3"};
        int expectedLen = outputArr.length;

        int res;
        StringManipulation sm = new StringManipulation();
        res = sm.compress(inputArr);

        assertEquals(expectedLen, res, "Example output array length should match the provided");
    }

    @Test
    public void testEmptyArr() {
        char[] inputArr = {};
        int expectedLen = 0;

        int res;
        StringManipulation sm = new StringManipulation();
        res = sm.compress(inputArr);

        assertEquals(expectedLen, res, "Output array length should be 0");
    }

    @Test
    public void testSingleCharsArr() {
        char[] inputArr = {'a', 'b', 'c'};
        int expectedLen = 3;

        int res;
        StringManipulation sm = new StringManipulation();
        res = sm.compress(inputArr);

        assertEquals(expectedLen, res, "Output array should be just the characters and no length after the characters");
    }

    @Test
    public void testDoubleDigitLength() {
        char[] inputArr = {'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c'};
        int expectedLen = 3;

        int res;
        StringManipulation sm = new StringManipulation();
        res = sm.compress(inputArr);

        assertEquals(expectedLen, res, "Length should be 3 because length of \"c\" dups is double digits so it takes up 2 array slots");
    }

    @Test
    public void testRepeatingCharLaterArr() {
        char[] inputArr = {'a', 'a', 'b', 'a', 'b', 'b', 'a'};
        int expectedLen = 7;

        int res;
        StringManipulation sm = new StringManipulation();
        res = sm.compress(inputArr);

        assertEquals(expectedLen, res, "Should be separate lengths for each repeated character coming later in the array");
    }

    @Test
    public void testConsecutiveSingleCharacters() {
        char[] inputArr = {'a', 'b', 'c', 'd', 'e'};
        int expectedLen = inputArr.length;

        int res;
        StringManipulation sm = new StringManipulation();
        res = sm.compress(inputArr);

        assertEquals(expectedLen, res, "Should be identical to input");
    }

    @Test
    public void testTripleDigitRepetitions() {
        char[] inputArr = new char[100];
        for (int i = 0; i < 100; i++) {
            inputArr[i] = 'x';
        }
        int expectedLen = 4; // "x", "1", "0", "0"

        int res;
        StringManipulation sm = new StringManipulation();
        res = sm.compress(inputArr);

        assertEquals(expectedLen, res, "Should handle a large count of repeated characters correctly");
    }

    @Test
    public void testMultipleRepeatsWithSingleOccurrence() {
        char[] inputArr = {'a', 'a', 'b', 'c', 'c', 'c', 'd'};
        int expectedLen = 6; // "a", "2", "b", "c", "3", "d"

        int res;
        StringManipulation sm = new StringManipulation();
        res = sm.compress(inputArr);

        assertEquals(expectedLen, res, "Should handle isolated characters correctly");
    }


}
