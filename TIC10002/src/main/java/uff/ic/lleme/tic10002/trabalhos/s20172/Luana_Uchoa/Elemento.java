package uff.ic.lleme.tic10002.trabalhos.s20172.Luana_Uchoa;

public abstract class Elemento<TipoChave, TipoConteudo> {

    public abstract TipoChave getChave();

    public abstract void setChave(TipoChave chave);

    public abstract TipoConteudo getConteudo();

    public abstract void setConteudo(TipoConteudo conteudo);

    //... m�todos auxiliares
    public abstract Integer getHashCode();

}
