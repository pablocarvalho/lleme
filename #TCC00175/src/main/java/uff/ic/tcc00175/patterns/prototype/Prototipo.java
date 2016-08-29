package uff.ic.tcc00175.patterns.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public abstract class Prototipo implements Nomeavel, Relacionado, Cloneable, Serializable, Identificavel {

    public static int tipoClonagem = 1;
    @Override
    // Shallow cloning
    public Prototipo clone() throws CloneNotSupportedException {
        switch (tipoClonagem) {
            case 1:
                return shallowCloning();
            case 2:
                return deepCloningCustomizada();
            case 3:
                return deepCloningPadrao();
            default:
                return shallowCloning();
        }
    }
    // Shallow cloning
    private Prototipo shallowCloning() throws CloneNotSupportedException {
        return (Prototipo) super.clone();
    }
    // Deep cloning 1
    protected abstract Prototipo deepCloningCustomizada() throws CloneNotSupportedException;
    // Deep cloning 1
    private Prototipo deepCloningPadrao() {
        Prototipo objeto = null;
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(this);
            oos.flush();

            InputStream is = new ByteArrayInputStream(os.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(is);
            objeto = (Prototipo) ois.readObject();
        } catch (IOException e) {
            e.toString();
        } catch (Exception e) {
            e.toString();
        }
        return objeto;
    }
}
