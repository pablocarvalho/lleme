package exercicios.listaarray;

public class Fila<E> {

  private int tamanho = 10;
  private Object[] fila;
  private int pos = 0;

  public Fila() {
    this.fila = new Object[10];
  }

  public void queue(E aluno) {
    if (pos > fila.length)
      redimensiona();
    fila[pos++] = aluno;
  }

  public E dequeue() {
    E aluno = null;
    aluno = (E) fila[0];
    pos--;
    fila[0] = null;
    deslocar();
    return aluno;
  }

  private void redimensiona() {
    Object[] aux = new Object[fila.length + tamanho];
    for (int i = 0; i < fila.length; i++)
      aux[i] = fila[i];
    fila = aux;
  }

  private void deslocar() {
    for (int i = 1; i < pos + 1; i++)
      fila[i - 1] = fila[i];
    fila[pos] = null;
  }
}
