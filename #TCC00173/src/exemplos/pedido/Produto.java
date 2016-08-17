package exemplos.pedido;

public class Produto {

  public int codigo;
  public float preco;

  public static Produto buscaProduto(int codigo, Produto[] produtos) {
    for (int i = 0; i < produtos.length; i++)
      if (produtos[i] != null && codigo == produtos[i].codigo)
        return produtos[i];
    return null;
  }
}
