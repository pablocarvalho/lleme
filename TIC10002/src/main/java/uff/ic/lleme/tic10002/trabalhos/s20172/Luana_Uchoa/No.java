package controleTrafego;

public class No <E extends Elemento<String, Integer>>{

	private No<E> esquerda;
	private No<E> direita;
	private No<E> pai;
	private int balanceamento;
	public E objeto;

	public No(E t) {
		objeto = t;
		setEsquerda(setDireita(setPai(null)));
		setBalanceamento(0);
		setChave(t.getConteudo());
	}

	public String toString() {
		return getChave().toString();
	}

	public Integer getChave() {
		return objeto.getConteudo();
	}

	public void setChave(Integer chave) {
		this.objeto.setConteudo(chave);
	}

	public int getBalanceamento() {
		return balanceamento;
	}

	public void setBalanceamento(int balanceamento) {
		this.balanceamento = balanceamento;
	}

	public No<E> getPai() {
		return pai;
	}

	public No<E> setPai(No<E> pai) {
		this.pai = pai;
		return pai;
	}

	public No<E> getDireita() {
		return direita;
	}

	public No<E> setDireita(No<E> direita) {
		this.direita = direita;
		return direita;
	}

	public No<E> getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(No<E> esquerda) {
		this.esquerda = esquerda;
	}
}
