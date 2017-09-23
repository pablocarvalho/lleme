package uff.ic.lleme.tic10002.prova.s20171.revisoes;

public class P220171Q1_Kid {

    public static class No {

        public String dato = null;
        public No direita = null;
        public No esquerda = null;

        public No(String dato) {
            this.dato = dato;
        }

    }

    static Pila<String> ope = new Pila<>();
    static Pila<Integer> num = new Pila<>();

    static boolean isNum(String ope) {
        return !(ope.equals("+") || ope.equals("-") || ope.equals("*") || ope.equals("/"));
    }

    static int fazerOpera(int a, int b, String oper) { // não é isso que estava na sua prova
        if (oper.equals("+"))
            return b + a;
        else if (oper.equals("-"))
            return b - a;
        else if (oper.equals("*"))
            return b * a;
        else if (oper.equals("/"))
            return b / a;
        else
            return 0;
    }

    static int getResult() {
        return num.pop(); // O resultado sempre fica na pilha de números
    }

    public static int calcu(No no) {
        if (no != null) {
            calcu(no.direita);
            calcu(no.esquerda);
            if (isNum(no.dato))
                num.push(Integer.parseInt(no.dato));
            else // operador activa operacao
            {
                ope.push(no.dato);
                if (num.size() > 1) {
                    int a = num.pop();
                    int b = num.pop();
                    int result = fazerOpera(a, b, ope.pop());
                    num.push(result);
                }
                if (ope.size() == 0)
                    return num.pop();
            }
        }
        return 0; // tive que colocar essa instruçào para poder compilar seu código
    }

    public static void main(String[] args) {
        No dif = new No("-");
        No prod1 = new No("*");
        No prod2 = new No("*");
        No soma = new No("+");
        No a = new No("1");
        No b = new No("2");
        No c = new No("4");
        No d = new No("7");
        No e = new No("3");

        dif.direita = prod1;
        prod1.direita = a;
        prod1.esquerda = b;
        dif.esquerda = prod2;
        prod2.direita = soma;
        soma.direita = c;
        soma.esquerda = d;
        prod2.esquerda = e;

        calcu(dif);
        System.out.println("resultado do arvore: " + getResult());
    }
}
