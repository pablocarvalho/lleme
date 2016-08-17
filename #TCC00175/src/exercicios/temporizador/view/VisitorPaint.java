package exercicios.temporizador.view;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.text.DateFormat;
import java.util.Calendar;

public class VisitorPaint implements Visitor {

    public void VisitMostradorCronometro(MostradorCronometro mostrador) {
        paintContorno(mostrador);
        paintHoras(mostrador);
        paintMinutos(mostrador);
        paintCentesimos(mostrador);
        paintPonteiroHora(mostrador);
        paintPonteiroMinuto(mostrador);
        paintPonteiroSegundo(mostrador);
        paintPonteiroCentesimo(mostrador);
        DateFormat dateFormatter = DateFormat.getTimeInstance(DateFormat.MEDIUM);
        mostrador.getGraphics().drawString(
                dateFormatter.format(mostrador.getMyModelTemporizador().getTempo().getTime())
                + "."
                + mostrador.getMyModelTemporizador().getTempo().get(
                        Calendar.MILLISECOND) / 10, 10, 10);

    }

    public void VisitMostradorRegressivo(MostradorRegressivo mostrador) {
        paintContorno(mostrador);
        paintHoras(mostrador);
        paintMinutos(mostrador);
        paintPonteiroHora(mostrador);
        paintPonteiroMinuto(mostrador);
        paintPonteiroSegundo(mostrador);
        DateFormat dateFormatter = DateFormat.getTimeInstance(DateFormat.MEDIUM);
        mostrador.getGraphics().drawString(
                dateFormatter.format(mostrador.getMyModelTemporizador().getTempo().getTime()), 10, 10);

    }

    public void VisitMostradorRelogio(MostradorRelogio mostrador) {
        paintContorno(mostrador);
        paintHoras(mostrador);
        paintMinutos(mostrador);
        paintPonteiroHora(mostrador);
        paintPonteiroMinuto(mostrador);
        paintPonteiroSegundo(mostrador);
        DateFormat dateFormatter = DateFormat.getDateTimeInstance();
        mostrador.getGraphics().drawString(
                dateFormatter.format(mostrador.getMyModelTemporizador().getTempo().getTime()), 10, 10);

    }

    protected void paintContorno(Mostrador mostrador) {
        final BasicStroke stroke = new BasicStroke(2.0f);
        Graphics2D g2 = (Graphics2D) mostrador.getGraphics();
        g2.setStroke(stroke);
        g2.draw(new Ellipse2D.Double(mostrador.getOrigemHoras().getX()
                - mostrador.getR1(), mostrador.getOrigemHoras().getY()
                - mostrador.getR1(), 2.0 * mostrador.getR1(), 2.0 * mostrador.getR1()));
    }

    protected void paintHoras(Mostrador mostrador) {
        final double deltaAng = 2.0 * Math.PI / 12.0;
        final double maxAng = 2.0 * Math.PI;
        final BasicStroke stroke = new BasicStroke(2.0f);
        Graphics2D g2 = (Graphics2D) mostrador.getGraphics();
        g2.setStroke(stroke);
        for (double ang = 0.0; ang <= maxAng; ang += deltaAng)
            g2.draw(new Line2D.Double(xy(mostrador.getOrigemHoras(), mostrador.getR1() - 15, ang), xy(mostrador.getOrigemHoras(),
                    mostrador.getR1(), ang)));
    }

    protected void paintMinutos(Mostrador mostrador) {
        final double deltaAng = 2.0 * Math.PI / 60.0;
        final double maxAng = 2.0 * Math.PI;
        final BasicStroke stroke = new BasicStroke(2.0f);
        Graphics2D g2 = (Graphics2D) mostrador.getGraphics();
        g2.setStroke(stroke);
        for (double ang = 0.0; ang <= maxAng; ang += deltaAng)
            g2.draw(new Line2D.Double(xy(mostrador.getOrigemHoras(), mostrador.getR1() - 5, ang), xy(mostrador.getOrigemHoras(),
                    mostrador.getR1(), ang)));
    }

    protected void paintSegundos(Mostrador mostrador) {
        final double deltaAng = 2.0 * Math.PI / 60.0;
        final double maxAng = 2.0 * Math.PI;
        final BasicStroke stroke = new BasicStroke(2.0f);
        Graphics2D g2 = (Graphics2D) mostrador.getGraphics();
        g2.setStroke(stroke);
        for (double ang = 0.0; ang <= maxAng; ang += deltaAng)
            g2.draw(new Line2D.Double(xy(mostrador.getOrigemHoras(), mostrador.getR1() - 5, ang), xy(mostrador.getOrigemHoras(),
                    mostrador.getR1(), ang)));
    }

    protected void paintCentesimos(Mostrador mostrador) {
        final double deltaAng = 2.0 * Math.PI / 20.0;
        final double maxAng = 2.0 * Math.PI;
        final BasicStroke stroke = new BasicStroke(2.0f);
        Graphics2D g2 = (Graphics2D) mostrador.getGraphics();
        g2.setStroke(stroke);
        for (double ang = 0.0; ang <= maxAng; ang += deltaAng)
            g2.draw(new Line2D.Double(xy(mostrador.getOrigemCentesimos(),
                    mostrador.getR2() - 5, ang), xy(mostrador.getOrigemCentesimos(), mostrador.getR2(), ang)));
    }

    protected void paintPonteiroHora(Mostrador mostrador) {
        double ang = 0.0;
        final BasicStroke stroke = new BasicStroke(3.0f);
        // Point2D x0y0 = new Point2D.Double(250.0 / 2.0, 250.0 / 2.0);
        Graphics2D g2 = (Graphics2D) mostrador.getGraphics();
        g2.setStroke(stroke);
        ang = Math.PI / 2.0 - (Math.PI / 6.0 * mostrador.getHora());
        g2.draw(new Line2D.Double(xy(mostrador.getOrigemHoras(), 0, 0), xy(
                mostrador.getOrigemHoras(), mostrador.getR1() - 35, ang)));
    }

    protected void paintPonteiroMinuto(Mostrador mostrador) {
        double ang = 0.0;
        final BasicStroke stroke = new BasicStroke(3.0f);
        Graphics2D g2 = (Graphics2D) mostrador.getGraphics();
        g2.setStroke(stroke);
        ang = Math.PI / 2.0 - (Math.PI / 2.0 / 15.0 * mostrador.getMinuto());
        g2.draw(new Line2D.Double(xy(mostrador.getOrigemHoras(), 0, 0), xy(
                mostrador.getOrigemHoras(), mostrador.getR1() - 20, ang)));
    }

    protected void paintPonteiroSegundo(Mostrador mostrador) {
        double ang = 0.0;
        final BasicStroke stroke = new BasicStroke(1.0f);
        Graphics2D g2 = (Graphics2D) mostrador.getGraphics();
        g2.setStroke(stroke);
        ang = Math.PI / 2.0 - (Math.PI / 2.0 / 15.0 * mostrador.getSegundo());
        g2.draw(new Line2D.Double(xy(mostrador.getOrigemHoras(), 0, 0), xy(
                mostrador.getOrigemHoras(), mostrador.getR1() - 20, ang)));
    }

    protected void paintPonteiroCentesimo(Mostrador mostrador) {
        double ang = 0.0;
        final BasicStroke stroke = new BasicStroke(1.0f);
        Graphics2D g2 = (Graphics2D) mostrador.getGraphics();
        g2.setStroke(stroke);
        ang = Math.PI / 2.0 - (Math.PI / 2.0 / 25.0 * mostrador.getCentesimo());
        g2.draw(new Line2D.Double(xy(mostrador.getOrigemCentesimos(), 0,
                0), xy(mostrador.getOrigemCentesimos(), mostrador.getR2() - 5, ang)));
    }

    private Point2D xy(Point2D x0y0, double raio, double angulo) {
        return new Point2D.Double(x0y0.getX() + raio * Math.cos(angulo), x0y0.getY()
                - raio * Math.sin(angulo));
    }

    public void VisitBotaoStartStop(BotaoStartStop botao) {
        // TODO Auto-generated method stub
    }

    public void VisitBotaoReset(BotaoReset botao) {
        // TODO Auto-generated method stub
    }
}
