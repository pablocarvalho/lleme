
public class Pilha {

  private Elemento[] lista = new Elemento[10];

  public Gerente busca(String chave) {
    for (int i = 0; i < lista.length; i++)
      if (lista[i].chave.equals(chave))
        return lista[i].ger;
    return null;
  }
}
