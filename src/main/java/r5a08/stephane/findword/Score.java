package r5a08.stephane.findword;

import java.util.ArrayList;
import java.util.List;

public class Score {
    private List<Word.Letter> letterScores;


    public Score() {
        this.letterScores = new ArrayList<>();
    }

    public void addLetterScore(Word.Letter letter) {
        letterScores.add(letter);
    }

    public Word.Letter letter(int i) {
        return letterScores.get(i);
    }

    public int size() {
        return letterScores.size();
    }
}

