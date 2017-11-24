package uff.ic.lleme.tic10002.trabalhos.s20171.Raphael_Bernardino;

/**
 * @author bernardino
 */
public class Arvore {

    private NoFilial raiz = null;

    public boolean incluir(Integer id, String data, Double valor) {
        if (id == null || data == null || valor == null || data.equals(""))
            return false;

        Filial f = new Filial(id);
        f.getHashMap().adicionaValor(data, valor);

        if (raiz == null)
            raiz = new NoFilial(f);
        else
            incluir(raiz, f, data, valor);

        //System.out.println("[-] Valor final da Filial " + f.getCodigo() + ": " + f.getHashMap().busca(data));
        return true;
    }

    private Filial incluir(NoFilial n, Filial f, String d, Double v) {
        int r_comp = n.getFilial().compareTo(f);

        if (r_comp == 0) {
            //System.out.println("[-] Filial " + f.getCodigo() + " já existe na árvore.");
            n.getFilial().getHashMap().adicionaValor(d, v);
            return n.getFilial();
        } else if (r_comp < 0)
            if (n.getDir() == null) {
                //System.out.println("[-] Inserindo Filial " + f.getCodigo() + " na direita.");
                n.setDir(new NoFilial(f));
                return f;
            } else
                //System.out.println("[-] Percorrendo ramo da direita para inserir Filial " + f.getCodigo() + ".");
                return incluir(n.getDir(), f, d, v);
        else if (n.getEsq() == null)
            //System.out.println("[-] Inserindo " + f.toString() + " na esquerda.");
            n.setEsq(new NoFilial(f));
        else
            //System.out.println("[-] Percorrendo ramo da esquerda para inserir " + f.toString());
            return incluir(n.getEsq(), f, d, v);

        return null;
    }

    // total de vendas das filiais com códigos entre {ini} e {fim}
    public Double consulta1(Integer ini, Integer fim) {
        return execC1(raiz, ini, fim);
    }

    private Double execC1(NoFilial n, Integer min, Integer max) {
        Double total = 0.0;

        if (n == null)
            return 0.0;

        Filial f = n.getFilial();

        if (min.compareTo(f.getCodigo()) < 1 && f.getCodigo().compareTo(max) < 1)
            total += f.getHashMap().busca("tudo").getValor();

        if (n.getEsq() != null && n.getEsq().getFilial().getCodigo().compareTo(max) < 1)
            total += execC1(n.getEsq(), min, max);
        if (n.getDir() != null && n.getDir().getFilial().getCodigo().compareTo(max) < 1)
            total += execC1(n.getDir(), min, max);

        return total;
    }

    // total de vendas de todas as filiais com codigo entre {cini} e {cfim} entre os meses {mini} e {mfim}
    public Double consulta2(Integer cini, Integer cfim, String mini, String mfim) {
        return execC2(raiz, cini, cfim, mini, mfim);
    }

    private Double execC2(NoFilial n, Integer ci, Integer cf, String mi, String mf) {
        Double total = 0.0;

        if (n == null)
            return 0.0;

        Filial f = n.getFilial();

        if (ci.compareTo(f.getCodigo()) < 1 && f.getCodigo().compareTo(cf) < 1)
            for (String key : f.getHashMap().getChaves())
                if (mi.compareTo(key) < 1 && key.compareTo(mf) < 1)
                    total += f.getHashMap().busca(key).getValor();

        total += execC2(n.getEsq(), ci, cf, mi, mf);
        total += execC2(n.getDir(), ci, cf, mi, mf);

        return total;
    }

    // total de vendas de todas as filiais entre os meses {ini} e {fim}
    public Double consulta3(String ini, String fim) {
        return execC3(raiz, ini, fim);
    }

    private Double execC3(NoFilial n, String min, String max) {
        Double total = 0.0;

        if (n == null)
            return 0.0;

        Filial f = n.getFilial();

        for (String key : f.getHashMap().getChaves())
            if (min.compareTo(key) < 1 && key.compareTo(max) < 1)
                total += f.getHashMap().busca(key).getValor();

        total += execC3(n.getEsq(), min, max);
        total += execC3(n.getDir(), min, max);

        return total;
    }
}
