package uff.ic.lleme.tcc00175.oo;

import java.util.ArrayList;
import java.util.List;

public class Generico {

    public static void main(String[] args) {
        List<String> ls = new ArrayList<String>();
        List<Object> lo = null;
        //lo = ls;// opera��o n�o permitida
        lo.add(new Object());
        String s = ls.get(0);
    }
}
