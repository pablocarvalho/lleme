package exemplos;

import java.security.InvalidParameterException;
import java.util.Scanner;
import org.omg.CORBA.UserException;

public class Fatorial {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int nm = scanner.nextInt();
    try {
      fatorial(nm);
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
  }

  public static int fatorial(int n) throws Exception {
    if (n > 0)
      return n * fatorial(n - 1);
    else if (n == 0)
      return 1;
    else
      throw new Exception("A funcao fatorial não é "
              + "definida para números negativos");
  }
}
