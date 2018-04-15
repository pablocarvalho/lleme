package uff.ic.lleme.tcc00175.exercicios.calculadora.facade;

import uff.ic.lleme.tcc00175.exercicios.calculadora.command.AlterarExpressao;
import uff.ic.lleme.tcc00175.exercicios.calculadora.command.AlterarVariavel;
import uff.ic.lleme.tcc00175.exercicios.calculadora.command.Command;
import uff.ic.lleme.tcc00175.exercicios.calculadora.mediator.MediadorDeAlteracao;

import java.util.Map;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

import uff.ic.lleme.tcc00175.exercicios.calculadora.memento.Memento;
import uff.ic.lleme.tcc00175.exercicios.calculadora.memento.Originator;

public class Operacoes {

    private MediadorDeAlteracao mediador = null;
    private Stack<Command> comandos = new Stack<>();

    public Operacoes() {
        mediador = new MediadorDeAlteracao();
        mediador.expressao = mediador.getEditorExpressao();
        mediador.mapaVariaveis = mediador.getEditorVariaveis();
    }

    public Map<String, Double> alterarExpressao(String expressao, Originator originator) {
        try {
            Command cmd = new AlterarExpressao(expressao, mediador, originator);
            cmd.execute();
            comandos.push(cmd);
            //this.mediador.setExpressaoStr(expressao);
        } catch (Exception ex) {
            Logger.getLogger(Operacoes.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
        return mediador.mapaVariaveis.listVars();
    }

    public void alterarVariavel(String variavel, Double valor, Originator originator) throws CloneNotSupportedException, Exception {
        Command cmd = new AlterarVariavel(variavel, valor, mediador, originator);
        comandos.push(cmd);
        cmd.execute();
    }

    public Double getResultado() {
        return mediador.expressao.getResultado();
    }

    public void desfazer() {
        comandos.pop().desfazer();
    }
  //    private void alterarVariaveis(Map<String, Double> variaveis) {
    //        for (String var : variaveis.keySet())
    //            alterarVariavel(var, variaveis.get(var));
    //    }
}
