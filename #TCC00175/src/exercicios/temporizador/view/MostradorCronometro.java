package exercicios.temporizador.view;

import java.awt.Graphics;
import java.text.DateFormat;
import java.util.Calendar;

import exercicios.temporizador.model.Cronometro;

public class MostradorCronometro extends Mostrador {

    private static final long serialVersionUID = 1L;

    public void paint(Graphics g) {
        super.paint(g);
        paintContorno(g);
        paintHoras(g);
        paintMinutos(g);
        paintCentesimos(g);
        paintPonteiroHora(g);
        paintPonteiroMinuto(g);
        paintPonteiroSegundo(g);
        paintPonteiroCentesimo(g);
        DateFormat dateFormatter = DateFormat.getTimeInstance(DateFormat.MEDIUM);
        g.drawString(dateFormatter.format(getMyModelTemporizador().getTempo().getTime())
                + "."
                + getMyModelTemporizador().getTempo().get(Calendar.MILLISECOND)
                / 10, 10, 10);
    }

    public MostradorCronometro(int tamanho) {
        super(tamanho);
        setTemporizador(new Cronometro());
        getTemporizador().attach(this);
    }

    public void accept(Visitor visitor) {
        // TODO Auto-generated method stub
    }
}
