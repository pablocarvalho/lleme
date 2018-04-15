package uff.ic.lleme.tcc00175.exercicios.calculadora.decorator;

import uff.ic.lleme.tcc00175.exercicios.calculadora.chainOfResponsability.FragmentadorCoseno;
import uff.ic.lleme.tcc00175.exercicios.calculadora.chainOfResponsability.FragmentadorDeExpressao;
import uff.ic.lleme.tcc00175.exercicios.calculadora.chainOfResponsability.FragmentadorSeno;
import uff.ic.lleme.tcc00175.exercicios.calculadora.chainOfResponsability.FragmentadorTangente;

public class InterpretadorTrigonometrico extends Decorador {

    public InterpretadorTrigonometrico(InterpretadorDeExpressao componente) {
        super(componente);
        FragmentadorDeExpressao f1;
        FragmentadorDeExpressao f2;
        f1 = new FragmentadorSeno();
        cadeiaDeFragmentadores = f1;
        f2 = new FragmentadorCoseno();
        f1.proximo = f2;
        f1 = f2;
        f2 = new FragmentadorTangente();
        f1.proximo = f2;
    }

    @Override
    public String fragmentar(String expressao) throws Exception {
        expressao = getComponent().fragmentar(expressao);
        return cadeiaDeFragmentadores.extrairSimbolo(expressao);
    }
}
