package com.example;

import java.util.Optional;

public class FirstUniqueLetter {

    Optional<Character> calculate(String text) {


        for (int i = 0; i < text.length(); i++) {
            var unique = true;
            for (int j = 0; j < text.length(); j++) {

                if (i == j) continue;
                if (text.charAt(i) == text.charAt(j)) {
                    unique = false;
                    break;
                }
            }
            if (unique) {
                return Optional.of(text.charAt(i));
            }
        }

        return Optional.empty();
    }

}
