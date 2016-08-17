package exemplos.listas;

public class Main {

  public static void main(String[] args) {
    ListaPrincipio<Dado> lista = new ListaPrincipio();
    ListaFim<Dado> listaDest1 = new ListaFim<>();
    ListaPrincipio<Dado> listaDest2 = new ListaPrincipio<>();
    ListaFim<Dado> listaDest3 = new ListaFim<>();

    int cont=0;
    lista.reset();
    
    Dado dado = lista.proximo();
    Dado l1 = dado;
    listaDest2.inserir(l1);
    listaDest3.inserir2(dado);
    cont++;
    
    dado = lista.proximo();
    while (dado != null){
      listaDest1.inserir(dado);
      listaDest2.inserir(dado);
      if (cont<=listaDest3.getTamanho())
        listaDest3.inserir(dado);
      else
        listaDest3.inserir2(dado);
      dado = lista.proximo();
      cont++;
    }
    listaDest1.inserir(l1);
  }
}
