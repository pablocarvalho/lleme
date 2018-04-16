package uff.ic.lleme.tcc00328.provas.s20152.p220152.q1;

import java.util.ArrayList;
import java.util.List;

public class Synset {

    /**
     * @attribute
     */
    public String gloss = null;
    /**
     * @associates <{provas.s20152.p220152.WordSense}>
     */
    private List<WordSense> containsWordSense = new ArrayList<WordSense>();

    public Synset(String gloss) {
        this.gloss = gloss;
    }

    public void addWordSense(WordSense wordSense) {
        Word w = wordSense.word;
        if (w != null) {
            boolean hasFound = false;
            for (WordSense ws : containsWordSense)
                if (ws.word == w || ws.word.lexicalForm.equals(w.lexicalForm))
                    hasFound = true;
            if (!hasFound) {
                wordSense.synset = this;
                containsWordSense.add(wordSense);
            }
        }
    }
}
