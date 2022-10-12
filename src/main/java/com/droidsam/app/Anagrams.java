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

        return getAnagramsFor(input.toCharArray());
    }

    private static List<String> getAnagramsFor(char[] inputChars) {

        List<String> anagrams = new ArrayList<>();
        if (inputChars.length == 2) {
            anagrams.add("" + inputChars[0] + inputChars[1]);
            anagrams.add("" + inputChars[1] + inputChars[0]);
            return anagrams;
        } else {
            for (int i = 0; i < inputChars.length; i++) {
                char c = inputChars[i];
                getAnagramsFor(getSameArrayExceptCharAtPosition(inputChars, i)).forEach(anagram -> anagrams.add(c + anagram));
            }
        }
        return anagrams;
    }

    private static char[] getSameArrayExceptCharAtPosition(char[] inputArray, int positionToFilter) {
        char[] result = new char[inputArray.length - 1];
        int resultPosition = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (i != positionToFilter) {
                result[resultPosition++] = inputArray[i];
            }
        }
        return result;
    }

}
