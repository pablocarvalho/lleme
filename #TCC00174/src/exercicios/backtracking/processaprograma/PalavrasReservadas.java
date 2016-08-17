/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicios.backtracking.processaprograma;

/**
 *
 * @author ananmon
 */
public class PalavrasReservadas {

  private static final String[] palReservadas = {"abstract",
    "assert",
    "boolean",
    "break",
    "byte",
    "case",
    "catch",
    "char",
    "class",
    "const",
    "continue",
    "default",
    "do",
    "double",
    "else",
    "enum",
    "extends",
    "final",
    "finally",
    "float",
    "for",
    "goto",
    "if",
    "implements",
    "import",
    "instanceof",
    "int",
    "interface",
    "long",
    "native",
    "new",
    "package",
    "private",
    "protected",
    "public",
    "return",
    "short",
    "static",
    "strictfp",
    "super",
    "switch",
    "synchronized",
    "this",
    "throw",
    "throws",
    "transient",
    "try",
    "void",
    "volatile",
    "while",};

  public static boolean ehReservada(String palavra) {
    boolean achou = false;
    for (int i = 0; i < palReservadas.length && !achou; i++)
      if (palavra.compareTo(palReservadas[i]) == 0)
        achou = true;
    return achou;

  }
}
