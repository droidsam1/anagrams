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

        List<String> resultAnagrams = Anagrams.getPotentialAnagramsFor(input);

        Assertions.assertEquals(1, resultAnagrams.size());

        assertContains(resultAnagrams, input);
    }

    @Test
    public void shouldReturnTwoAnagramsWhenInputIsTwoCharacters() {
        String input = "ab";

        List<String> resultAnagrams = Anagrams.getPotentialAnagramsFor(input);

        Assertions.assertEquals(2, resultAnagrams.size());
        assertContains(resultAnagrams, "ab");
        assertContains(resultAnagrams, "ba");
    }

    @Test
    public void shouldReturnSixAnagramsWhenInputIsThreeCharacters() {
        String input = "abc";

        List<String> resultAnagrams = Anagrams.getPotentialAnagramsFor(input);

        Assertions.assertEquals(6, resultAnagrams.size());
        assertContains(resultAnagrams, "abc");
        assertContains(resultAnagrams, "acb");
        assertContains(resultAnagrams, "bac");
        assertContains(resultAnagrams, "bca");
        assertContains(resultAnagrams, "cba");
        assertContains(resultAnagrams, "cab");
    }

    private void assertContains(List<String> resultAnagrams, String valueToBeContained) {
        Assertions.assertEquals(valueToBeContained, resultAnagrams.stream().filter(a -> a.equals(valueToBeContained)).findFirst().orElseThrow());
    }

}