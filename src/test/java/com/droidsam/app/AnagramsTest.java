package com.droidsam.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AnagramsTest {


    @Test
    public void shouldReturnAListOfStrings() {
        Assertions.assertInstanceOf(List.class, Anagrams.getPotentialAnagramsFor(""));
    }

    @Test
    public void shouldReturnAnEmptyListWhenInputIsEmpty() {
        Assertions.assertTrue(Anagrams.getPotentialAnagramsFor("").isEmpty());
    }

    @Test
    public void shouldReturnOneAnagramWhenInputIsASingleCharacter() {
        String input = "a";
        Assertions.assertEquals(1, Anagrams.getPotentialAnagramsFor(input).size());
        Assertions.assertEquals(input, Anagrams.getPotentialAnagramsFor(input).get(0));
    }

    @Test
    public void shouldReturnTwoAnagramsWhenInputIsTwoCharacters() {
        String input = "ab";
        Assertions.assertEquals(2, Anagrams.getPotentialAnagramsFor(input).size());
        Assertions.assertTrue(Anagrams.getPotentialAnagramsFor(input).contains("ab"));
        Assertions.assertTrue(Anagrams.getPotentialAnagramsFor(input).contains("ba"));
    }
}
