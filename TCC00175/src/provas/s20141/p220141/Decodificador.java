package provas.s20141.p220141;

public class Decodificador {

    private Estado estado = null;

    public Decodificador() {
        Estado0.obterInstancia();
        Estado1.obterInstancia();
        Estado2.obterInstancia();

        estado = Estado0.obterInstancia();

        String[][] transicoes = {
            {   "livro",         "", "Mensagem"},
            {        "", "programa", "original"},
            {"Mensagem", "original", ""}};
        Estado.ajustarTransicoes(transicoes);
    }

    public String decodificar(String msg) {
        estado = estado.proximoEstado(msg);
        return estado.decodificar();
    }

}
