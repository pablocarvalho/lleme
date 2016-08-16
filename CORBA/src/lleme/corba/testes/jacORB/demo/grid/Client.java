package lleme.corba.testes.jacORB.demo.grid;

import java.io.BufferedReader;
import java.io.FileReader;

import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import lleme.corba.testes.jacORB.demo.grid.corbaObjects.MyServer;
import lleme.corba.testes.jacORB.demo.grid.corbaObjects.MyServerHelper;
import lleme.corba.testes.jacORB.demo.grid.corbaObjects.MyServerPackage.MyException;

public class Client {
	public static void main(String args[]) {
		args = new String[1];
		args[0] = "grid.ior";
		try {
			MyServer grid;

			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);

			if (args.length == 1) {
				// args[0] is an IOR-string
				BufferedReader in = new BufferedReader(new FileReader(args[0]));
				String ior = in.readLine();
				in.close();

				grid = MyServerHelper.narrow(orb.string_to_object(ior));
			} else {
				NamingContextExt nc = NamingContextExtHelper.narrow(orb
						.resolve_initial_references("NameService"));

				nc.to_name("grid.example");

				org.omg.CORBA.Object o = nc.resolve(nc.to_name("grid.example"));

				grid = MyServerHelper.narrow(o);
			}

			short x = grid.height();
			System.out.println("Height = " + x);

			short y = grid.width();
			System.out.println("Width = " + y);

			x -= 1;
			y -= 1;

			System.out.println("Old value at (" + x + "," + y + "): "
					+ grid.get(x, y));

			System.out.println("Setting (" + x + "," + y + ") to 470.11");

			grid.set(x, y, new java.math.BigDecimal("470.11"));

			System.out.println("New value at (" + x + "," + y + "): "
					+ grid.get(x, y));

			try {
				grid.opWithException();
			} catch (MyException ex) {
				System.out.println("MyException, reason: " + ex.why);
			}

			orb.shutdown(true);
			System.out.println("done. ");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
