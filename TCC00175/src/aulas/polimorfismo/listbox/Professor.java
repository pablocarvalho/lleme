package aulas.polimorfismo.listbox;

public class Professor implements Nomeavel {

    private String primeiroNome;
    private String segundoNome;

    public Professor(String primeiroNome, String segundoNome) {
        this.primeiroNome = primeiroNome;
        this.segundoNome = segundoNome;
    }

    @Override
    public String getNome() {
        return primeiroNome.trim() + " " + segundoNome.trim();
    }
}
