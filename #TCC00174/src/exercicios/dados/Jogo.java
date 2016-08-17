package exercicios.dados;

import java.util.ArrayList;
import java.util.List;

public class Jogo {

  private List<Partida> ganhadores;
  private List<Partida> perdedores;

  public Jogo() {
    this.perdedores = new ArrayList<>();
    this.ganhadores = new ArrayList<>();

  }

  public boolean decidir(Dado dado1, Dado dado2, Partida prtida) {

    return true;
  }
}
