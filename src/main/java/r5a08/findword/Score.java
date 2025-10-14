package r5a08.findword;

public class Score {
    private final String correct;
    private final Letter[] results;

    public Score(String correct) {
        this.correct = correct;
        this.results = new Letter[correct.length()];
        for (int i = 0; i < results.length; i++) results[i] = Letter.INCORRECT;
    }

    public Letter letter(int i) {
        return results[i];
    }

    // Évalue: CORRECT, sinon PART_CORRECT si la lettre existe ailleurs (gestion doublons)
    public void assess(String attempt) {
        int n = correct.length();
        if (attempt.length() != n) {
            throw new IllegalArgumentException("Le mot doit être de longueur " + n);
        }

        // Phase 1 : marquer les CORRECT et compter les lettres restantes de la solution
        int[] freq = new int[Character.MAX_VALUE + 1]; // compteur des lettres non encore utilisées
        for (int i = 0; i < n; i++) {
            char cCorr = correct.charAt(i);
            char cAtt  = attempt.charAt(i);
            if (cCorr == cAtt) {
                results[i] = Letter.CORRECT;
            } else {
                // on ne consomme pas encore, on compte pour PART_CORRECT
                freq[cCorr]++;
            }
        }

        // Phase 2 : pour les positions non CORRECT, décider PART_CORRECT si dispo dans freq
        for (int i = 0; i < n; i++) {
            if (results[i] == Letter.CORRECT) continue;
            char cAtt = attempt.charAt(i);
            if (freq[cAtt] > 0) {
                results[i] = Letter.PART_CORRECT;
                freq[cAtt]--; // on consomme une occurrence
            } else {
                results[i] = Letter.INCORRECT;
            }
        }
    }
}
