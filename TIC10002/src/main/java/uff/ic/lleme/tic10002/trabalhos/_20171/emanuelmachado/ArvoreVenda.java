package uff.ic.lleme.tic10002.trabalhos._20171.emanuelmachado;

// Árvore de Listas encadeadas
public class ArvoreVenda {

    private NoArvore raiz = null;

    private class NoArvore {

        public ListaVenda lista = null;
        public NoArvore esquerda = null;
        public NoArvore direita = null;
        public int altura = 0;

    }

    public String incluir(Venda venda) {
        // Se raiz for igual a null, ele cria o nó da árvore e inclui uma nova lista com a venda corrente
        if (venda == null) {
            return "Não existem vendas a incluir";
        }

        if (raiz == null) {
            NoArvore novo = new NoArvore();
            novo.lista = new ListaVenda();
            novo.lista.incluir(venda);
            raiz = novo;
        } else {
            raiz = incluir(raiz, venda);
        }
        
        return "Venda incluída";
    }

    private NoArvore incluir(NoArvore no, Venda venda) {
            
        if (no == null) {
            NoArvore novo = new NoArvore();
            novo.lista = new ListaVenda();
            novo.lista.incluir(venda);
            no = novo;
            return no;
        }
        NoArvore atual = no;
        // Se o ano_mes da venda a incluir for menor que o ano_mes da primeira venda
        if (Integer.parseInt(venda.getAno_mes()) < Integer.parseInt(atual.lista.primeiro.conteudo.getAno_mes())) {
            
            atual.esquerda = incluir(atual.esquerda, venda);
            
            if (atual.esquerda != null) {
                //Verifica o balanceamento, depois da inclusão do novo nó
                if (fatorBalanceamento(atual) >= 2) {
                    // Define qual tipo de rotação deve ser feita
                    if (Integer.parseInt(venda.getAno_mes()) < Integer.parseInt(atual.esquerda.lista.primeiro.conteudo.getAno_mes())) {
                        atual = rotacaoDireita(atual);
                    } else {

                        atual = rotacaoDuplaDireita(atual);
                    }
                }
            }
        } else if (Integer.parseInt(venda.getAno_mes()) > Integer.parseInt(atual.lista.primeiro.conteudo.getAno_mes())) {
            atual.direita = incluir(atual.direita, venda);
            if (atual.direita != null) {
                if (fatorBalanceamento(atual) >= 2) {
                    if (Integer.parseInt(venda.getAno_mes()) > Integer.parseInt(atual.direita.lista.primeiro.conteudo.getAno_mes())) {
                        atual = rotacaoEsquerda(atual);
                    } else {

                        atual = rotacaoDuplaEsquerda(atual);
                    }
                }
            }
        } else {
            //Se o anomes for igual, inclui o elemento na lista do nó
            atual.lista.incluir(venda);
            return atual;
        }
        
        //Atualiza a altura do nó atual
        atual.altura = maior(alturaNo(atual.esquerda), alturaNo(atual.direita)) + 1;

        return atual;
    }

    private NoArvore rotacaoDireita(NoArvore no) {
        NoArvore aux = no.esquerda;
        no.esquerda = aux.direita;
        aux.direita = no;
        no.altura = maior(alturaNo(no.esquerda), alturaNo(no.direita)) + 1;
        aux.altura = maior(alturaNo(aux.esquerda), no.altura) + 1;
        return aux;
    }

    private NoArvore rotacaoEsquerda(NoArvore no) {
        NoArvore aux = no.direita;
        no.direita = aux.esquerda;
        aux.esquerda = no;
        no.altura = maior(alturaNo(no.esquerda), alturaNo(no.direita)) + 1;
        aux.altura = maior(alturaNo(aux.direita), no.altura) + 1;
        return aux;
    }

    private NoArvore rotacaoDuplaDireita(NoArvore no) {
        no.esquerda = rotacaoEsquerda(no.esquerda);
        return rotacaoDireita(no);
    }

    private NoArvore rotacaoDuplaEsquerda(NoArvore no) {
        no.direita = rotacaoDireita(no.direita);
        return rotacaoEsquerda(no);
    }

    private int alturaNo(NoArvore no) {
        if (no == null) {
            return -1;
        } else {
            return no.altura;
        }
    }
    
    private int fatorBalanceamento(NoArvore no) {
        return Math.abs(alturaNo(no.esquerda) - alturaNo(no.direita));
    }

    private int maior(int x, int y) {
        if (x > y) {
            return x;
        } else {
            return y;
        }
    }    

    public double totalVendas(String data_inicio, String data_fim) {
        return totalVendas(raiz, data_inicio, data_fim);
    }

    private double totalVendas(NoArvore no, String data_inicio, String data_fim) {
        double soma = 0;
        if (no == null) {
            return 0;
        } else {

            //Verifica se o ano_mes da primeira venda da lista do nó da árvore é igual ao ano_mes da venda a ser incluída
            if (Integer.parseInt(no.lista.primeiro.conteudo.getAno_mes()) >= Integer.parseInt(data_inicio) && Integer.parseInt(no.lista.primeiro.conteudo.getAno_mes()) <= Integer.parseInt(data_fim)) {
                soma = no.lista.SomaTotalLista();
            }
            if (Integer.parseInt(data_inicio) < Integer.parseInt(no.lista.primeiro.conteudo.getAno_mes()) && no.esquerda != null) {

                soma += totalVendas(no.esquerda, data_inicio, data_fim);
            }
            if (Integer.parseInt(data_fim) > Integer.parseInt(no.lista.primeiro.conteudo.getAno_mes()) && no.direita != null) {

                soma += totalVendas(no.direita, data_inicio, data_fim);
            }
        }
        return soma;

    }
}
