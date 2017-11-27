package uff.ic.lleme.tic10002.trabalhos.s20172.Luana_Uchoa;

import java.nio.ByteBuffer;

public class Trafego extends Elemento<String, Integer> {

    int fluxo;
    String setor;
    String dia;

    @Override
    public String getChave() {
        return setor + ";" + dia;
    }

    @Override
    public void setChave(String chave) {
        String[] aux = chave.split(";");

        this.setor = aux[0];
        this.dia = aux[1];
    }

    @Override
    public Integer getConteudo() {
        return this.fluxo;
    }

    @Override
    public void setConteudo(Integer conteudo) {
        this.fluxo = conteudo;

    }

    @Override
    public Integer getHashCode() {
        String chave = setor + ";" + dia;
        ByteBuffer wrapped = ByteBuffer.wrap(chave.getBytes());
        return wrapped.getInt();
    }

    public int compareTo(Trafego t2) {
        int chave1 = Integer.parseInt(this.setor.substring(1));
        int chave2 = Integer.parseInt(t2.setor.substring(1));

        return (chave1 > chave2) ? -1 : 1;
    }
}
