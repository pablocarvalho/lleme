package exercicios.letreiro;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Letreiro {

    private char[] mensagem = null;
    private Observador painel = null;
    private Mostrador[] mostradores = null;
    private Fabrica fabrica = null;
    private int tamanho = 0;
    private int posInicialMsg = 0;

    public Letreiro(byte tamanho, Fabrica fabrica, Observador painel) {
        this.painel = painel;
        this.mostradores = new Mostrador[tamanho];
        this.fabrica = fabrica;
        this.tamanho = tamanho;
        for (int i = 0; i < mostradores.length; i++)
            mostradores[i] = fabrica.criarMostrador();
    }

    public void ligar() {

        new Thread((new Runnable() {
            public void run() {
                while (true)
                    try {
                        avisarObservador();
                        Thread.sleep(200);
                        posInicialMsg++;
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Letreiro.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
        })).start();
    }

    public void atribuirMensagem(String mensagem) {
        int tamanho = Math.max(mensagem.length(), mostradores.length);
        char[] msgChars = mensagem.toCharArray();

        this.mensagem = new char[tamanho];
        for (int i = 0; i < this.mensagem.length; i++)
            this.mensagem[i] = ' ';
        for (int i = 0; i < msgChars.length; i++)
            this.mensagem[i] = msgChars[i];
    }

    public List<char[][]> obterLeds() {
        List<char[][]> lista = new ArrayList<>();
        Mostrador mostrador;
        char charMsg;
        int posMsg;

        for (int i = 0; i < mostradores.length; i++) {
            posMsg = (posInicialMsg + i) % tamanho;
            mostrador = mostradores[i];
            charMsg = mensagem[posMsg];

            mostrador.acenderLeds(fabrica.obterCaractere(charMsg));
            lista.add(mostrador.obterLeds());
        }
        return lista;
    }

    private void avisarObservador() {
        painel.atualizarLetreiro(this);
    }
}
