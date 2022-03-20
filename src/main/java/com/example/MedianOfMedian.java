package com.example;

import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MedianOfMedian {

    private MedianSimple medianSimple = new MedianSimple();

    double calculate(int[][] numbers) {
        return 0;
    }

    // find K-th element (n/2 for median)
    double selectKthElement(List<Integer> numbers, int K) {

        if (numbers.size() == 1) {
            return numbers.get(0);
        }

        var fives = Flux.fromIterable(numbers)
                .buffer(5)
                .collectList()
                .block();

        var medians = fives.stream()
                .map(five -> {
                    five.sort(Comparator.naturalOrder());
                    return five.get( five.size() / 2);
                })
                .toList();

        // pivot value is a median of medians (approximate median of 'numbers' collection)
        var pivot = 0.0;
        if (medians.size() <= 5) {
            var medianStream = medians.stream().sorted(Comparator.naturalOrder()).toList();
            pivot = medianStream.get(medians.size() / 2);
        } else {
            pivot = selectKthElement(medians, medians.size() / 2);
        }

        var left = new ArrayList<Integer>(); // less than pivot
        var equal = new ArrayList<Integer>(); // equal to pivot
        var right = new ArrayList<Integer>(); // greater than pivot

        double finalPivot = pivot;
        numbers.forEach(i -> {
            if (i < finalPivot) {
                left.add(i);
            } else if (i == finalPivot) {
                equal.add(i);
            } else {
                right.add(i);
            }
        });

        if (K < left.size()) {
            return selectKthElement(left, K);
        } else if (K > left.size()) {
            return selectKthElement(right, K - left.size() - 1);
        } else return pivot;
    }

}
