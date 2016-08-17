package exercicios.temporizador.view;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public abstract class Funcao extends JPanel {

    private String nomeFuncao;
    private Mostrador mostrador = null;
    private Botoeira botoeira = null;

    public Funcao(String nome) {
        this.nomeFuncao = nome;
        iniComponents();
    }

    private void iniComponents() {
        Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        TitledBorder title = BorderFactory.createTitledBorder(loweredetched,
                nomeFuncao);
        title.setTitleJustification(TitledBorder.CENTER);
        setBorder(title);
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }

    public String getNomeFuncao() {
        return nomeFuncao;
    }

    public void setNomeFuncao(String nomeFuncao) {
        this.nomeFuncao = nomeFuncao;
    }

    public Mostrador getMostrador() {
        return mostrador;
    }

    public void setMostrador(Mostrador mostrador) {
        this.mostrador = mostrador;
    }

    public Botoeira getBotoeira() {
        return botoeira;
    }

    public void setBotoeira(Botoeira botoeira) {
        this.botoeira = botoeira;
    }
}
