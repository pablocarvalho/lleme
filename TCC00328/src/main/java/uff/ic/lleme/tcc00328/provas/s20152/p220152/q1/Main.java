package uff.ic.lleme.tcc00328.provas.s20152.p220152.q1;

public class Main {

    public static void main(String[] args) {
        Synset synset1 = new Synset("synset1");
        Wordnet.insertWord("dsdfg", synset1);
        Synset synset2 = new Synset("synset2");
        Wordnet.insertWord("dsdfg", synset2);
        for (String s : Wordnet.listWordSenses("dsdfg"))
            System.out.println(s);
    }
}
