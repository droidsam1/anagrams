package com.droidsam.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

        if (inputChars.length == 1) {
            return List.of(String.valueOf(inputChars));
        }

        List<String> anagrams = new ArrayList<>();
        for (int i = 0; i < inputChars.length; i++) {
            char anagramStartingChar = inputChars[i];
            char[] restOfChars = dropCharAtPosition(inputChars, i);

            anagrams.addAll(concatenate(anagramStartingChar, getAnagramsFor(restOfChars)));
        }
        return anagrams;
    }

    private static List<String> concatenate(char prefixChar, List<String> anagramsOfRestChars) {
        return anagramsOfRestChars.stream().map(anagram -> prefixChar + anagram).collect(Collectors.toList());
    }

    private static char[] dropCharAtPosition(char[] inputArray, int positionToFilter) {
        char[] newArray = new char[inputArray.length - 1];
        int newArrayIndex = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (i != positionToFilter) {
                newArray[newArrayIndex++] = inputArray[i];
            }
        }
        return newArray;
    }

}
