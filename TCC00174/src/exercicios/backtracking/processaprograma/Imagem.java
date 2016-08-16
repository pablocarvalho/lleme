package exercicios.backtracking.processaprograma;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author anselmomontenegro
 */
public class Imagem {

  private StringBuffer simb;
  private int numId;
  private int numNumbers;
  //private boolean comentario;

  Imagem(int tamanho) {
    simb = new StringBuffer(tamanho);
    //comentario = false;
    for (int i = 0; i < simb.capacity(); i++)
      simb.append(' ');

  }

  public StringBuffer getSimb() {
    return simb;
  }

  public void setNumId(int numId) {
    this.numId = numId;
  }

  public int getNumId() {
    return numId;
  }

  public void setNumNumbers(int numNumbers) {
    this.numNumbers = numNumbers;
  }

  public int getNumNumbers() {
    return this.numNumbers;
  }

  /*public boolean ehComentario(){
   return comentario;
   }

   public void setComentario(boolean valor){
   this.comentario = valor;
   }*/
  public void print() {
    System.out.println(simb);
    //System.out.println("Id: "+getNumId()+" Num: "+getNumNumbers());
  }
}
