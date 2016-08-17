package exercicios.calculadora.decorator;

public abstract class Decorador extends InterpretadorDeExpressao {

    /**
     * @aggregation shared
     */
    private InterpretadorDeExpressao component;

    private Decorador() {
    }

    public Decorador(InterpretadorDeExpressao componente) {
        this.component = componente;
    }

    @Override
    public String fragmentar(String expressao) throws Exception {
        return getComponent().fragmentar(expressao);
    }

    public InterpretadorDeExpressao getComponent() {
        return component;
    }

    public void setComponent(InterpretadorDeExpressao component) {
        this.component = component;
    }
}
