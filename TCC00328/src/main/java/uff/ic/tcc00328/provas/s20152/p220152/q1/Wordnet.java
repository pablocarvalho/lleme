package uff.ic.tcc00328.provas.s20152.p220152.q1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Wordnet {

    private static final Map<String, Word> WORDS = new HashMap<>();
    private static final List<Synset> SYNSETS = new ArrayList<>();

    public static Synset createSense(String glossary) {
        Synset synset = new Synset(glossary);
        return synset;
    }

    public static void insertWord(String lexicalForm, Synset synset) {
        Word w = WORDS.get(lexicalForm);
        if (w == null) {
            w = new Word(lexicalForm);
            WORDS.put(lexicalForm, w);
        }
        synset.addWordSense(new WordSense(w));
    }

    public static List<String> listWordSenses(String lexicalForm) {
        List<String> result = new ArrayList<>();
        for (WordSense ws : WORDS.get(lexicalForm).getWordSenses())
            result.add(ws.synset.gloss);
        return result;
    }
}
