package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MedianOfMedianTest {
    private MedianOfMedian toTest = new MedianOfMedian();

    @ParameterizedTest
    @CsvSource(textBlock = """
            '6,4,2,4,4',       4
            '5,8,-1,6,6,1,10', 6
            '7,8,3,4,9,2',     5.5
            '6,3,1,2,5,5',     4
            '1,2,4,7,1',       2
            '0,1,1,2,3,1',     1
            '-4,2,6,0,1',      1
            '0,1,3,3,1,1,2,1', 1
            '2,3,7,6,4,2',     3.5
            '5,2,1,1',         1.5
            '4,3,1,1',         2
            """)
    void testMedian(String input, double expected) {
        //given
        var inp = Arrays.stream(input.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
        //when
        var result = toTest.selectKthElement(inp, inp.size());
        //then
        assertEquals(expected, result);
    }
}