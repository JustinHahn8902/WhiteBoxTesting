package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class StringManipulationTestAI {

    private StringManipulation sm = new StringManipulation();

    // AI TESTS:

    private char[] getCompressedChars(char[] chars, int newLength) {
        return Arrays.copyOfRange(chars, 0, newLength);
    }

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
        int expectedLen = 0;

        int res;
        StringManipulation sm = new StringManipulation();
        res = sm.compress(inputArr);

        assertEquals(expectedLen, res, "Length should be 0 for an empty character array.");
    }

    @Test
    public void testSingleCharacter() {
        char[] inputArr = {'a'};
        int expectedLen = 1;

        int res;
        StringManipulation sm = new StringManipulation();
        res = sm.compress(inputArr);

        assertEquals(expectedLen, res, "Length should be 1 for a single character without repetition.");
    }

    @Test
    public void testAllUniqueCharacters() {
        char[] chars = {'a', 'b', 'c', 'd', 'e'};
        int length = sm.compress(chars);
        assertEquals(5, length);
    }

    @Test
    public void testAllSameCharacters() {
        char[] inputArr = {'z', 'z', 'z', 'z', 'z'};
        int expectedLen = 2;

        int res;
        StringManipulation sm = new StringManipulation();
        res = sm.compress(inputArr);

        assertEquals(expectedLen, res, "Length should be 2 because all characters are the same and can be compressed.");
    }

    @Test
    public void testMultipleGroupsOfDuplicates() {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int length = sm.compress(chars);
        assertEquals(6, length);
    }

    @Test
    public void testLongSingleGroupLengthGreaterThan10() {
        char[] chars = {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'};
        int length = sm.compress(chars);
        assertEquals(3, length);
    }

    @Test
    public void testAlternateSingleCharactersAndGroups() {
        char[] chars = {'a', 'b', 'b', 'c', 'c', 'c', 'd'};
        int length = sm.compress(chars);
        assertEquals(6, length);
    }

    @Test
    public void testMixedUppercaseAndLowercaseCharacters() {
        char[] chars = {'A', 'A', 'B', 'B', 'b', 'b', 'c', 'c', 'c'};
        int length = sm.compress(chars);
        assertEquals(8, length);
    }

    @Test
    public void testSingleCharacterRepeatedLarge() {
        char[] chars = new char[2000];
        Arrays.fill(chars, 'z');
        int length = sm.compress(chars);
        assertEquals(5, length);
    }

    @Test
    public void testMixedDigitsAndSpecialCharacters() {
        char[] chars = {'1', '1', '1', '!', '!', 'a', 'a', 'b', 'b', 'b'};
        int length = sm.compress(chars);
        assertEquals(8, length);
    }

    @Test
    public void testBoundaryConditionMinInputSize() {
        char[] chars = {'x'};
        int length = sm.compress(chars);
        assertEquals(1, length);
    }

    @Test
    public void testBoundaryConditionMaxInputSizeWithNoCompression() {
        char[] chars = new char[2000];
        for (int i = 0; i < 2000; i++) {
            chars[i] = (char) ('a' + (i % 26));
        }
        int length = sm.compress(chars);
        assertEquals(2000, length);
        for (int i = 0; i < 2000; i++) {
            assertEquals((char) ('a' + (i % 26)), chars[i]);
        }
    }
}
