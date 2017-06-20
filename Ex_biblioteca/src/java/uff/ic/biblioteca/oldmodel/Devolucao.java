package uff.ic.biblioteca.oldmodel;

import java.util.Calendar;
import java.util.Date;

public class Devolucao extends BusinessObject {

    private static final long serialVersionUID = -7263264191434633556L;

    public Devolucao() {
        this.data = Calendar.getInstance().getTime();
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        if (data != null) {
            this.data = data;
        }
    }
    private Date data = null;
}
