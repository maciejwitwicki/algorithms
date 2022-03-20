package com.example;

public class LongTextDistance {

    int calculate(String text, String a, String b) {

        var length = text.length();
        var knownLocationA = -1;
        var knownLocationB = -1;
        var minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {

            var allowedAStart = length - a.length() - 1;
            if (i < allowedAStart) {
                if (text.substring(i, i + a.length()).equals(a)) {
                    knownLocationA = i;
                }
            }
            var allowedBStart = length - b.length() - 1;

            if (i < allowedBStart) {
                if (text.substring(i, i + b.length()).equals(b)) {
                    knownLocationB = i;
                }
            }

            if (knownLocationA > -1 && knownLocationB > -1) {
                minDistance = Math.min(minDistance, Math.abs(knownLocationA - knownLocationB));
            }

        }

        return minDistance;
    }

}
