package exercicios.temporizador.view;

import java.awt.Graphics;
import java.text.DateFormat;

import exercicios.temporizador.model.Relogio;

public class MostradorRelogio extends Mostrador {

    private static final long serialVersionUID = 1L;

    public void paint(Graphics g) {
        super.paint(g);
        paintContorno(g);
        paintHoras(g);
        paintMinutos(g);
        paintPonteiroHora(g);
        paintPonteiroMinuto(g);
        paintPonteiroSegundo(g);
        DateFormat dateFormatter = DateFormat.getDateTimeInstance();
        g.drawString(dateFormatter.format(getMyModelTemporizador().getTempo().getTime()), 10, 10);
    }

    public MostradorRelogio(int tamanho) {
        super(tamanho);
        setTemporizador(new Relogio());
        getTemporizador().attach(this);
    }

    public void accept(Visitor visitor) {
        // TODO Auto-generated method stub
    }
}
