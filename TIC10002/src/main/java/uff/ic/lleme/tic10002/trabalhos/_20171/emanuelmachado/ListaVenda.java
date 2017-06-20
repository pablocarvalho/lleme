package uff.ic.lleme.tic10002.trabalhos._20171.emanuelmachado;

public class ListaVenda {

    public NoVenda primeiro = null;
    private NoVenda ultimo = null;

    public class NoVenda {

        public Venda conteudo = null;
        public NoVenda proximo = null;

        public NoVenda(Venda venda) {
            conteudo = venda;
        }

    }

    private NoVenda incluir_ultimo(NoVenda ultimoNo, Venda venda) {
        // Cria um nó para o objeto venda
        NoVenda corrente = new NoVenda(venda);

        if (ultimoNo != null) {
            ultimoNo.proximo = corrente;
        }

        return corrente;
    }

    public Venda incluir(Venda venda) {

        ultimo = incluir_ultimo(ultimo, venda);

        if (primeiro == null) {
            primeiro = ultimo;
        }
        return venda;

    }

    public double SomaTotalLista() {
        NoVenda corrente = primeiro;
        double total = 0;
        while (corrente != null) {
            total += corrente.conteudo.getTotal();
            corrente = corrente.proximo;
        }
        return total;
    }

    public double SomaTotalLista(String data1, String data2) {
        NoVenda corrente = primeiro;

        double total = 0;

        while (corrente != null) {
            // Se o ano_mes está entre as datas 1 e 2, acrescenta o total vendido à soma.
            if (Integer.parseInt(corrente.conteudo.getAno_mes()) >= Integer.parseInt(data1) && Integer.parseInt(corrente.conteudo.getAno_mes()) <= Integer.parseInt(data2)) {
                total += corrente.conteudo.getTotal();
            }

            corrente = corrente.proximo;

        }
        return total;
    }

    public String imprimirLista() {
        NoVenda corrente = primeiro;
        String retorno = "";
        while (corrente != null) {
            retorno += corrente.conteudo.getAno_mes() + " ";
            corrente = corrente.proximo;
        }
        return retorno;
    }

}
