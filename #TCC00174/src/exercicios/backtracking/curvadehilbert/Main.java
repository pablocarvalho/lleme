package exercicios.backtracking.curvadehilbert;

public class Main {

  public static void main(String[] args) {

    MainFrame mainFrame = new MainFrame();
    int width = mainFrame.getCanvas().getWidth();
    int height = mainFrame.getCanvas().getHeight();
    CurvaDeHilbert curva = new CurvaDeHilbert(3, width, height);
    mainFrame.getCanvas().setCurva(curva);

  }
}
