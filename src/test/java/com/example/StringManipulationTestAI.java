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
    public void testSingleCharacter() {
        char[] chars = {'a'};
        int length = sm.compress(chars);
        assertEquals(1, length);
        assertEquals(new char[] {'a'}, getCompressedChars(chars, length));
    }

    @Test
    public void testAllUniqueCharacters() {
        char[] chars = {'a', 'b', 'c', 'd', 'e'};
        int length = sm.compress(chars);
        assertEquals(5, length);
        assertEquals(new char[] {'a', 'b', 'c', 'd', 'e'}, getCompressedChars(chars, length));
    }

    @Test
    public void testSingleGroupOfDuplicates() {
        char[] chars = {'a', 'a', 'a', 'a'};
        int length = sm.compress(chars);
        assertEquals(2, length);
        assertEquals(new char[] {'a', '4'}, getCompressedChars(chars, length));
    }

    @Test
    public void testMultipleGroupsOfDuplicates() {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int length = sm.compress(chars);
        assertEquals(6, length);
        assertEquals(new char[] {'a', '2', 'b', '2', 'c', '3'}, getCompressedChars(chars, length));
    }

    @Test
    public void testLongSingleGroupLengthGreaterThan10() {
        char[] chars = {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'};
        int length = sm.compress(chars);
        assertEquals(4, length);
        assertEquals(new char[] {'a', '1', '2'}, getCompressedChars(chars, length));
    }

    @Test
    public void testAlternateSingleCharactersAndGroups() {
        char[] chars = {'a', 'b', 'b', 'c', 'c', 'c', 'd'};
        int length = sm.compress(chars);
        assertEquals(7, length);
        assertEquals(new char[] {'a', 'b', '2', 'c', '3', 'd'}, getCompressedChars(chars, length));
    }

    @Test
    public void testMixedUppercaseAndLowercaseCharacters() {
        char[] chars = {'A', 'A', 'B', 'B', 'b', 'b', 'c', 'c', 'c'};
        int length = sm.compress(chars);
        assertEquals(9, length);
        assertEquals(new char[] {'A', '2', 'B', '2', 'b', '2', 'c', '3'}, getCompressedChars(chars, length));
    }

    @Test
    public void testSingleCharacterRepeatedLarge() {
        char[] chars = new char[2000];
        Arrays.fill(chars, 'z');
        int length = sm.compress(chars);
        assertEquals(5, length);
        assertEquals(new char[] {'z', '2', '0', '0', '0'}, getCompressedChars(chars, length));
    }

    @Test
    public void testMixedDigitsAndSpecialCharacters() {
        char[] chars = {'1', '1', '1', '!', '!', 'a', 'a', 'b', 'b', 'b'};
        int length = sm.compress(chars);
        assertEquals(9, length);
        assertEquals(new char[] {'1', '3', '!', '2', 'a', '2', 'b', '3'}, getCompressedChars(chars, length));
    }

    @Test
    public void testBoundaryConditionMinInputSize() {
        char[] chars = {'x'};
        int length = sm.compress(chars);
        assertEquals(1, length);
        assertEquals(new char[] {'x'}, getCompressedChars(chars, length));
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
