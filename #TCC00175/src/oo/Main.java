package oo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

    public static void main(String[] args) {
        Objeto objeto = null;
        try {
            FileOutputStream out;
            out = new FileOutputStream("Teste.dat", false);
            ObjectOutputStream s = new ObjectOutputStream(out);

            objeto = new Objeto();
            objeto.x = 23;
            objeto.y = 17;

            s.writeObject(objeto);
            s.flush();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        objeto = null;
        try {
            FileInputStream in;
            in = new FileInputStream("Teste.dat");
            ObjectInputStream s = new ObjectInputStream(in);
            objeto = (Objeto) s.readObject();
        } catch (FileNotFoundException e) {
            objeto = new Objeto();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(objeto.x);
        System.out.println(objeto.y);
    }
}
