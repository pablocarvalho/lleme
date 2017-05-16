package uff.ic.lleme.tic10002.arvore;

import java.io.InvalidObjectException;
import uff.ic.lleme.tic10002.ColecaoEmpregado;
import uff.ic.lleme.tic10002.Empregado;

public class ArvoveEmpregado implements ColecaoEmpregado {

    private No raiz = null;
    private int quantidadeNos = 0;

    private class No {

        private Empregado conteudo = null;
        private No pai = null;
        private No esquerda = null;
        private No direita = null;

        private No() throws InvalidObjectException {
            throw new InvalidObjectException("Empregado desconhecido.");
        }

        public No(Empregado empregado) throws InvalidObjectException {
            if (ehValido(empregado))
                this.conteudo = empregado;
            else
                throw new InvalidObjectException("Empregado desconhecido ou sem identificacao.");
        }

        private boolean ehValido(Empregado empregado) {
            return empregado != null && empregado.getChave() != null;
        }

        public Empregado getConteudo() {
            return conteudo;
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
            if (filho != null)
                if (getConteudo().compararInstancia(filho.getConteudo()) < 0) {
                    esquerda = filho;
                    filho.pai = this;
                    return filho;
                } else if (getConteudo().compararInstancia(filho.getConteudo()) > 0) {
                    direita = filho;
                    filho.pai = this;
                    return filho;
                } else
                    return null;
            else
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

    private Empregado buscar(No noCorrente, String cpf) {
        if (noCorrente != null)
            if (noCorrente.getConteudo().compararChave(cpf) == 0)
                return noCorrente.getConteudo();
            else if (noCorrente.getConteudo().compararChave(cpf) < 0)
                return buscar(noCorrente.esquerda, cpf);
            else
                return buscar(noCorrente.direita, cpf);
        else
            return null;

    }

    @Override
    public Empregado incluir(Empregado empregado) throws InvalidObjectException {
        if (raiz == null) {
            raiz = new No(empregado);
            quantidadeNos = 1;
            return raiz.getConteudo();
        }
        return incluir(raiz, new No(empregado));
    }

    private Empregado incluir(No noCorrente, No novoNo) throws InvalidObjectException {
        if (noCorrente.getConteudo().compararInstancia(novoNo.getConteudo()) == 0)
            throw new InvalidObjectException("Chave duplicada.");
        else if (noCorrente.getConteudo().compararInstancia(novoNo.getConteudo()) < 0)
            if (noCorrente.esquerda == null) {
                No resultado = noCorrente.conectar(novoNo);
                quantidadeNos++;
                return resultado.getConteudo();
            } else
                return incluir(noCorrente.esquerda, novoNo);
        else if (noCorrente.getConteudo().compararInstancia(novoNo.getConteudo()) > 0)
            if (noCorrente.direita == null) {
                No resultado = noCorrente.conectar(novoNo);
                quantidadeNos++;
                return resultado.getConteudo();
            } else
                return incluir(noCorrente.direita, novoNo);
        else
            return null;
    }

    @Override
    public Empregado excluir(String cpf) {
        if (raiz != null)
            return excluir(raiz, cpf);
        return null;
    }

    private Empregado excluir(No no, String cpf) {
        No excluido;
        if (no.getConteudo().compararChave(cpf) == 0) {
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
            return excluido.getConteudo();
        } else if (no.getConteudo().compararChave(cpf) < 0)
            return excluir(no.direita, cpf);
        else if (no.getConteudo().compararChave(cpf) > 0)
            return excluir(no.esquerda, cpf);
        else
            return null;
    }

}
