package uff.ic.lleme.tic10002.trabalhos.s20172.Clayton_e_Henrique;

public class AcumuladorDeFluxos {

	TabelaHash hash = new TabelaHash();
	
	public void acumular(Fluxo fluxo) {
		hash.insere(fluxo);
	}
	
	public ListaEncadeadaDeFluxos getFluxosAcumulados() {
		return hash.getConteudo();
	}
	
}
