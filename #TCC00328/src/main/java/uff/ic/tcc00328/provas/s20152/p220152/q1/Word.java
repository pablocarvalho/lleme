package uff.ic.tcc00328.provas.s20152.p220152.q1;

import java.util.HashSet;
import java.util.Set;

public class Word {

    /**
     * @attribute
     */
    public String lexicalForm;
    private Set<WordSense> wordSenses = new HashSet<WordSense>();

    public Word(String lexicalform) {
        this.lexicalForm = lexicalform;
    }

    public void addWordSense(WordSense wordSense) {
        wordSenses.add(wordSense);
    }

    public Set<WordSense> getWordSenses() {
        return wordSenses;
    }
}
