package uff.ic.biblioteca.oldmodel;

import java.io.Serializable;

public class Exemplar extends BusinessObject {

    private class Key implements Serializable, Comparable {

        private static final long serialVersionUID = 5648905668712195801L;
        private Comparable material = null;
        private int numK = 0;

        public int compareTo(Object o) {
            Key key = (Key) o;
            Integer keyCodigo = new Integer(key.numK);
            Integer thisCodigo = new Integer(this.numK);
            if (this.material.compareTo(key.material) == 0) {
                return thisCodigo.compareTo(keyCodigo);
            }
            return this.material.compareTo(key.material);
        }
    }
    private static final long serialVersionUID = -5518061787568843296L;
    private Key key = null;

    public Exemplar() {
        super();
        this.key = new Key();
        setLnkrevMaterial(new Livro());
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
        this.key.numK = num;
    }
    private int num = 0;
    private Material lnkrevMaterial = null;
    private Emprestimo lnkEmprestimo = null;

    public Material getLnkrevMaterial() {
        return lnkrevMaterial;
    }

    public void setLnkrevMaterial(Material lnkrevMaterial) {
        this.lnkrevMaterial = lnkrevMaterial;
        this.key.material = lnkrevMaterial.getKey();
    }

    public Emprestimo getLnkEmprestimo() {
        return lnkEmprestimo;
    }

    public void setLnkEmprestimo(Emprestimo lnkEmprestimo) {
        this.lnkEmprestimo = lnkEmprestimo;
    }

    public Comparable getKey() {
        return key;
    }

    public void setKey(int num, Material material) {
        setNum(num);
        setLnkrevMaterial(material);
    }
}
