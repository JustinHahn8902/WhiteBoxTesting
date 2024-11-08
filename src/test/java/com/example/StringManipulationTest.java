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
    
}
