package uff.ic.lleme.tic10002.trabalhos.s20171.diogoperdomo;

public class No {

    private ListaFilial l_filial;
    private No esquerda;
    private No direita;
    private No pai;
    private int chave;
    private int balanceamento;
    public String tipo;

    public No(int Filial, int Ano_mes, int cod_vendedor, double totalvendido, int Chave) {
        setEsquerda(setDireita(setPai(null)));
        setBalanceamento(0);
        //setChave(8989); //a Chave foi colocada na criacao da arvore
        this.chave = Chave;
        //l_filial = new ListaFilial(Filial);
        l_filial = new ListaFilial(Chave);
        l_filial.incluir(Filial, Ano_mes, cod_vendedor, totalvendido);
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

    public No getPai() {
        return pai;
    }

    public No setPai(No pai) {
        this.pai = pai;
        return pai;
    }

    public No getDireita() {
        return direita;
    }

    public No setDireita(No direita) {
        this.direita = direita;
        return direita;
    }

    public No getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }

    public void printTree() {
        if (direita != null)
            direita.printTree(false, "");
        printNodeValue();
        if (esquerda != null)
            esquerda.printTree(true, "");
    }

    private void printNodeValue() {
        System.out.print("" + chave + "/" + balanceamento * (-1));
        System.out.print('\n');
    }

    private void printTree(boolean isRight, String indent) {
        if (direita != null)
            direita.printTree(false, indent + (isRight ? " |      " : "        "));
        System.out.print(indent);
        if (isRight)
            System.out.print(" \\");
        else
            System.out.print(" /");
        System.out.print("----- ");
        printNodeValue();
        if (esquerda != null)
            esquerda.printTree(true, indent + (isRight ? "        " : " |      "));
    }

    public void insertvenda(int Filial, int Ano_mes, int cod_vendedor, double totalvendido) {
        l_filial.incluir(Filial, Ano_mes, cod_vendedor, totalvendido);
    }

    public ListaFilial getFilial() {
        return l_filial;
    }
}
