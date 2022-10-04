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
}
