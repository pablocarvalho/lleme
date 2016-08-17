
public class MainGerente {

  public static void main(String[] args) {
    Gerente ger = new Gerente();
    Gerente[][] lger = new Gerente[5][];

    Gerente[] linha = new Gerente[10];
    linha[0] = ger;

    lger[0] = linha;

    for (int i = 0; i < lger.length; i++)
      for (int j = 0; j < lger[i].length; j++)
        System.out.println(lger[i][j].nome);


  }
}
