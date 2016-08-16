package exercicios.listaarray;

public class ListaAluno {

  private Aluno[] lista;
  private int tamanho = 0;
  private int pos = 0;

  public ListaAluno(int tamanho) {
    lista = new Aluno[tamanho];
    this.tamanho = tamanho;
  }

  private void redimensiona() {
    Aluno[] aux = new Aluno[lista.length + tamanho];
    for (int i = 0; i < lista.length; i++)
      aux[i] = lista[i];
    lista = aux;
  }

  public void inserir(Aluno aluno) {
    boolean inseriu = false;
    inseriu = inserir2(aluno);
    if (!inseriu) {
      redimensiona();
      inserir2(aluno);
    }
  }

  private boolean inserir2(Aluno aluno) {
    boolean inseriu = false;
    for (int i = 0; i < lista.length; i++)
      if (lista[i] == null) {
        lista[i] = aluno;
        inseriu = true;
        break;
      }
    return inseriu;
  }

  public void remover(Aluno aluno) {
    boolean achou = false;
    for (int i = 0; i < lista.length && !achou; i++)
      if (lista[i] == aluno) {
        lista[i] = null;
        achou = true;
      }
  }

  public Aluno remover(String nome) {
    Aluno aluno = null;
    for (int i = 0; i < lista.length; i++)
      if (lista[i] != null && lista[i].nome.equals(nome)) {
        aluno = lista[i];
        lista[i] = null;
        break;
      }
    return aluno;
  }
  
  public Aluno busca (String nome){
    Aluno aluno = null;
    for (int i = 0; i < lista.length; i++)
      if (lista[i] != null && lista[i].nome.equals(nome)) {
        aluno = lista[i];
        break;
      }
    return aluno;
  }
}
