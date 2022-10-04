package com.droidsam.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AnagramsTest {


    @Test
    public void potentialAnagramsShouldReturnAListOfStrings() {
        Assertions.assertInstanceOf(List.class, Anagrams.getPotentialAnagramsFor(""));
    }

    @Test
    public void potentialAnagramsShouldReturnAnEmptyListWhenInputIsEmpty() {
        Assertions.assertTrue(Anagrams.getPotentialAnagramsFor("").isEmpty());
    }

    @Test
    public void potentialAnagramsShouldReturnOneOutputWhenInputIsASingleCharacter() {
        String input = "a";
        Assertions.assertEquals(1, Anagrams.getPotentialAnagramsFor(input).size());
        Assertions.assertEquals(input, Anagrams.getPotentialAnagramsFor(input).get(0));
    }
}
