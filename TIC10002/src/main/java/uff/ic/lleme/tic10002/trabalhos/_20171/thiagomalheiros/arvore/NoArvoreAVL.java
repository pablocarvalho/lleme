/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tic10002.trabalhos._20171.thiagomalheiros.arvore;

/**
 *
 * @author Thiago
 */
public class NoArvoreAVL {
  
	private NoArvoreAVL esquerda;
	private NoArvoreAVL direita;
	private NoArvoreAVL pai;
	private int chave;
        private ListaEncadeadaVendas lista;
	private int balanceamento;

	public NoArvoreAVL(int k) 
        {
		setEsquerda(setDireita(setPai(null)));
		setBalanceamento(0);
		setChave(k);
	}
        public NoArvoreAVL(int k, NoListaEncadeada venda) 
        {
		setEsquerda(setDireita(setPai(null)));
		setBalanceamento(0);
		setChave(k);
                setNovavenda (venda);
	}

	public String toString() {
		return Integer.toString(getChave());
	}

	public int getChave() {
		return chave;
	}

	public void setChave(int chave) {
		this.chave = chave;
	}

	public int getBalanceamento() {
		return balanceamento;
	}

	public void setBalanceamento(int balanceamento) {
		this.balanceamento = balanceamento;
	}

	public NoArvoreAVL getPai() {
		return pai;
	}

	public NoArvoreAVL setPai(NoArvoreAVL pai) {
		this.pai = pai;
		return pai;
	}

	public NoArvoreAVL getDireita() {
		return direita;
	}

	public NoArvoreAVL setDireita(NoArvoreAVL direita) {
		this.direita = direita;
		return direita;
	}

	public NoArvoreAVL getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(NoArvoreAVL esquerda) {
		this.esquerda = esquerda;
	}
        
        public ListaEncadeadaVendas getLista (){
            return lista;
        }
        
        public void setNovavenda (NoListaEncadeada venda)
        {
            lista = new ListaEncadeadaVendas();
            this.lista.inserirNoFim(venda);
        }
}
        



