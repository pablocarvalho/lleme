package uff.ic.lleme.tic10002.arvore;

import java.io.InvalidObjectException;
import uff.ic.lleme.tic10002.ColecaoEmpregado;
import uff.ic.lleme.tic10002.Empregado;

public class ArvoveEmpregado implements ColecaoEmpregado {

    private No raiz = null;
    private int quantidadeNos = 0;

    private class No {

        public Empregado conteudo = null;
        private No pai = null;
        private No esquerda = null;
        private No direita = null;

        private boolean ehValido(Empregado empregado) {
            return empregado != null && empregado.getChave() != null;
        }

        public No() throws InvalidObjectException {
            throw new InvalidObjectException("Conteudo invalido.");
        }

        public No(Empregado empregado) throws InvalidObjectException {
            if (ehValido(empregado))
                this.conteudo = empregado;
            else
                throw new InvalidObjectException("Conteudo invalido.");
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

        private No connectarPaiADireita(No filho) {
            if (pai != null) {
                pai.direita = filho;
                if (filho != null)
                    filho.pai = pai;
            }
            return filho;
        }

        private No connectarPaiAEsquerda(No filho) {
            if (pai != null) {
                pai.esquerda = filho;
                if (filho != null)
                    filho.pai = pai;
            }
            return filho;
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

        private No conectar(No filho) {
            if (filho != null && filho.conteudo != null)
                if (conteudo.compararInstancia(filho.conteudo) < 0) {
                    esquerda = filho;
                    filho.pai = this;
                    return filho;
                } else if (conteudo.compararInstancia(filho.conteudo) > 0) {
                    direita = filho;
                    filho.pai = this;
                    return filho;
                }
            return null;
        }
    }

    private boolean ehValido(No no, String cpf) {
        return no != null && cpf != null;
    }

    @Override
    public Empregado buscar(String cpf) {
        return buscar(raiz, cpf);
    }

    private Empregado buscar(No no, String cpf) {
        if (no != null)
            if (no.conteudo.compararChave(cpf) == 0)
                return no.conteudo;
            else if (no.conteudo.compararChave(cpf) < 0)
                return buscar(no.esquerda, cpf);
            else
                return buscar(no.direita, cpf);
        else
            return null;

    }

    @Override
    public Empregado incluir(Empregado empregado) throws InvalidObjectException {
        if (raiz == null) {
            raiz = new No(empregado);
            quantidadeNos = 1;
            return raiz.conteudo;
        } else
            return incluir(raiz, empregado);

    }

    private Empregado incluir(No no, Empregado empregado) throws InvalidObjectException {
        if (no.conteudo.compararInstancia(empregado) == 0)
            return null;
        else if (no.conteudo.compararInstancia(empregado) < 0)
            if (no.esquerda == null) {
                No filho = no.conectar(new No(empregado));
                quantidadeNos++;
                return filho.conteudo;
            } else
                return incluir(no.esquerda, empregado);
        else if (no.conteudo.compararInstancia(empregado) > 0)
            if (no.direita == null) {
                No filho = no.conectar(new No(empregado));
                quantidadeNos++;
                return filho.conteudo;
            } else
                return incluir(no.direita, empregado);
        else
            return null;
    }

    @Override
    public Empregado excluir(String cpf) {
        if (ehValido(raiz, cpf))
            return excluir(raiz, cpf);
        else
            return null;
    }

    private Empregado excluir(No no, String cpf) {
        No excluido = null;
        if (no.conteudo.compararChave(cpf) == 0) {
            excluido = no;
            if (no.ehFolha())
                if (no.ehDireita())
                    no.connectarPaiADireita(null);
                else
                    no.connectarPaiAEsquerda(null);
            else if (no.temFilhoUnico())
                if (no.ehDireita())
                    no.connectarPaiADireita(no.filhoUnico());
                else
                    no.connectarPaiAEsquerda(no.filhoUnico());
            else if (no.temFolha())
                if (no.ehDireita()) {
                    No filhoFolha = no.filhoFolha();
                    No irmaoFilhoFolha = filhoFolha.irmao();
                    no.connectarPaiADireita(filhoFolha);
                    filhoFolha.conectar(irmaoFilhoFolha);
                } else {
                    No filhoFolha = no.filhoFolha();
                    No irmaoFilhoFolha = filhoFolha.irmao();
                    no.connectarPaiAEsquerda(filhoFolha);
                    filhoFolha.conectar(irmaoFilhoFolha);
                }
            else if (no.ehDireita())
                no.pai.direita = null; //complatar
            else
                no.pai.esquerda = null; // completar
            return excluido.conteudo;
        } else if (no.conteudo.compararChave(cpf) < 0)
            return excluir(no.direita, cpf);
        else if (no.conteudo.compararChave(cpf) > 0)
            return excluir(no.esquerda, cpf);
        else
            return null;
    }

}
