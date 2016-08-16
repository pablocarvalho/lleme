package oo;

import java.util.ArrayList;
import java.util.List;

public class Generico {

    public static void main(String[] args) {
        List<String> ls = new ArrayList<String>();
        List<Object> lo = null;
        //lo = ls;// operação não permitida
        lo.add(new Object());
        String s = ls.get(0);
    }
}
