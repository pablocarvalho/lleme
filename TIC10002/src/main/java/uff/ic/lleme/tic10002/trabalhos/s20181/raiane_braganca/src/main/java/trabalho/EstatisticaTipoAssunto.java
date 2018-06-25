package trabalho;

public class EstatisticaTipoAssunto {

    String idTipo;
    int totalAtendimentos = 1;
    double tempoTotal = 0.0;

    public EstatisticaTipoAssunto(String idTipo, double tempoTotal) {
        this.idTipo = idTipo;
        this.tempoTotal = tempoTotal;
    }

    public void atualizaTempo(double tempoTotal) {
        this.tempoTotal += tempoTotal;
        this.totalAtendimentos++;
    }

    public static EstatisticaTipoAssunto buscaElemento(
            String tipo,
            ListaLigada<EstatisticaTipoAssunto> listaPorTipoAssuntos
    ) {
        EstatisticaTipoAssunto tipoAssunto;
        for (int i = 0; i < listaPorTipoAssuntos.tamanho(); i++) {
            tipoAssunto = listaPorTipoAssuntos.obtem(i);
            if (tipoAssunto.idTipo.equals(tipo)) {
                return tipoAssunto;
            }
        }
        return null;
    }
}
