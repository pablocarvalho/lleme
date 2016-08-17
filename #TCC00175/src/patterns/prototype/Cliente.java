package patterns.prototype;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    public List<Prototipo> prototipos = new ArrayList<Prototipo>();

    public static void main(String[] args) throws CloneNotSupportedException {

        Prototipo.tipoClonagem = 3;
        Cliente cliente = new Cliente();
        cliente.prototipos.add(new Aluno());

        Prototipo objeto1 = cliente.prototipos.get(0).clone();
        Prototipo objeto2 = cliente.prototipos.get(0).clone();

        objeto1.setNome("Luiz André");
        objeto1.getColecao().add(objeto1.getNome());

        objeto2.setNome("outro nome");
        objeto2.getColecao().clear();
        objeto2.getColecao().add(objeto2.getNome());
    }
}
