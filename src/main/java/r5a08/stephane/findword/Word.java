package r5a08.stephane.findword;

public class Word {
    private String wordToGuess;  // Le mot à deviner

    // Constructeur
    public Word(String wordToGuess) {
        this.wordToGuess = wordToGuess;
    }

    // Méthode pour comparer une tentative avec le mot à deviner
    public Score guess(String attempt) {
        Score score = new Score();

        // Comparaison de la lettre (test spécifique pour une lettre incorrecte)
        if (wordToGuess.charAt(0) != attempt.charAt(0)) {
            score.addLetterScore(Word.Letter.INCORRECT); // Lettre incorrecte
        }

        return score;
    }

    public enum Letter {
        CORRECT, // lettre correcte
        PART_CORRECT, // lettre correcte mais mal placée
        INCORRECT // lettre incorrecte
    }
}
