/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecao;

import util.TemChave;

/**
 *
 * @author wagnerluizoliveiradossantos
 * @param <Entidade>
 */
public class ArvoreAVLComLista<K extends Comparable, Entidade extends TemChave> {

    class NoLista<K extends Comparable, Entidade extends TemChave> {

        protected K chave = null;
        protected ListaEncadeada<Integer, Entidade> listaDeEntidade = new ListaEncadeada<>();

        protected NoLista esquerda = null;
        protected NoLista direita = null;
        protected int altura;

        public NoLista(K chave) {

            this.chave = chave;
        }

        public void inserir(Entidade e) {
            listaDeEntidade.incluir(e);
        }

        public void printTree() {
            if (direita != null) {
                direita.printTree(true, "");
            }
            printNodeValue();
            if (esquerda != null) {
                esquerda.printTree(false, "");
            }

        }

        private void printNodeValue() {
            System.out.print("" + chave + "/" + saldo());
            System.out.print('\n');
        }

        private void printTree(boolean isRight, String indent) {
            if (direita != null) {
                direita.printTree(true, indent + (isRight ? "        " : " |      "));
            }
            System.out.print(indent);
            if (isRight) {
                System.out.print("  /");
            } else {
                System.out.print("  \\");
            }

            System.out.print("----- ");
            printNodeValue();

            if (esquerda != null) {
                esquerda.printTree(false, indent + (isRight ? " |      " : "        "));
            }
        }

        public int altura() {
            return Math.max(altura(this.direita), altura(this.esquerda)) + 1;
        }

        private int altura(NoLista no) {
            if (no != null) {
                return Math.max(altura(no.direita), altura(no.esquerda)) + 1;
            }
            return 0;
        }

        protected int saldo() {
            if (this.direita != null && this.esquerda != null) {
                return this.esquerda.altura() - this.direita.altura();
            } else if (this.direita != null && this.esquerda == null) {
                return 0 - this.direita.altura();
            } else if (this.direita == null && this.esquerda != null) {
                return this.esquerda.altura() - 0;
            }
            return 0;
        }
    }

    private NoLista<K, Entidade> raiz;

    /**
     * Inserir um objeto numa arvore balanceada
     *
     * @param rotulo a rotulo/chave que vai conter no noh, caso seja uma arvore
     * de lista de venda por filial o rotulo será a filial, caso seja por
     * ano_mes esse valor é definido por esse parametro
     * @param objeto Cada noh contem uma lista de objetos do tipo Entidade a ser
     * definido
     * @return
     */
    public boolean inserir(K rotulo, Entidade objeto) {
        raiz = inserir(raiz, rotulo, objeto);
        // print();
        return true;

    }

    private NoLista inserir(NoLista<K, Entidade> no, K rotulo, Entidade objeto) {
        if (no == null) {
            no = new NoLista<>(rotulo);
            no.inserir(objeto);
            //System.out.println("INSERIR INICIO " + no.chave + " " + no.listaDeEntidade.size());
        } else if (rotulo.compareTo(no.chave) < 0) {
            no.esquerda = inserir(no.esquerda, rotulo, objeto);
            //System.out.println("esquerda " + rotulo + " " + no.chave);
        } else if (rotulo.compareTo(no.chave) > 0) {
            no.direita = inserir(no.direita, rotulo, objeto);
            //System.out.println("direita " + rotulo + " " + no.chave);
        } else if (no.chave.equals(rotulo)) {
            //System.out.println("INSERIR FIM " + no.chave + " " + no.listaDeEntidade.size());
            no.inserir(objeto);
        }
        no = balance(no);
        return no;
    }

    /**
     * Retorna o fator de balanceamento da arvore com raiz t
     */
    private int getFactor(NoLista no) {
        //return no.esquerda.altura() - no.direita.altura();
        return no != null ? no.saldo() : 0;
    }

    private NoLista<K, Entidade> balance(NoLista<K, Entidade> no) {
        if (getFactor(no) == 2) {
//            System.out.println("fator no " + no.chave + "= " + getFactor(no));
            if (getFactor(no.esquerda) > 0) {
                no = doRightRotation(no);
            } else {
                no = doDoubleRightRotation(no);
            }
        } else if (getFactor(no) == -2) {
//            System.out.println("fator no " + no.chave + "= " + getFactor(no));
            if (getFactor(no.direita) < 0) {
                no = doLeftRotation(no);
            } else {
                no = doDoubleLeftRotation(no);
            }
        }
        return no;
    }

    public ListaEncadeada<Integer, Entidade> buscar(K rotulo) {
        if (raiz != null) {
            return buscar(raiz, rotulo);
        } else {
            return null;
        }
    }

    private ListaEncadeada<Integer, Entidade> buscar(NoLista no, K rotulo) {
        if (no.chave.equals(rotulo)) {
            return no.listaDeEntidade;
        } else if (rotulo.compareTo(no.chave) > 0 && no.direita != null) {
            return buscar(no.direita, rotulo);
        } else if (rotulo.compareTo(no.chave) < 0 && no.esquerda != null) {
            return buscar(no.esquerda, rotulo);
        } else {
            return null;
        }
    }

    public ListaEncadeada<Integer, Entidade> buscar(K inicio, K fim) {
        if (raiz != null) {
            return buscar(raiz, inicio, fim);
        } else {
            return null;
        }
    }

    public ListaEncadeada<Integer, Entidade> buscar(NoLista<K, Entidade> no, K inicio, K fim) {
        ListaEncadeada<Integer, Entidade> intervalo = new ListaEncadeada<>();
        if (inicio.compareTo(no.chave) < 0 && no.esquerda != null) {
            intervalo.incluir(buscar(no.esquerda, inicio, fim));
        }
        if (fim.compareTo(no.chave) > 0 && no.direita != null) {
            intervalo.incluir(buscar(no.direita, inicio, fim));
        }
        if (inicio.compareTo(no.chave) <= 0 && fim.compareTo(no.chave) >= 0) {
            intervalo.incluir(no.listaDeEntidade);
        }
        return intervalo;
    }

    public void print() {
        raiz.printTree();
    }

    public void inorder() {
        int total = 0;
        total = inorder(raiz, total);
        System.out.println("Total " + total);
    }

    protected int inorder(NoLista p, int total) {
        if (p != null) {
            total = inorder(p.esquerda, total);
            total += p.listaDeEntidade.tamanho();
            System.out.println("Chave- " + p.chave + " Tam- " + p.listaDeEntidade.tamanho() + " Acum-" + total);
            total = inorder(p.direita, total);
        }
        return total;
    }

    private NoLista<K, Entidade> doRightRotation(NoLista<K, Entidade> no) {
//        System.out.println("Gira Direita");
        NoLista<K, Entidade> noTemp = no.esquerda;
        no.esquerda = noTemp.direita;
        noTemp.direita = no;
        return noTemp;
    }

    private NoLista<K, Entidade> doDoubleRightRotation(NoLista<K, Entidade> no) {
//        System.out.println("Gira Esquerda/Direita");
        no.esquerda = doLeftRotation(no.esquerda);
        return doRightRotation(no);
    }

    private NoLista<K, Entidade> doLeftRotation(NoLista<K, Entidade> no) {
//        System.out.println("Gira Esquerda");
        NoLista novoPai = no.direita;
        no.direita = novoPai.esquerda;
        novoPai.esquerda = no;

        return novoPai;
    }

    private NoLista<K, Entidade> doDoubleLeftRotation(NoLista<K, Entidade> no) {
//        System.out.println("Gira Direita/Esquerda");
        no.direita = doRightRotation(no.direita);
        return doLeftRotation(no);
    }

}
