package uff.ic.lleme.tic10002.trabalhos.s20171.kid_valdez;

import java.util.ArrayList;
import java.util.List;

public class HashJoin {

    public List<Vendas> hashJoin(List<Vendas> records1, List<Vendas> records2) {

        List<Vendas> result = new ArrayList<>();
        HashMapKid<Integer, List<Vendas>> map = new HashMapKid<>();

        for (Vendas record : records1) {
            //System.out.println("re: "+record[idx1]);
            List<Vendas> v = map.getOrDefault(record.codFial, new ArrayList<>());
            v.add(record);
            map.put(record.codFial, v);
        }

        for (Vendas record : records2) {
            List<Vendas> lst = map.get(record.codFial);
            if (lst != null)
                result.add(record);
        }

        return result;
    }
}
