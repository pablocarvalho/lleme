package uff.ic.lleme.tic10002.arvore;

import uff.ic.lleme.tic10002.Empregado;
import uff.ic.lleme.tic10002.ColecaoEmpregado;

public class ArvoveEmpregado implements ColecaoEmpregado {

    private No raiz = null;
    private int quantidadeNos = 0;

    private class No {

        private Empregado empregado;
        private No pai = null;
        private No esquerda = null;
        private No direita = null;

        public No(Empregado empregado) {
            this.empregado = empregado;
        }

        private No(Empregado empregado, No pai) {
            this.empregado = empregado;
            this.pai = pai;
        }

        private Empregado getEmpregado() {
            return empregado;
        }

        private boolean ehEsquerda() {
            if (pai != null)
                return pai.esquerda == this;
            else
                return false;
        }

        private boolean ehDireita() {
            if (pai != null)
                return pai.direita == this;
            else
                return false;
        }

        private boolean ehFolha() {
            return esquerda == null && direita == null;
        }

        private boolean temFilhoUnico() {
            return !(esquerda != null && direita != null);
        }

        private No filhoUnico() {
            if (esquerda == null && direita != null)
                return direita;
            else if (esquerda != null && direita == null)
                return esquerda;
            else
                return null;
        }

        private No filhoFolha() {
            if (esquerda != null && esquerda.ehFolha())
                return esquerda;
            else if (direita != null && direita.ehFolha())
                return direita;
            else
                return null;
        }

        private boolean temFolha() {
            return esquerda != null && esquerda.ehFolha() || direita != null && direita.ehFolha();
        }

        private void connectarPaiADireita(No filho) {
            if (pai != null) {
                pai.direita = filho;
                if (filho != null)
                    filho.pai = pai;
            }
        }

        private void connectarPaiAEsquerda(No filho) {
            if (pai != null) {
                pai.esquerda = filho;
                if (filho != null)
                    filho.pai = pai;
            }
        }

        private No irmao() {
            if (pai != null)
                if (pai.direita == this)
                    return pai.esquerda;
                else
                    return pai.direita;
            else
                return null;
        }

        private void conectar(No filho) {
            if (filho != null && filho.empregado != null && empregado.compararInstancia(filho.empregado) < 0) {
                direita = filho;
                filho.pai = this;
            } else if (filho != null && filho.empregado != null && empregado.compararInstancia(filho.empregado) > 0) {
                direita = filho;
                filho.pai = this;
            }
        }
    }

    @Override
    public Empregado incluir(Empregado empregado) {
        if (empregado != null)
            if (raiz == null) {
                quantidadeNos++;
                return (raiz = new No(empregado)).getEmpregado();
            } else
                return incluir(raiz, empregado);
        else
            return null;
    }

    private Empregado incluir(No raiz, Empregado empregado) {
        if (raiz != null)
            if (raiz.getEmpregado().compararInstancia(empregado) == 0)
                return null;
            else if (raiz.getEmpregado().compararInstancia(empregado) < 0)
                if (raiz.direita == null) {
                    quantidadeNos++;
                    return (raiz.direita = new No(empregado, raiz)).empregado;
                } else
                    return incluir(raiz.direita, empregado);
            else if (raiz.getEmpregado().compararInstancia(empregado) > 0)
                if (raiz.esquerda == null) {
                    quantidadeNos++;
                    return (raiz.esquerda = new No(empregado, raiz)).empregado;
                } else
                    return incluir(raiz.esquerda, empregado);
            else
                return null;
        else
            return null;
    }

    @Override
    public Empregado excluir(String cpf) {
        return excluir(raiz, cpf);
    }

    private Empregado excluir(No raiz, String cpf) {
        No excluido;
        if (raiz != null)
            if (raiz.getEmpregado().compararChave(cpf) == 0) {
                excluido = raiz;
                if (raiz.ehFolha())
                    if (raiz.ehDireita())
                        raiz.connectarPaiADireita(null);
                    else
                        raiz.connectarPaiAEsquerda(null);
                else if (raiz.temFilhoUnico())
                    if (raiz.ehDireita())
                        raiz.connectarPaiADireita(raiz.filhoUnico());
                    else
                        raiz.connectarPaiAEsquerda(raiz.filhoUnico());
                else if (raiz.temFolha())
                    if (raiz.ehDireita()) {
                        No filhoFolha = raiz.filhoFolha();
                        No irmaoFilhoFolha = filhoFolha.irmao();
                        raiz.connectarPaiADireita(filhoFolha);
                        filhoFolha.conectar(irmaoFilhoFolha);
                    } else {
                        No filhoFolha = raiz.filhoFolha();
                        No irmaoFilhoFolha = filhoFolha.irmao();
                        raiz.connectarPaiAEsquerda(filhoFolha);
                        filhoFolha.conectar(irmaoFilhoFolha);
                    }
                else if (raiz.ehDireita())
                    raiz.pai.direita = null; //complatar
                else
                    raiz.pai.esquerda = null; // completar
                return excluido.empregado;
            } else if (raiz.getEmpregado().compararChave(cpf) < 0)
                return excluir(raiz.direita, cpf);
            else if (raiz.getEmpregado().compararChave(cpf) > 0)
                return excluir(raiz.esquerda, cpf);
            else
                return null;
        else
            return null;
    }

    @Override
    public Empregado buscar(String cpf) {
        return buscar(raiz, cpf);
    }

    private Empregado buscar(No raiz, String cpf) {
        if (raiz != null)
            if (raiz.getEmpregado().compararChave(cpf) == 0)
                return raiz.getEmpregado();
            else if (raiz.getEmpregado().cpf.compareTo(cpf) < 0)
                return buscar(raiz.direita, cpf);
            else
                return buscar(raiz.esquerda, cpf);
        else
            return null;

    }
}
