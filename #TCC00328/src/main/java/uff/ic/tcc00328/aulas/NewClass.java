package uff.ic.tcc00328.aulas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class NewClass {

    public static void main(String[] args) {
        Map<String, Integer> s1 = new HashMap<String, Integer>();
        s1.put("k1", 12);
        s1.put("k2", 23);
        System.out.println("" + s1.get("k2"));
        for (String s : s1.keySet())
            System.out.println(s + " , " + s1.get(s));

    }
}
