package com.droidsam.app;

import java.util.ArrayList;
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

        List<String> anagrams = new ArrayList<>();

        char[] characters = input.toCharArray();

        for (int i = 0; i < characters.length; i++) {
            char baseChar = characters[i];
            StringBuilder newAnagram = new StringBuilder();
            for (int x = 0; x < characters.length; x++) {
                if (x != i) {
                    newAnagram.append(characters[x]);
                }
            }
            anagrams.add(baseChar + newAnagram.toString());
            if(characters.length > 2) {
                anagrams.add(baseChar + newAnagram.reverse().toString());
            }
        }

        return anagrams;
    }
}
