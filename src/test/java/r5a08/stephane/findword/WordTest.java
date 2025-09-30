package r5a08.stephane.findword;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordTest {


    @Test
    public void should_check_one_incorrect_letter() {
        // Arrange
        Word word = new Word("E"); // Le mot à deviner fait une lettre

        // Act
        Score actual = word.guess("B"); // tentative du joueur
        Word.Letter expected = Word.Letter.INCORRECT;
        // Assert
        // On s'attend à un score avec une lettre incorrecte pour cette tentative
        assertEquals(expected, actual.letter(0)); // Le score pour la 1ère lettre doit être INCORRECT
    }
    
    }



