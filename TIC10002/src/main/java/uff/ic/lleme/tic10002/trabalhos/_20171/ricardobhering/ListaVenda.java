package uff.ic.lleme.tic10002.trabalhos._20171.ricardobhering;

public class ListaVenda {
	protected int codFunc;
	protected double valor;
	protected ListaVenda proximo;

	public ListaVenda(){
		codFunc = -1;
		valor = 0.0;
		proximo = null;
	}
	
	protected void adicionar(int vendedor, double valorVenda){
		if(this.codFunc == -1 ){
			this.codFunc = vendedor;
			this.valor = valorVenda;
		}else{
			ListaVenda novaVenda = new ListaVenda();
			novaVenda.codFunc = vendedor;
			novaVenda.valor = valorVenda;
			ListaVenda aux = this;
			ListaVenda temp = aux.proximo;
			aux.proximo=novaVenda;
			novaVenda.proximo = temp;
		}
	}
	protected float somaVenda(){
		ListaVenda aux = this;
		float soma = 0;
		while(aux!=null){
			soma += aux.valor;
			aux = aux.proximo;
		}
		return soma;
	}
}