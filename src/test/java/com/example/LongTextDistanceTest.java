package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongTextDistanceTest {

    private LongTextDistance toTest = new LongTextDistance();

    @Test
    void testDistance() {
        //given
        var input = "Some yyy yyy long text with xxx yyy various words in it etcetera";
        //when
        var result = toTest.calculate(input, "yyy", "xxx");
        //then
        assertEquals(20, result);
    }

}