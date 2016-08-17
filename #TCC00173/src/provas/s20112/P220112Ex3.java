package provas.s20112;

public class P220112Ex3 {

  public static void main(String[] args) {
    permutar("abc", 0);
  }

  public static void permutar(String texto, int pos) {
    if (pos < texto.length())
      for (int i = pos; i < texto.length(); i++) {
        texto = trocaCaractere(texto, pos, i);
        permutar(texto, pos + 1);
      }
    else
      System.out.println(texto);
  }

  public static String trocaCaractere(String texto, int i, int j) {
    char caractereSalvo;
    char[] caracteres;
    caracteres = texto.toCharArray();
    caractereSalvo = caracteres[i];
    caracteres[i] = caracteres[j];
    caracteres[j] = caractereSalvo;
    return String.copyValueOf(caracteres);
  }
}
