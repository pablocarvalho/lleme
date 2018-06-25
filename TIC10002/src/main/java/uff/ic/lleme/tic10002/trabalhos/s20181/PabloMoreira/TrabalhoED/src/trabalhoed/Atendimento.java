/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoed;

/**
 *
 * @author pablomoreira
 */

public class Atendimento {
    public final static int MAX_ASSUNTOS = 10;
    private Cliente cliente;
    private Assunto[] assunto;
    private int horaChegada;
    private int horaAtendimento;

    public Atendimento(Cliente cliente, Assunto[] assunto, int horaChegada, int horaAtendimento) {
        this.cliente = cliente;
        this.assunto = assunto;
        this.horaChegada = horaChegada;
        this.horaAtendimento = horaAtendimento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Assunto[] getAssunto() {
        return assunto;
    }

    public void setAssunto(Assunto[] assunto) {
        this.assunto = assunto;
    }

    public int getHoraChegada() {
        return horaChegada;
    }

    public void setHoraChegada(int horaChegada) {
        this.horaChegada = horaChegada;
    }

    public int getHoraAtendimento() {
        return horaAtendimento;
    }

    public void setHoraAtendimento(int horaAtendimento) {
        this.horaAtendimento = horaAtendimento;
    }
    
    
            
}
