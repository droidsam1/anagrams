package com.droidsam.app;

import java.util.Collections;
import java.util.List;

public class Anagrams {
    public static List<String> getPotentialAnagramsFor(String input) {
        if (input.isBlank()) {
            return Collections.emptyList();
        }

        if (input.length() == 1) {
            return List.of(input);
        }

        return List.of(input, new StringBuilder(input).reverse().toString());
    }
}
