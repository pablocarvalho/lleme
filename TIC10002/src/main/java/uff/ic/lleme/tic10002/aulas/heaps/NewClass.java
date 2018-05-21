package uff.ic.lleme.tic10002.aulas.heaps;

public class NewClass {

    public static void main(String[] args) {
        for (int i = 3; i < 200; i++) {
            int pai1 = (i - 1) / 2;
            int avo1 = (i - 3) / 4;

            int pai2 = (int) Math.floor((i - 1) / 2.0);
            int avo2 = (int) Math.floor((i - 3) / 4.0);

            if (pai1 != pai2 || avo1 != avo2)
                System.out.println(String.format("%d %d - %d %d", pai1, avo1, pai2, avo2));
        }
        System.out.println("fim");
    }
}
