package exercicios.listaarray;

public class PilhaAluno {

  private int tamanho = 10;
  private Aluno[] pilha = new Aluno[tamanho];
  private int pos=0;

  public void push(Aluno aluno) {
    if (pos>pilha.length)
      redimensiona();
    pilha[pos++]=aluno;
  }

  public Aluno pop() {
    Aluno aluno = null;
    aluno=pilha[--pos];
    pilha[pos]=null;
    return aluno;
  }

  private void redimensiona() {
    Aluno[] aux = new Aluno[pilha.length + tamanho];
    for (int i = 0; i < pilha.length; i++)
      aux[i] = pilha[i];
    pilha = aux;
  }
}
