package exercicios.calculadora.mediator;

import exercicios.calculadora.mediator.ClasseMediada;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapaVariaveis extends ClasseMediada implements Cloneable {

    private Map<String, Double> variaveis = new HashMap<>();

    public MapaVariaveis(Mediador mediador) {
        super(mediador);
    }

    @Override
    public void alterado() {
        mediador.objetoAlterado(this);
    }

    public void setVar(String varName, Double valor) {
        Double old;
        if (varName != null && valor != null) {
            old = variaveis.put(varName, valor);
            if (old == null || !old.equals(valor))
                alterado();
        }
    }

    public Double getVar(String varName) {
        return variaveis.get(varName);
    }

    public Map<String, Double> listVars() {
        return variaveis;
    }

    public Set<String> listVarsNames() {
        return variaveis.keySet();
    }

    public void removeVar(String nome) {
        variaveis.remove(nome);
    }

    public void printVars() {
        for (String nome : variaveis.keySet())
            System.out.println(nome + " = " + variaveis.get(nome));
    }

    void updateVars(Set<String> nomesVars) {
        // Inclui novas variáveis
        for (String nome : nomesVars)
            if (getVar(nome) == null)
                setVar(nome, 0.0);
        // Exclui variáveis obsoletas
        for (String nome : listVarsNames())
            if (!nomesVars.contains(nome))
                removeVar(nome);
    }

    public MapaVariaveis clone() throws CloneNotSupportedException {
        MapaVariaveis map = (MapaVariaveis) super.clone();
        map.variaveis = new HashMap<>();
        map.variaveis.putAll(variaveis);
        return map;
    }
}
