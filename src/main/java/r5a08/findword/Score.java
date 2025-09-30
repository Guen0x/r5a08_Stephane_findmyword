package r5a08.findword;

import java.util.ArrayList;
import java.util.List;

public class Score {
    private List<Letter> letterScores;


    public Score() {
        this.letterScores = new ArrayList<>();
    }

    public void addLetterScore(Letter letter) {
        letterScores.add(letter);
    }

    public Letter letter(int i) {
        return letterScores.get(i);
    }

    public int size() {
        return letterScores.size();
    }
}

