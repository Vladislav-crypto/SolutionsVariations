package ua.com.foxminded.task1.anagram;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AnagramTest {

    Anagram anagram = new Anagram();


    @Test
    void reverseText_ShouldThrowIllegalArgumentException_WhenInputIsNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            anagram.reverseText(null);
        });
        String expected = "shouldn't input null";
        String actual = exception.getMessage();
        assertEquals(expected, actual);
    }

    @Test
    void reverseText_ShouldReturnEmptyString_WhenInputsEmptyString() {
        String input = "";
        String actual = anagram.reverseText(input);
        String expected = "";
        assertEquals(expected, actual);
    }

    @Test
    void reverseText_ShouldReturnOneSpace_WhenOneSpaceInput() {
        String input = "\\s";
        String actual = anagram.reverseText(input);
        String expected = "\\s";
        assertEquals(expected, actual);
    }

    @Test
    void reverseText_ShouldReturnTwoSpace_WhenTwoSpaceInput() {
        String input = "\\s*";
        String actual = anagram.reverseText(input);
        String expected = "\\s*";
        assertEquals(expected, actual);
    }

    @Test
    void reverseText_ShouldReturnTheStringVithThreeSpacesBetweenWords_WhenInputStringHasThreeSpacesBetweenWords() {
        String input = "a1bcd   efg!h";
        String actual = anagram.reverseText(input);
        String expected = "d1cba   hgf!e";
        assertEquals(expected, actual);
    }

    @Test
    void reverseText_ShouldReturnTheStringWithSeveralSpaces_WhenInputStringHasSeveralSpaces() {
        String input = "a1bcd         efg!h";
        String actual = anagram.reverseText(input);
        String expected = "d1cba         hgf!e";
        assertEquals(expected, actual);
    }

    @Test
    void reverseText_ShouldReturnOneLetter_WhenInputOneLetter() {
        String input = "h";
        String actual = anagram.reverseText(input);
        String expected = "h";
        assertEquals(expected, actual);
    }

    @Test
    void reverseText_ShouldReturnThOneLetterInUppercase_WhenOneLetterInUppercaseInput() {
        String input = "P";
        String actual = anagram.reverseText(input);
        String expected = "P";
        assertEquals(expected, actual);
    }

    @Test
    void reverseText_ShouldReturnTheStringWhithSameLetters_WhenInputStringWhithSomeLetters() {
        String input = "eeeeeee";
        String actual = anagram.reverseText(input);
        String expected = "eeeeeee";
        assertEquals(expected, actual);
    }

    @Test
    void reverseText_ShouldReturnTheStringWhithUppercaseAndLowercaseLetter_WhenInputStringWhithUppercaseAndLowercaseLetter() {
        String input = "eeeeEEeeEeE";
        String actual = anagram.reverseText(input);
        String expected = "EeEeeEEeeee";
        assertEquals(expected, actual);
    }

    @Test
    void reverseText_ShouldNotReverseAnySymbol_WhenInputOnlyNumericCharacters() {
        String input = "45 6 200";
        String actual = anagram.reverseText(input);
        String expected = "45 6 200";
        assertEquals(expected, actual);
    }

    @Test
    void reverseText_ShouldNoReverse_WhenInputStringWhithNonLetterSimbols() {
        String input = "?;{}...2@!! %$$$$$$";
        String actual = anagram.reverseText(input);
        String expected = "?;{}...2@!! %$$$$$$";
        assertEquals(expected, actual);
    }

    @Test
    void reverseText_Should_ReturnMoreWords_WhenMoreWordsInput() {
        String input = "aad2 wer 1wqe 46123we fsf5";
        String actual = anagram.reverseText(input);
        String expected = "daa2 rew 1eqw 46123ew fsf5";
        assertEquals(expected, actual);
    }
}
