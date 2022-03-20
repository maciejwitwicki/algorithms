package com.example;

import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MedianOfMedian {

    private MedianSimple medianSimple = new MedianSimple();

    double calculate(int[][] numbers) {
        return 0;
    }

    double medianOfMedians(List<Integer> numbers) {
        var fives = Flux.fromIterable(numbers)
                .buffer(5)
                .collectList()
                .block();

        var medians = fives.stream()
                .map(five -> medianSimple.calculate(five))
                .toList();

        var medianOfMedians = medianSimple.calculate(medians);


        var left = new ArrayList<>();
        var right = new ArrayList<>();

        numbers.stream()
                .forEach(i -> {

                });

        return 0;
    }

}
