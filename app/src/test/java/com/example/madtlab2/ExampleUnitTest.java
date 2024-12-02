package com.example.madtlab2;

import org.junit.Test;

import static org.junit.Assert.*;


public class ExampleUnitTest {

    //CountWords
    @Test
    public void testCountWords_ValidInput() {
        String input = "Testing testing testing";
        int result = WordCounter.countWords(input);
        assertEquals(3,result);
    }

    @Test
    public void testCountWords_SingleInput() {
        String input = "Testing";
        int result = WordCounter.countWords(input);
        assertEquals(1,result);
    }

    @Test
    public void testCountWords_Punctuation() {
        String input = "Testing; testing, testing.";
        int result = WordCounter.countWords(input);
        assertEquals(3,result);
    }

    @Test
    public void testCountWords_EmptyString() {
        String input = "";
        int result = WordCounter.countWords(input);
        assertEquals(0,result);
    }

    @Test
    public void testCountWords_NullInput() {
        String input = null;
        int result = WordCounter.countWords(input);
        assertEquals(0,result);
    }

    @Test
    public void testCountWords_SpecialCharacters() {
        String input = "Testing! test1ng testing@";
        int result = WordCounter.countWords(input);
        assertEquals(3,result);
    }

    //CountCharacters
    @Test
    public void testCountCharacters_WithTypicalSentence() {
        String input = "Hello world!";
        int result = WordCounter.countCharacters(input);
        assertEquals(11, result); // Excludes spaces
    }

    @Test
    public void testCountCharacters_WithEmptyString() {
        String input = "";
        int result = WordCounter.countCharacters(input);
        assertEquals(0, result);
    }

    @Test
    public void testCountCharacters_WithNullInput() {
        String input = null;
        int result = WordCounter.countCharacters(input);
        assertEquals(0, result);
    }

    @Test
    public void testCountCharacters_WithSpacesOnly() {
        String input = "   ";
        int result = WordCounter.countCharacters(input);
        assertEquals(0, result); // Excludes spaces
    }

    @Test
    public void testCountCharacters_WithSpecialCharacters() {
        String input = "Hello@123";
        int result = WordCounter.countCharacters(input);
        assertEquals(9, result); // Includes special characters
    }
}