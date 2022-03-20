package com.example;

import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.DoubleConsumer;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class MedianSimple {

    /**
     * [0, 1, 2, 3,    4, 5,     6, 7, 8, 9]
     * [0, 1, 2, 3, 4,   5,    6, 7, 8, 9, 10]
     *
     * @param numbers
     * @return
     */


    double calculate(int[] numbers) {
        double[] doubles = new double[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            doubles[i] = (int) numbers[i];
        }
        return calculate(doubles);
    }

    double calculate(double[] numbers) {

        var sorted = Arrays.stream(numbers).sorted().boxed().toList();
        var n = sorted.size();

        if (n % 2 == 0) {
            var index = n / 2;
            return (sorted.get(index - 1) + sorted.get(index)) / 2D;
        } else {
            var index = n / 2;
            return sorted.get(index);
        }
    }

    <T extends Number> double calculate(List<T> numbers) {

        double[] primitives = new double[numbers.size()];

        IntStream.range(0, numbers.size())
                .mapToDouble(i -> i)
                .forEach(i -> {
                    int index = (int) i;
                    primitives[index] = i;
                });

        return calculate(primitives);
    }

}
