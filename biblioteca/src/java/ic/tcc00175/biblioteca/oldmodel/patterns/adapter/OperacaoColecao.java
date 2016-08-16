package ic.tcc00175.biblioteca.oldmodel.patterns.adapter;

import ic.tcc00175.biblioteca.oldmodel.Operacao;
import ic.tcc00175.biblioteca.oldmodel.Usuario;

public class OperacaoColecao extends BusinessObjectCollection {

    private static final long serialVersionUID = -1733596410907581491L;
    private ReservaColecao treeMap1 = null;
    private EmprestimoColecao treeMap2 = null;

    public OperacaoColecao(Usuario usuario) {
        if (usuario != null) {
            treeMap1 = usuario.getLnkReserva();
            treeMap2 = usuario.getLnkEmprestimo();
        } else {
            treeMap1 = new ReservaColecao();
            treeMap2 = new EmprestimoColecao();
        }
    }

    public Operacao get(int index) {
        if (index < treeMap1.size()) {
            return (Operacao) this.treeMap1.values().toArray()[index];
        } else if (index < treeMap1.size() + treeMap2.size()) {
            return (Operacao) this.treeMap2.values().toArray()[index
                    - treeMap1.size()];
        }
        return null;
    }

    public int size() {
        return this.treeMap1.size() + this.treeMap2.size();
    }

    public void setCollection(Usuario usuario) {
        this.treeMap1 = usuario.getLnkReserva();
        this.treeMap2 = usuario.getLnkEmprestimo();
    }
}
