package com.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

public class CreateLargestNumber {

    String calculate(int[] numbers) {

        Comparator<String> reversed = Comparator.<String>naturalOrder().reversed();
        String result = Arrays.stream(numbers)
                .mapToObj(Integer::toString)
                .sorted(reversed)
                .collect(Collectors.joining());
        return result;
    }

}
