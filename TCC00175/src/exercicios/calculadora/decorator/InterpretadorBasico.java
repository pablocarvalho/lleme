package exercicios.calculadora.decorator;

import exercicios.calculadora.chainOfResponsability.FragmentadorVariavel;
import exercicios.calculadora.chainOfResponsability.FragmentadorLiteral;
import exercicios.calculadora.chainOfResponsability.FragmentadorDeExpressao;

public class InterpretadorBasico extends InterpretadorDeExpressao {

    public InterpretadorBasico() {
        FragmentadorDeExpressao f1;
        FragmentadorDeExpressao f2;
        f1 = new FragmentadorLiteral();
        cadeiaDeFragmentadores = f1;
        f2 = new FragmentadorVariavel();
        f1.proximo = f2;
    }

    @Override
    public String fragmentar(String expressao) throws Exception {
        return cadeiaDeFragmentadores.extrairSimbolo(expressao);
    }
}
