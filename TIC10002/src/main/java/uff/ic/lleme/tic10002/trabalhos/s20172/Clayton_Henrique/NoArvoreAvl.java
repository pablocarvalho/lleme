package uff.ic.lleme.tic10002.trabalhos.s20172.Clayton_Henrique;

public class NoArvoreAvl {

	public int fluxo;
	public int altura;
	public ListaEncadeadaSetorDia listaSetorDia;
	
	public NoArvoreAvl filhoEsquerda;
	public NoArvoreAvl filhoDireita;
	
	
	public NoArvoreAvl(int fluxo){
		this.fluxo = fluxo;
		this.listaSetorDia = new ListaEncadeadaSetorDia();
	}

}
