package uff.ic.lleme.tic10002.trabalhos._20171.carlosdantas;

/**
 *
 * @author Carlos
 */
public class TrabalhoED {

    public static void main(String[] args) 
    {
        Armazenamento base = new Armazenamento();
        base.insere(1, new MesAno("jan/2015"), 1, 10);
        base.insere(1, new MesAno("jan/2015"), 2, 156);
        base.insere(1, new MesAno("jan/2015"), 3, 1500);
        base.insere(1, new MesAno("fev/2015"), 1, 700);
        base.insere(1, new MesAno("fev/2015"), 2, 900);
        base.insere(1, new MesAno("fev/2015"), 3, 2000);
        base.insere(11, new MesAno("jan/2015"), 1, 10);
        base.insere(11, new MesAno("jan/2015"), 2, 156);
        base.insere(11, new MesAno("jan/2015"), 3, 1500);
        base.insere(11, new MesAno("fev/2015"), 1, 700);
        base.insere(11, new MesAno("fev/2015"), 2, 900);
        base.insere(11, new MesAno("fev/2015"), 3, 2000);
        base.insere(1, new MesAno("mar/2015"), 1, 1011);
        base.insere(1, new MesAno("mar/2015"), 2, 1566);
        base.insere(1, new MesAno("mar/2015"), 3, 1534);
        base.insere(1, new MesAno("abr/2015"), 1, 777);
        base.insere(1, new MesAno("abr/2015"), 2, 940);
        base.insere(1, new MesAno("abr/2015"), 3, 2000);
        base.insere(1, new MesAno("mai/2015"), 1, 1080);
        base.insere(1, new MesAno("mai/2015"), 2, 2100);
        base.insere(1, new MesAno("mai/2015"), 3, 15);
        base.insere(1, new MesAno("jun/2015"), 1, 720);
        base.insere(1, new MesAno("jun/2015"), 2, 430);
        base.insere(1, new MesAno("jun/2015"), 3, 760);
        
        System.out.println(base.totalVendido(1, 11, new MesAno("jun/2015"), new MesAno("dez/2015")));
        System.out.println(base.totalVendido(0, 0, new MesAno("dez/2014"), new MesAno("jan/2015")));
        System.out.println(base.totalVendido(5, 11, new MesAno(), new MesAno()));
    }
}
