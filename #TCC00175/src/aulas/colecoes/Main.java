package aulas.colecoes;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Day day = Day.SEGUNDA;
        System.out.println(day.compareTo(Day.TERCA));

        for (Day day2 : Day.values())
            System.out.println(day2);

        Set<Day> myEnum = EnumSet.allOf(Day.class);

        for (Day myday : myEnum)
            System.out.println(myday.toString());

        List<String> ls = new ArrayList<String>();

        Iterator<String> iter = ls.iterator();
        String texto;
        while (iter.hasNext())
            texto = iter.next();

        ls.add("string");
        List<?> lo = ls; // se fosse permitido
        Object o = lo.get(0);
        System.out.println(o.toString());
        //lo.add(new Object());
        String s = ls.get(0);

        Planet planet = Planet.MARS;
        System.out.println(planet.surfaceWeight(72));

    }
}
