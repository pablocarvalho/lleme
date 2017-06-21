package uff.ic.lleme.tic10002.trabalhos._20171.danielbastos;

import static java.lang.Integer.parseInt;
import java.util.Date;
import org.joda.time.DateTime;

public class TesteMe {

    static MyLinkedList vendas = new MyLinkedList();
    static int currentMonth = 0;
    static int currentYear = 0;

    public static void totalVendas(int fi, int fj) {
        /*
            Total de vendas das filiais entre 10 e 20:
         */
        HashTable h = new HashTable();

        for (int i = 0; i < vendas.getSize(); ++i) {
            Venda v = (Venda) vendas.get(i);
            Object x = h.get(v.filial);
            if (x == null)
                h.set(v.filial, v.total_vendido);
            else
                h.set(v.filial, (double) x + v.total_vendido);
        }

        double total = 0;
        for (int i = fi; i <= fj; ++i) {
            Object x = h.get(i);

            if (x != null)
                total = total + (double) x;
        }

        System.out.format("Total de vendas das filiais %d a %d: %.2f\n",
                fi, fj, total);
    }

    public static void showVendas() {
        for (int i = 0; i < vendas.getSize(); ++i)
            System.out.println(vendas.get(i));
    }

    public static void makeVendas2() {
        /* vendedor 1 */
        vendas.add(new Venda(180, 2017, 5, 1, 1000.0));
        vendas.add(new Venda(180, 2017, 6, 1, 1000.0));
        vendas.add(new Venda(180, 2017, 7, 1, 1000.0));
        vendas.add(new Venda(180, 2017, 8, 1, 1000.0));

        /* 2: metade do talento do primeiro */
        vendas.add(new Venda(190, 2017, 5, 2, 1000 / 2));
        vendas.add(new Venda(190, 2017, 6, 2, 1000 / 2));
        vendas.add(new Venda(190, 2017, 7, 2, 1000 / 2));
        vendas.add(new Venda(190, 2017, 8, 2, 1000 / 2));

        /* 3: 3 vezes mais talentoso que o primeiro */
        vendas.add(new Venda(200, 2017, 5, 3, 1000 * 3));
        vendas.add(new Venda(200, 2017, 6, 3, 1000.0 * 3));
        vendas.add(new Venda(200, 2017, 7, 3, 1000.0 * 3));
        vendas.add(new Venda(200, 2017, 8, 3, 1000 * 3));

        /* 4: 2 vezes mais talentoso que o primeiro */
        vendas.add(new Venda(210, 2017, 5, 4, 1000 * 2));
        vendas.add(new Venda(210, 2017, 6, 4, 1000 * 2));
        vendas.add(new Venda(210, 2017, 7, 4, 1000 * 2));
        vendas.add(new Venda(210, 2017, 8, 4, 1000 * 2));
    }

    public static void makeVendas() {
        /* vendedor 1 */
        vendas.add(new Venda(180, 2017, 5, 1, 1506.60));
        vendas.add(new Venda(180, 2017, 6, 1, 1000.0));
        vendas.add(new Venda(180, 2017, 7, 1, 1000.0));
        vendas.add(new Venda(180, 2017, 8, 1, 2569.40));

        /* 2: metade do talento do primeiro */
        vendas.add(new Venda(190, 2017, 5, 2, 1506.60 / 2));
        vendas.add(new Venda(190, 2017, 6, 2, 1000.0 / 2));
        vendas.add(new Venda(190, 2017, 7, 2, 1000.0 / 2));
        vendas.add(new Venda(190, 2017, 8, 2, 2569.40 / 2));

        /* 3: 3 vezes mais talentoso que o primeiro */
        vendas.add(new Venda(200, 2017, 5, 3, 1506.60 * 3));
        vendas.add(new Venda(200, 2017, 6, 3, 1000.0 * 3));
        vendas.add(new Venda(200, 2017, 7, 3, 1000.0 * 3));
        vendas.add(new Venda(200, 2017, 8, 3, 2569.40 * 3));

        /* 4: 2 vezes mais talentoso que o primeiro */
        vendas.add(new Venda(210, 2017, 5, 4, 1506.60 * 2));
        vendas.add(new Venda(210, 2017, 6, 4, 1000.0 * 2));
        vendas.add(new Venda(210, 2017, 7, 4, 1000.0 * 2));
        vendas.add(new Venda(210, 2017, 8, 4, 2569.40 * 2));
    }

    private void makeDb2() {
        /*
           Simula os dados para o trabalho.
           Sintaxe:
           Venda(filial, ano, mês, cod_vendedor, total_vendido)
         */

 /* vendedor 1 */
//        db.add(new Venda(18, 2017, 1, 1, 100));
//        db.add(new Venda(18, 2017, 2, 1, 100));
//        db.add(new Venda(18, 2017, 3, 1, 100));
//
//        /* 2: metade do talento do primeiro */
//        db.add(new Venda(1008, 2107, 1, 2, 200));
//        db.add(new Venda(1008, 2107, 2, 2, 200));
//        db.add(new Venda(1008, 2017, 3, 2, 200));
//
//        /* 3: 3 vezes mais talentoso que o primeiro */
//        db.add(new Venda(5008, 2017, 1, 3, 300));
//        db.add(new Venda(5008, 2017, 2, 3, 300));
//        db.add(new Venda(5008, 2017, 3, 3, 300));
//
//        /* 4: 2 vezes mais talentoso que o primeiro */
//        db.add(new Venda(9008, 2017, 1, 4, 400));
//        db.add(new Venda(9008, 2017, 2, 4, 400));
//        db.add(new Venda(9008, 2017, 3, 4, 400));
    }

    public static void testHashTable() {
        HashTable ht = new HashTable();
        ht.set(1, 15);
        ht.set(2, 90);
        ht.set(15, 15020);
        ht.set(656, 654987);

        System.out.println("Table[1]:" + ht.get(1));
        System.out.println("Table[2]:" + ht.get(2));
        System.out.println("Table[15]:" + ht.get(15));
        System.out.println("Table[656]:" + ht.get(656));
    }

    public static void testLinkedList() {
        MyLinkedList my = new MyLinkedList();
        my.add(1);
        my.add(2);
        my.add(3);
        my.add(4);
        my.add(5);

        System.out.println("List: " + my);
        System.out.println("size: " + my.getSize());
        System.out.println("3rd:" + my.get(3));
        System.out.println("remove 2nd:" + my.remove(2));
        System.out.println("3rd:" + my.get(3));
        System.out.println("size:" + my.getSize());
        System.out.println("List:" + my);
    }

    public static void testAVLTree() {
        AVLTree t1 = new AVLTree();
        t1.insert(1);
        t1.insert(2);
        t1.insert(3);

        System.out.println("in order: ");
        t1.inorder(" ");

        System.out.println("\npre-order: ");
        t1.preorder(" ");

        System.out.println("\npost-order: ");
        t1.postorder(" ");
        System.out.println("");
    }

    public static void testAVLTreeVendas() {
        makeVendas();

        AVLTree t2 = new AVLTree();
        for (int i = 0; i < 4; ++i) {
            Venda v = (Venda) vendas.get(i);
            t2.insert(v);
        }

        t2.inorder("\n");
    }

    public static void testAVLTreeMonth() {
        makeVendas();

        AVLTree t2 = new AVLTree();
        for (int i = 0; i < vendas.getSize(); ++i) {
            Venda v = (Venda) vendas.get(i);
            t2.insert(new Montante(v.ano_mes, v.total_vendido));
        }

        t2.inorder("\n");
    }

    public static HashTable makeHashFiliais(int fi, int fj) {
        makeVendas();

        HashTable ht = new HashTable();
        for (int i = 0; i < vendas.getSize(); ++i) {
            Venda v = (Venda) vendas.get(i);

            Filial x = (Filial) ht.get(v.filial);
            if (x == null) {
                x = new Filial(v.filial);
                ht.set(v.filial, x);
            }

            x.tree.insert(new Montante(v.ano_mes, v.total_vendido));
            //x.total += v.total_vendido;
            System.out.println("Filial:" + v.filial + "@" + v.ano_mes);
        }

        /*
        for (int i = fi; i <= fj; ++i) {
            Filial x = (Filial) ht.get(i);
            System.out.println(x);
        }
         */
        return ht;
    }

    public static double totalFiliaisPeriodo(HashTable ht, int fi, int fj, int user_y1, int user_m1, int user_y2, int user_m2) {
        double ret = 0;

        System.out.format("Período: %d a %d\n", user_y1 * 100 + user_m1, user_y2 * 100 + user_m2);
        for (int fx = fi; fx <= fj; ++fx)
            for (int m = user_m1, y1 = user_y1, i = user_y1 * 100 + user_m1; i <= user_y2 * 100 + user_m2; ++m, i = y1 * 100 + m) {
                System.out.println("Filial: " + fx + " mês: " + m);
                /*
                pra cada mês do intervalo mês1/ano1 até mês2/ano2 ...
                encontre o montante do mês e acumule-o em ret.
                 */
                System.out.println(fx + "::" + i);

                Filial f = (Filial) ht.get(fx);
                System.out.println("Filial: " + f);
                if (f != null) {
                    //System.out.println("Filial: " + f);
                    Object x = f.tree.get(i);
                    //System.out.println("Montante: " + x);

                    if (x != null) {
                        Montante mcurrent = (Montante) x;
                        ret += mcurrent.total;
                        //System.out.println(fx + "::" + i + "::" + f.tree);
                        //System.out.println(mcurrent.total);
                    }
                }
                if (m == user_m2)
                    ++y1;
                //if (y1 > user_y2) {
                //    y1 = user_y1;
                //}
            }
        return ret;
    }

    public static HashTable makeHashFiliais2() {
        HashTable ht = new HashTable();
        for (int i = 0; i < vendas.getSize(); ++i) {
            Venda v = (Venda) vendas.get(i);

            Filial x = (Filial) ht.get(v.filial);
            if (x == null) {
                x = new Filial(v.filial);
                ht.set(v.filial, x);
            }

            x.tree.insert(new Montante(v.ano_mes, v.total_vendido));
            //x.total += v.total_vendido;
        }

        return ht;
    }

    public static void fixMakeHashFiliais() {
        //makeVendas();
        HashTable h = makeHashFiliais2();

        Filial f = (Filial) h.get(190);
        f.tree.preorder(" --> ");
        System.out.println("");
        System.out.println(f.tree.get(201705));
        //System.out.println(f.tree.get(201706));
        //System.out.println(f.tree.get(201707));
        //System.out.println(f.tree.get(201708));
    }

    public static void testJodaTime() {
        java.util.Date juDate = new Date();
        DateTime dt = new DateTime(juDate);
        System.out.println(dt);
        System.out.println(dt.getMonthOfYear());
        System.out.println(dt.getYear());

        DateTime dt2 = new DateTime("2017-01");
        System.out.println(dt2);
        System.out.println(dt2.plusMonths(1));

        for (DateTime d = new DateTime("2017-01"); d.isBefore(new DateTime("2018-06")); d = d.plusMonths(1))
            System.out.println(d);

        //String s = dt2.getYear() + "" + dt2.getMonthOfYear();
    }

    public static int getKeyFromDate(DateTime d) {
        String ret = null;
        if (d.getMonthOfYear() < 10)
            ret = d.getYear() + "0" + d.getMonthOfYear();
        else
            ret = d.getYear() + "" + d.getMonthOfYear();
        return parseInt(ret);
    }

    public static double totalFiliaisPeriodoJoda(HashTable ht, int fi, int fj, String d1, String d2) {
        double ret = 0;

        System.out.format("Período: %s a %s\n", d1, d2);
        for (int fx = fi; fx <= fj; ++fx)
            //System.out.println("Filial: " + fx);
            for (DateTime d = new DateTime(d1); d.isBefore(new DateTime(d2).plusSeconds(1)); d = d.plusMonths(1)) {
                //System.out.println("Filial: " + fx + " mês: " + getKeyFromDate(d));
                /*
                pra cada mês do intervalo mês1/ano1 até mês2/ano2 ...
                encontre o montante do mês e acumule-o em ret.
                 */
                //System.out.println(fx + "::" + getKeyFromDate(d));

                Filial f = (Filial) ht.get(fx);
                if (f != null) {
                    //System.out.println("Filial: " + f.key + "::" + f.tree);
                    Object x = f.tree.get(getKeyFromDate(d));
                    //System.out.println("Montante: " + x);

                    if (x != null) {
                        Montante mcurrent = (Montante) x;
                        ret += mcurrent.total;
                        //System.out.println(fx + "::" + getKeyFromDate(d) + "::" + f.tree);
                        //System.out.println(mcurrent.total);
                    }
                }
            }
        return ret;
    }

    public static void main(String[] args) {

        //testHashTable();
        //makeVendas();
        //showVendas();
        //totalVendas(10, 10);
        //totalVendas(18, 18);
        //totalVendas(19, 19);
        //totalVendas(18, 19);
        //totalVendas(19, 20);
        //totalVendas(21, 21);
        //testAVLTree();
        //testAVLTreeVendas();
        //makeHashFiliais2();
        //System.out.println(totalFiliaisPeriodo(18, 21, 2017, 10, 2017, 11));
        //System.out.println(totalFiliaisPeriodo(18, 21, 2017, 5, 2017, 8));
        //System.out.println(totalFiliaisPeriodo(makeHashFiliais2(), 170, 210, 2017, 5, 2019, 6));
        //fixMakeHashFiliais();
        //testJodaTime();
        //makeVendas2();
        //System.out.println(totalFiliaisPeriodoJoda(makeHashFiliais2(), 170, 210, "2017-01", "2019-06"));
        //System.out.println(totalFiliaisPeriodoJoda(makeHashFiliais2(), 180, 210, "2017-05", "2017-05"));
        //System.out.println(totalFiliaisPeriodoJoda(makeHashFiliais2(), 180, 210, "2017-07", "2017-08"));
    }

}
