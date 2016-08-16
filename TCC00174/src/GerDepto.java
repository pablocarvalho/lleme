
/**
 *
 * @author Luiz Leme
 */
public class GerDepto {

  public static void main(String[] args) {
    Gerente ger1 = new Gerente();
    ger1.nome = "Gerente";

    Departamento depto1 = new Departamento();
    depto1.nome = "Depto1";

    ger1.chefeDe[0] = depto1;
    depto1.chefe = ger1;


    System.out.println(ger1.chefeDe[0].nome);
    System.out.println(depto1.chefe.nome);
  }
}
