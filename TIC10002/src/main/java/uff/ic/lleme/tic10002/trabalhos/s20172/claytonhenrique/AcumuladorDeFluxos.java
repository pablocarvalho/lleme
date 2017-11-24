package claytonhenrique;

public class AcumuladorDeFluxos {

	TabelaHash hash = new TabelaHash();
	
	public void acumular(Fluxo fluxo) {
		hash.insere(fluxo);
	}
	
	public ListaEncadeadaDeFluxos getFluxosAcumulados() {
		return hash.getConteudo();
	}
	
}
