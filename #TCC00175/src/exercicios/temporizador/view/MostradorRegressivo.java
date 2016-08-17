package exercicios.temporizador.view;

import java.awt.Graphics;
import java.text.DateFormat;

import exercicios.temporizador.model.Regressivo;

public class MostradorRegressivo extends Mostrador {

    private static final long serialVersionUID = 1L;

    public void paint(Graphics g) {
        super.paint(g);
        paintContorno(g);
        paintHoras(g);
        paintMinutos(g);
        paintPonteiroHora(g);
        paintPonteiroMinuto(g);
        paintPonteiroSegundo(g);
        DateFormat dateFormatter = DateFormat.getTimeInstance(DateFormat.MEDIUM);
        g.drawString(dateFormatter.format(getMyModelTemporizador().getTempo().getTime()), 10, 10);
    }

    public MostradorRegressivo(int tamanho) {
        super(tamanho);
        setTemporizador(new Regressivo());
        getTemporizador().attach(this);
    }

    public void accept(Visitor visitor) {
        // TODO Auto-generated method stub
    }
}
