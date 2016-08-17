package aulas.polimorfismo.listbox;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<Integer, String> col = new HashMap<>();
        col.put(1, "um");
        for (Integer key : col.keySet())
            System.out.println(col.get(key));

    }
}
