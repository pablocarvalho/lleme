package oo.pessoa;

import java.text.SimpleDateFormat;

import java.util.Date;

public class MainPessoa {

    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        String nascimentoStr = "30/09/1989";
        Date nascimento = sdf.parse(nascimentoStr);

        String hojeStr = "20/03/2011";
        Date hoje = sdf.parse(hojeStr);

        Pessoa pessoa = new Pessoa(nascimento);
        Pessoa.nacionalidade = "Brasileiro";
        pessoa.altura = 1.75f;
        pessoa.peso = 74;
        System.out.println("idade = " + pessoa.idade(hoje) + " anos");
        System.out.println("imc = " + pessoa.imc());

        pessoa = new Pessoa();
        System.out.println(Pessoa.nacionalidade);
    }
}
