package provas.s20152.p120152;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SimuladorInteracaoUsuario {

    private static Carnaval carnaval = null;
    private static final Set<Jurado> JURADOS = new HashSet<>();
    private static final Set<Escola> ESCOLAS = new HashSet<>();

    public static void simular() {
        Regra regra = new Regra1();
        regra.registrarQuesitoDesempate(Quesito.SAMBA_ENREDO);
        SistemaApuracao.regra = regra;
        try {
            // 1.0 - Registrar novo carnaval
            carnaval = registrarNovoCarnaval();
            // 1.3 - Apresentar janela com dados do novo carnaval
        } catch (Exception ex) {
            Logger.getLogger(SimuladorInteracaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            // 2.0 - Registrar novos Jurados
            Set<Jurado> jurados = registrarNovosJurados(carnaval);
            // 2.7 - Atualizar lista de jurados do carnaval
        } catch (Exception ex) {
            Logger.getLogger(SimuladorInteracaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            // 3.0 - Registrar novas Escolas
            Set<Escola> escolas = registrarNovasEscolas(carnaval);
            // 3.5 - Atualizar lista de jurados do carnaval
        } catch (Exception ex) {
            Logger.getLogger(SimuladorInteracaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            // 4.0 - Registrar nota
            Set<Nota> notas = registrarNotas(carnaval);
            // 4.x - Atualizar lista de jurados do carnaval
        } catch (Exception ex) {
            Logger.getLogger(SimuladorInteracaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Resultado> resultados = computarResultado(carnaval);
        for (Resultado resultado : resultados)
            System.out.println(resultado.escola.nome + " nota: " + resultado.nota + " desmpate: "
                + resultado.notaDesempate);
    }

    private static Carnaval registrarNovoCarnaval() throws Exception {
        // 1.1 - Usuario escolhe opcao de criar nova apuracao de carnaval
        // e o SistemaApuracao captura os dados necessários.
        // Dados necessários:
        int ano = 2016;
        // 1.2 - Registrar Carnaval
        return SistemaApuracao.registrarNovoCarnaval(ano);
    }

    private static Set<Jurado> registrarNovosJurados(Carnaval carnaval) throws Exception {
        {// 2.1 - Usuario escolhe opcao de incluir novo jurado e o SistemaApuracao
            // captura os dados necessários.
            // 1o Jurado - Dados necessários:
            String nome = "Luiz";
            Quesito quesito = Quesito.BATERIA;
            // 2.2 - Registrar Carnaval
            Jurado jurado = SistemaApuracao.registrarNovoJurado(carnaval, nome, quesito);
            JURADOS.add(jurado);
            // 2.3 - Usuario escolhe opcao de incluir novo jurado e o SistemaApuracao
            // captura os dados necessários.
            // 2o Jurado - Dados necessários:
            String nome2 = "Andre";
            Quesito quesito2 = Quesito.BATERIA;
            // 2.4 - Registrar Carnaval
            Jurado jurado2 = SistemaApuracao.registrarNovoJurado(carnaval, nome2, quesito2);
            JURADOS.add(jurado2);
            // 2.5 - Usuario escolhe opcao de incluir novo jurado e o SistemaApuracao
            // captura os dados necessários.
            // 3o Jurado - Dados necessários:
            String nome3 = "Fernanda";
            Quesito quesito3 = Quesito.BATERIA;
            // 2.6 - Registrar Carnaval
            Jurado jurado3 = SistemaApuracao.registrarNovoJurado(carnaval, nome3, quesito3);
            JURADOS.add(jurado3);
        }
        {
            String nome = "Jurado 4";
            Quesito quesito = Quesito.SAMBA_ENREDO;
            // 2.2 - Registrar Carnaval
            Jurado jurado = SistemaApuracao.registrarNovoJurado(carnaval, nome, quesito);
            JURADOS.add(jurado);
            // 2.3 - Usuario escolhe opcao de incluir novo jurado e o SistemaApuracao
            // captura os dados necessários.
            // 2o Jurado - Dados necessários:
            String nome2 = "Jurado 5";
            Quesito quesito2 = Quesito.SAMBA_ENREDO;
            // 2.4 - Registrar Carnaval
            Jurado jurado2 = SistemaApuracao.registrarNovoJurado(carnaval, nome2, quesito2);
            JURADOS.add(jurado2);
            // 2.5 - Usuario escolhe opcao de incluir novo jurado e o SistemaApuracao
            // captura os dados necessários.
            // 3o Jurado - Dados necessários:
            String nome3 = "Jurado 6";
            Quesito quesito3 = Quesito.SAMBA_ENREDO;
            // 2.6 - Registrar Carnaval
            Jurado jurado3 = SistemaApuracao.registrarNovoJurado(carnaval, nome3, quesito3);
            JURADOS.add(jurado3);
        }
        // ...
        return JURADOS;
    }

    private static Set<Escola> registrarNovasEscolas(Carnaval carnaval) throws Exception {
        // 3.1 - Usuario escolhe opcao de incluir nova escola e o SistemaApuracao
        // captura os dados necessários.
        // 1a Escola - Dados necessários:
        String nome = "Mangueira";
        // 3.2 - Registrar Escola
        Escola escola = SistemaApuracao.registrarNovaEscola(carnaval, nome);
        ESCOLAS.add(escola);
        // 3.3 - Usuario escolhe opcao de incluir nova escola e o SistemaApuracao
        // captura os dados necessários.
        // 1a Escola - Dados necessários:
        String nome2 = "Vila Isabel";
        // 3.4 - Registrar Escola
        Escola escola2 = SistemaApuracao.registrarNovaEscola(carnaval, nome2);
        ESCOLAS.add(escola2);
        // ...
        return ESCOLAS;
    }

    private static Set<Nota> registrarNotas(Carnaval carnaval) throws Exception {
        // 4.1 - Usuario escolhe seleciona uma escola na janela do carnaval, solicita
        // inclusao de nota i o sistema captura os dados necessários.
        // 1o Quesito - Dados necessários:
        {
            Quesito quesito = Quesito.BATERIA;
            {
                Escola escola = obterEscola("Mangueira");
                Jurado jurado = obetrJurado("Luiz");
                // 4.1.1 - Registrar nota
                SistemaApuracao.registrarNota(carnaval, escola, quesito, jurado, 9.8f);
                Jurado jurado2 = obetrJurado("Andre");
                // 4.1.2 - Registrar nota
                SistemaApuracao.registrarNota(carnaval, escola, quesito, jurado2, 8.0f);
                Jurado jurado3 = obetrJurado("Fernanda");
                // 4.1.3 - Registrar nota
                SistemaApuracao.registrarNota(carnaval, escola, quesito, jurado3, 10.0f);
            }
            {
                Escola escola = obterEscola("Vila Isabel");
                Jurado jurado = obetrJurado("Luiz");
                // 4.1.4 - Registrar nota
                SistemaApuracao.registrarNota(carnaval, escola, quesito, jurado, 9.5f);
                Jurado jurado2 = obetrJurado("Andre");
                // 4.1.5 - Registrar nota
                SistemaApuracao.registrarNota(carnaval, escola, quesito, jurado2, 10.0f);
                Jurado jurado3 = obetrJurado("Fernanda");
                // 4.1.6 - Registrar nota
                SistemaApuracao.registrarNota(carnaval, escola, quesito, jurado3, 10.0f);
            }
        }
        // 4.2 - Usuario escolhe seleciona uma escola na janela do carnaval, solicita
        // inclusao de nota i o sistema captura os dados necessários.
        // 1o Quesito - Dados necessários:
        {
            Quesito quesito = Quesito.SAMBA_ENREDO;
            {
                Escola escola = obterEscola("Mangueira");
                Jurado jurado = obetrJurado("Jurado 4");
                // 4.2.1 - Registrar nota
                SistemaApuracao.registrarNota(carnaval, escola, quesito, jurado, 9.8f);
                Jurado jurado2 = obetrJurado("Jurado 5");
                // 4.2.2 - Registrar nota
                SistemaApuracao.registrarNota(carnaval, escola, quesito, jurado2, 8.0f);
                Jurado jurado3 = obetrJurado("Jurado 6");
                // 4.2.3 - Registrar nota
                SistemaApuracao.registrarNota(carnaval, escola, quesito, jurado3, 10.0f);
            }
            {
                Escola escola = obterEscola("Vila Isabel");
                Jurado jurado = obetrJurado("Jurado 4");
                // 4.2.4 - Registrar nota
                SistemaApuracao.registrarNota(carnaval, escola, quesito, jurado, 9.5f);
                Jurado jurado2 = obetrJurado("Jurado 4");
                // 4.2.5 - Registrar nota
                SistemaApuracao.registrarNota(carnaval, escola, quesito, jurado2, 10.0f);
                Jurado jurado3 = obetrJurado("Jurado 4");
                // 4.2.6 - Registrar nota
                SistemaApuracao.registrarNota(carnaval, escola, quesito, jurado3, 10.0f);
            }
        }
        return null;
    }

    private static List<Resultado> computarResultado(Carnaval carnaval) {
        return SistemaApuracao.computarResulado(carnaval);
    }

    private static Jurado obetrJurado(String nome) {
        for (Jurado jurado : JURADOS)
            if (jurado.nome.equals(nome))
                return jurado;
        return null;
    }

    private static Escola obterEscola(String nome) {
        for (Escola escola : ESCOLAS)
            if (escola.nome.equals(nome))
                return escola;
        return null;
    }
}
