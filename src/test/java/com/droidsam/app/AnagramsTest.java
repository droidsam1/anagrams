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


    @Test
    public void shouldReturnTwentyFourAnagramsWhenInputIsFourCharacters() {
        String input = "biro";

        List<String> resultAnagrams = Anagrams.getPotentialAnagramsFor(input);

        Assertions.assertEquals(24, resultAnagrams.size());
        assertContains(resultAnagrams, "biro");
        assertContains(resultAnagrams, "bior");
        assertContains(resultAnagrams, "brio");
        assertContains(resultAnagrams, "broi");
        assertContains(resultAnagrams, "boir");
        assertContains(resultAnagrams, "bori");

        assertContains(resultAnagrams, "ibro");
        assertContains(resultAnagrams, "ibor");
        assertContains(resultAnagrams, "irbo");
        assertContains(resultAnagrams, "irob");
        assertContains(resultAnagrams, "iobr");
        assertContains(resultAnagrams, "iorb");

        assertContains(resultAnagrams, "rbio");
        assertContains(resultAnagrams, "rboi");
        assertContains(resultAnagrams, "ribo");
        assertContains(resultAnagrams, "riob");
        assertContains(resultAnagrams, "roib");
        assertContains(resultAnagrams, "robi");

        assertContains(resultAnagrams, "obir");
        assertContains(resultAnagrams, "obri");
        assertContains(resultAnagrams, "oirb");
        assertContains(resultAnagrams, "oirb");
        assertContains(resultAnagrams, "orbi");
        assertContains(resultAnagrams, "orib");
    }


    private void assertContains(List<String> resultAnagrams, String valueToBeContained) {
        Assertions.assertEquals(valueToBeContained, resultAnagrams.stream().filter(a -> a.equals(valueToBeContained)).findFirst().orElseThrow());
    }

}