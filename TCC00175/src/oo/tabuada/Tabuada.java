package oo.tabuada;

public class Tabuada {

    private Fator[] fatores = new Fator[9];

    public Tabuada(byte[] fatores) {
        for (int i = 0; i < 9 && i < fatores.length; i++)
            this.fatores[i] = new Fator(fatores[i]);
    }

    public void escreverTabuada(int qtdLinhas) {
        for (int i = 1; i <= qtdLinhas; i++)
            escreverLinha(i);
    }

    private void escreverLinha(int linha) {
        for (Fator fator : fatores)
            if (fator != null) {
                fator.excrever(linha);
                System.out.print("  \t");
            } else
                break;
        System.out.println("");
    }
}
