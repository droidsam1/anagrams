package com.droidsam.app;

import java.util.Collections;
import java.util.List;

public class Anagrams {
    public static List<String> getPotentialAnagramsFor(String input) {
        if (input.isBlank()) {
            return Collections.emptyList();
        }

        return List.of(input);
    }
}
