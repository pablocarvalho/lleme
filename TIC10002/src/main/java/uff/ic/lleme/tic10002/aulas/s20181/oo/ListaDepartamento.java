package uff.ic.lleme.tic10002.aulas.s20181.oo;

public class ListaDepartamento {

    private Departamento[] deptos = new Departamento[100];
    private int tamanho = 0;

    public void incluir(Departamento depto) throws Exception {
        if (tamanho < 100) {
            for (int i = 0; i < tamanho; i++)
                if (deptos[i].sigla.equals(depto.sigla))
                    throw new Exception();
            deptos[tamanho] = depto;
            tamanho++;
        }
    }

    public Departamento buscar(String sigla) {
        for (int i = 0; i < tamanho; i++)
            if (deptos[i].sigla.equals(sigla))
                return deptos[i];
        return null;
    }
}
