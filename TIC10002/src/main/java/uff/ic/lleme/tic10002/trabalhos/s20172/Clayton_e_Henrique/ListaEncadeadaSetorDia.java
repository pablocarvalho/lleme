package uff.ic.lleme.tic10002.trabalhos.s20172.Clayton_e_Henrique;


public class ListaEncadeadaSetorDia extends ListaEncadeada {
	
	public void insere(int setor, int dia) {
		NoListaSetorDia novoNo = new NoListaSetorDia();
		novoNo.setor = setor;
		novoNo.dia = dia;
		novoNo.proximo = this.primeiroNo;
		this.primeiroNo = novoNo;
	}
	
}
