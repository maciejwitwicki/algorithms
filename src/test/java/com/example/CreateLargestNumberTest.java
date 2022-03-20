package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class CreateLargestNumberTest {
    private CreateLargestNumber toTest = new CreateLargestNumber();

    @ParameterizedTest
    @CsvSource(textBlock = """
            '45,18,9', 94518
            '2,111,45,18,9', 945218111
            """)
    void find(String input, String expected) {
        var arr = Arrays.stream(input.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        assertEquals(expected, toTest.calculate(arr));

    }

}