package r5a08.findword;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordTest {
    @Test
    public void should_check_one_incorrect_letter(){
        // Arrange
        Word word = new Word("E"); // Le mot a déviner fait une lettre

        // Act
        Score score = word.guess("B");
        AssertWhenLetterIsIncorect(score);
    }

    private static void AssertWhenLetterIsIncorect(Score score) {
        AssertWhenLetterIsCorrect(score, Letter.INCORRECT);
    }

    @Test
    public void should_check_one_correct_letter(){
        // Arrange
        Word word = new Word("E");

        Score score = word.guess("E");// Le mot a déviner fait une lettre
        AssertWhenLetterIsCorrect(score, Letter.CORRECT);
    }

    private static void AssertWhenLetterIsCorrect(Score score, Letter correct) {
        Letter actual = score.letter(0);
        Letter expected = correct;
        // Act

        // Assert
        Assertions.assertEquals(actual, expected);
    }
    @Test
    public void twoLetters_firstCorrect() {
        Word word = new Word("EAAAAA");
        Score score = word.guess("EXDEAA");

        Letter expected = Letter.CORRECT;
        Letter actual   = score.letter(0);

        assertEquals(expected, actual);
    }

    @Test
    public void twoLetters_secondIncorrect() {
        Word word = new Word("EA");
        Score score = word.guess("EX");

        Letter expected = Letter.INCORRECT;
        Letter actual   = score.letter(1);

        assertEquals(expected, actual);
    }
    @Test
    public void twoLetters_swapped_firstIsPartCorrect() {
        Word word = new Word("EA");
        Score score = word.guess("AE");

        Letter expected = Letter.PART_CORRECT;
        Letter actual   = score.letter(0);

        assertEquals(expected, actual);
    }

    @Test
    public void twoLetters_swapped_secondIsPartCorrect() {
        Word word = new Word("EA");
        Score score = word.guess("AE");

        Letter expected = Letter.PART_CORRECT;
        Letter actual   = score.letter(1);

        assertEquals(expected, actual);
    }

    @Test
    public void any_letters_One_IsMisplaced() {
        Word word = new Word("BRIOCHE");
        Score score = word.guess("BONJOUR");



        Letter expected = Letter.PART_CORRECT;     // O présent mais pas au bon endroit
        Letter actual   = score.letter(1);
        assertEquals(expected, actual);
    }


}


