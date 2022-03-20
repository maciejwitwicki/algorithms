package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class FirstUniqueLetterTest {

    private FirstUniqueLetter toTest = new FirstUniqueLetter();

    @ParameterizedTest
    @CsvSource(textBlock = """
            abcdefghijklmnopa, b
            aabbccddeeffggh, h
            """)
    void testIt(String text, char expected) {
        assertEquals(Optional.of(expected), toTest.calculate(text));
    }

    @Test
    void testEmpty() {
        assertEquals(Optional.empty(), toTest.calculate("aabbccdd"));
    }
}