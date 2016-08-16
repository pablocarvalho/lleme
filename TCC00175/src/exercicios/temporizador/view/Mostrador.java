package exercicios.temporizador.view;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.Calendar;

import javax.swing.JPanel;

import exercicios.temporizador.model.Temporizador;

public abstract class Mostrador extends JPanel implements Observer, Element {

    private Temporizador mySubjectTemporizador = null;
    private Point2D origemHoras = null;
    private Point2D origemCentesimos = null;
    private double r1 = 0.0;
    private double r2 = 0.0;
    private double hora = 0.0;
    private double minuto = 0.0;
    private double segundo = 0.0;
    private double centesimo = 0.0;

    public Mostrador(int tamanho) {
        setOpaque(true);
        setPreferredSize(new Dimension(tamanho, tamanho));
        final double fat = 4.0, partes = 12.0;
        double deltaR = 0.0;
        r1 = tamanho / 2.0 * 10.0 / partes;
        r2 = tamanho / 2.0 * 3.0 / partes;
        deltaR = tamanho / 2.0 / partes;
        origemHoras = new Point2D.Double(tamanho / 2.0, tamanho / 2.0);
        origemCentesimos = new Point2D.Double(origemHoras.getX(), origemHoras.getY()
                + fat * deltaR);
    }

    public Temporizador getTemporizador() {
        return mySubjectTemporizador;
    }

    public void setTemporizador(Temporizador temporizador) {
        this.mySubjectTemporizador = temporizador;
    }

    public void paint(Graphics g) {
        super.paint(g);
    }

    protected void paintContorno(Graphics g) {
        final BasicStroke stroke = new BasicStroke(2.0f);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(stroke);
        g2.draw(new Ellipse2D.Double(origemHoras.getX() - r1, origemHoras.getY()
                - r1, 2.0 * r1, 2.0 * r1));
    }

    protected void paintHoras(Graphics g) {
        final double deltaAng = 2.0 * Math.PI / 12.0;
        final double maxAng = 2.0 * Math.PI;
        final BasicStroke stroke = new BasicStroke(2.0f);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(stroke);
        for (double ang = 0.0; ang <= maxAng; ang += deltaAng)
            g2.draw(new Line2D.Double(xy(origemHoras, r1 - 15, ang), xy(
                    origemHoras, r1, ang)));
    }

    protected void paintMinutos(Graphics g) {
        final double deltaAng = 2.0 * Math.PI / 60.0;
        final double maxAng = 2.0 * Math.PI;
        final BasicStroke stroke = new BasicStroke(2.0f);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(stroke);
        for (double ang = 0.0; ang <= maxAng; ang += deltaAng)
            g2.draw(new Line2D.Double(xy(origemHoras, r1 - 5, ang), xy(
                    origemHoras, r1, ang)));
    }

    protected void paintSegundos(Graphics g) {
        final double deltaAng = 2.0 * Math.PI / 60.0;
        final double maxAng = 2.0 * Math.PI;
        final BasicStroke stroke = new BasicStroke(2.0f);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(stroke);
        for (double ang = 0.0; ang <= maxAng; ang += deltaAng)
            g2.draw(new Line2D.Double(xy(origemHoras, r1 - 5, ang), xy(
                    origemHoras, r1, ang)));
    }

    protected void paintCentesimos(Graphics g) {
        final double deltaAng = 2.0 * Math.PI / 20.0;
        final double maxAng = 2.0 * Math.PI;
        final BasicStroke stroke = new BasicStroke(2.0f);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(stroke);
        for (double ang = 0.0; ang <= maxAng; ang += deltaAng)
            g2.draw(new Line2D.Double(xy(origemCentesimos, r2 - 5, ang), xy(
                    origemCentesimos, r2, ang)));
    }

    protected void paintPonteiroHora(Graphics g) {
        double ang = 0.0;
        final BasicStroke stroke = new BasicStroke(3.0f);
        // Point2D x0y0 = new Point2D.Double(250.0 / 2.0, 250.0 / 2.0);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(stroke);
        ang = Math.PI / 2.0 - (Math.PI / 6.0 * hora);
        g2.draw(new Line2D.Double(xy(origemHoras, 0, 0), xy(origemHoras,
                r1 - 35, ang)));
    }

    protected void paintPonteiroMinuto(Graphics g) {
        double ang = 0.0;
        final BasicStroke stroke = new BasicStroke(3.0f);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(stroke);
        ang = Math.PI / 2.0 - (Math.PI / 2.0 / 15.0 * minuto);
        g2.draw(new Line2D.Double(xy(origemHoras, 0, 0), xy(origemHoras,
                r1 - 20, ang)));
    }

    protected void paintPonteiroSegundo(Graphics g) {
        double ang = 0.0;
        final BasicStroke stroke = new BasicStroke(1.0f);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(stroke);
        ang = Math.PI / 2.0 - (Math.PI / 2.0 / 15.0 * segundo);
        g2.draw(new Line2D.Double(xy(origemHoras, 0, 0), xy(origemHoras,
                r1 - 20, ang)));
    }

    protected void paintPonteiroCentesimo(Graphics g) {
        double ang = 0.0;
        final BasicStroke stroke = new BasicStroke(1.0f);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(stroke);
        ang = Math.PI / 2.0 - (Math.PI / 2.0 / 25.0 * centesimo);
        g2.draw(new Line2D.Double(xy(origemCentesimos, 0, 0), xy(
                origemCentesimos, r2 - 5, ang)));
    }

    private Point2D xy(Point2D x0y0, double raio, double angulo) {
        return new Point2D.Double(x0y0.getX() + raio * Math.cos(angulo), x0y0.getY()
                - raio * Math.sin(angulo));
    }

    public Temporizador getMyModelTemporizador() {
        return mySubjectTemporizador;
    }

    public void setMyModelTemporizador(Temporizador myModelTemporizador) {
        this.mySubjectTemporizador = myModelTemporizador;
    }

    public void update() {
        Calendar cal = mySubjectTemporizador.getTempo();
        setHora(cal.get(Calendar.HOUR));
        setMinuto(cal.get(Calendar.MINUTE));
        setSegundo(cal.get(Calendar.SECOND));
        setCentesimo(cal.get(Calendar.MILLISECOND) / 10);
        repaint();
    }

    /**
     * @return Returns the centesimo.
     */
    public double getCentesimo() {
        return centesimo;
    }

    /**
     * @param centesimo The centesimo to set.
     */
    public void setCentesimo(double centesimo) {
        this.centesimo = centesimo;
    }

    /**
     * @return Returns the hora.
     */
    public double getHora() {
        return hora;
    }

    /**
     * @param hora The hora to set.
     */
    public void setHora(double hora) {
        this.hora = hora;
    }

    /**
     * @return Returns the minuto.
     */
    public double getMinuto() {
        return minuto;
    }

    /**
     * @param minuto The minuto to set.
     */
    public void setMinuto(double minuto) {
        this.minuto = minuto;
    }

    /**
     * @return Returns the segundo.
     */
    public double getSegundo() {
        return segundo;
    }

    /**
     * @param segundo The segundo to set.
     */
    public void setSegundo(double segundo) {
        this.segundo = segundo;
    }

    /**
     * @return Returns the origemCentesimos.
     */
    public Point2D getOrigemCentesimos() {
        return origemCentesimos;
    }

    /**
     * @param origemCentesimos The origemCentesimos to set.
     */
    public void setOrigemCentesimos(Point2D origemCentesimos) {
        this.origemCentesimos = origemCentesimos;
    }

    /**
     * @return Returns the origemHoras.
     */
    public Point2D getOrigemHoras() {
        return origemHoras;
    }

    /**
     * @param origemHoras The origemHoras to set.
     */
    public void setOrigemHoras(Point2D origemHoras) {
        this.origemHoras = origemHoras;
    }

    /**
     * @return Returns the r1.
     */
    public double getR1() {
        return r1;
    }

    /**
     * @param r1 The r1 to set.
     */
    public void setR1(double r1) {
        this.r1 = r1;
    }

    /**
     * @return Returns the r2.
     */
    public double getR2() {
        return r2;
    }

    /**
     * @param r2 The r2 to set.
     */
    public void setR2(double r2) {
        this.r2 = r2;
    }
}
