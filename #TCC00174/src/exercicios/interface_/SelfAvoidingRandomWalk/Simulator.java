package exercicios.interface_.SelfAvoidingRandomWalk;

public class Simulator {

  private MainFrame mainFrame;

  Simulator(MainFrame mainFrame) {
    this.mainFrame = mainFrame;
  }

  ;

    public void run() {
    Grid grid = new Grid(30, 30);
    Dog dog = new Dog(15, 5);
    MainCanvas canvas = mainFrame.getMainCanvas();
    StatusBar statusBar = mainFrame.getStatusBar();

    canvas.addDrawbleObjects(grid);
    statusBar.setMessage("Searching");

    int timesEscaped = 0;

    for (int t = 0; t < 20; t++) {

      grid.resetMarked();

      dog.setPosX(15);
      dog.setPosY(15);

      int x = dog.getPosX();
      int y = dog.getPosY();

      boolean escaped = true;

      while (x > 0 && x < (grid.getWidth() - 1) && y > 0 && y < (grid.getHeight() - 1)) {

        grid.setMarked(x, y);
        canvas.repaint();

        if (grid.getMarked(x - 1, y) && grid.getMarked(x + 1, y)
                && grid.getMarked(x, y - 1) && grid.getMarked(x, y + 1)) {
          escaped = false;
          break;
        }

        Coordinate coord = dog.randomWalk(grid);
        x = coord.getX();
        y = coord.getY();

        try {
          Thread.sleep(1000);

        } catch (InterruptedException ie) {

          System.out.println(ie.getMessage());
        }

      }

      grid.setMarked(x, y);
      canvas.repaint();


      if (!escaped)
        statusBar.setMessage("Got lost");
      else
        timesEscaped++;

      try {
        Thread.sleep(200);

      } catch (InterruptedException ie) {

        System.out.println(ie.getMessage());
      }
      statusBar.setMessage("Searching   " + "Escaped " + timesEscaped + " times");


    }
  }
}
