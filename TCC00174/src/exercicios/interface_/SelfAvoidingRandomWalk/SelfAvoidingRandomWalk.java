package exercicios.interface_.SelfAvoidingRandomWalk;

public class SelfAvoidingRandomWalk {

  MainFrame mainFrame;
  Simulator simulator;

  public SelfAvoidingRandomWalk() {
    mainFrame = new MainFrame();
    simulator = new Simulator(mainFrame);
  }

  public static void main(String[] args) {

    SelfAvoidingRandomWalk selfAvoidingRandomWalk =
            new SelfAvoidingRandomWalk();
    selfAvoidingRandomWalk.simulator.run();
  }
}
