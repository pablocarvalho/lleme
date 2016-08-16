package exercicios.arquivos.forma;

public class Retangulo extends Forma{

  private float lado;
  private float altura;

  public Retangulo(float lado, float altura) {
    this.lado = lado;
    this.altura = altura;
  }

  public float getLado() {
    return lado;
  }

  public void setLado(float lado) {
    this.lado = lado;
  }

  public float getAltura() {
    return altura;
  }

  public void setAltura(float altura) {
    this.altura = altura;
  }
}
