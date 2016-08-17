package provas.s20102;

public class P220102Ex1 {

  public static void main(String[] args) throws Exception {
    float v1[] = {2, 3};
    float v2[] = {4, 5};
    System.out.println(produtoInterno(v1, v2));
  }

  public static float produtoInterno(float[] v1, float[] v2) throws Exception {
    float prod = 0;
    if (v1.length == v2.length)
      for (int i = 0; i < v1.length; i++)
        prod = prod + v1[i] * v2[i];
    else
      throw new Exception("Dimensões diferentes");
    return prod;
  }
}
