package uff.ic.lleme.tic10002.arvore;

import java.io.InvalidObjectException;
import uff.ic.lleme.tic10002.ColecaoEmpregado;
import uff.ic.lleme.tic10002.Empregado;

public class ArvoreEmpregado implements ColecaoEmpregado {

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
            if (direita != null && direita.ehFolha())
                return direita;
            else if (esquerda != null && esquerda.ehFolha())
                return esquerda;
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
                if (getConteudo().compararInstancia(filho.getConteudo()) < 0)
                    if (esquerda == null) {
                        esquerda = filho;
                        filho.pai = this;
                        return filho;
                    } else
                        return esquerda.conectar(filho);
                else if (getConteudo().compararInstancia(filho.getConteudo()) > 0)
                    if (direita == null) {
                        direita = filho;
                        filho.pai = this;
                        return filho;
                    } else
                        return direita.conectar(filho);
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
            else if (noCorrente.getConteudo().compararChave(cpf) < 0)
                return buscar(noCorrente.direita, cpf);
            else
                return null;
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
        if (raiz != null) {
            if (raiz.getConteudo().compararChave(cpf) == 0) {
                No resultado = raiz;
                raiz = resultado.direita;
                raiz.conectar(resultado.esquerda);
                raiz.pai = null;
                quantidadeNos--;
                return resultado.getConteudo();
            }
            return excluir(raiz, cpf);
        }
        return null;
    }

    private Empregado excluir(No noCorrente, String cpf) {
        No excluido;
        if (noCorrente != null)
            if (noCorrente.getConteudo().compararChave(cpf) == 0) {
                excluido = noCorrente;
                if (noCorrente.ehFolha())
                    if (noCorrente.ehDireita())
                        noCorrente.connectarPaiADireita(null);
                    else
                        noCorrente.connectarPaiAEsquerda(null);
                else if (noCorrente.temFilhoUnico())
                    if (noCorrente.ehDireita())
                        noCorrente.connectarPaiADireita(noCorrente.filhoUnico());
                    else
                        noCorrente.connectarPaiAEsquerda(noCorrente.filhoUnico());
                else if (noCorrente.temFolha())
                    if (noCorrente.ehDireita()) {
                        No filhoFolha = noCorrente.filhoFolha();
                        No irmaoFilhoFolha = filhoFolha.irmao();
                        noCorrente.connectarPaiADireita(filhoFolha);
                        filhoFolha.conectar(irmaoFilhoFolha);
                    } else {
                        No filhoFolha = noCorrente.filhoFolha();
                        No irmaoFilhoFolha = filhoFolha.irmao();
                        noCorrente.connectarPaiAEsquerda(filhoFolha);
                        filhoFolha.conectar(irmaoFilhoFolha);
                    }
                else if (noCorrente.ehDireita()) {
                    No esquerda = noCorrente.esquerda;
                    No direita = esquerda.irmao();
                    noCorrente.connectarPaiADireita(esquerda);
                    esquerda.conectar(direita);
                } else {
                    No esquerda = noCorrente.esquerda;
                    No direita = esquerda.irmao();
                    noCorrente.connectarPaiAEsquerda(esquerda);
                    esquerda.conectar(direita);
                }
                quantidadeNos--;
                return excluido.getConteudo();
            } else if (noCorrente.getConteudo().compararChave(cpf) < 0)
                return excluir(noCorrente.esquerda, cpf);
            else if (noCorrente.getConteudo().compararChave(cpf) > 0)
                return excluir(noCorrente.direita, cpf);
            else
                return null;
        else
            return null;
    }

}
