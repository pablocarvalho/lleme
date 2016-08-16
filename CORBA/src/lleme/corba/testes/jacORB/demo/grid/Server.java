package lleme.corba.testes.jacORB.demo.grid;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

public class Server {
	public static void main(String[] args) {
		args = new String[1];
		args[0] = "grid.ior";
		org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);
		try {
			org.omg.PortableServer.POA poa = org.omg.PortableServer.POAHelper
					.narrow(orb.resolve_initial_references("RootPOA"));

			poa.the_POAManager().activate();

			org.omg.CORBA.Object o = poa.servant_to_reference(new gridImpl());

			if (args.length == 1) {
				// write the object reference to args[0]

				PrintWriter ps = new PrintWriter(new FileOutputStream(new File(
						args[0])));
				ps.println(orb.object_to_string(o));
				ps.close();
			} else {
				// use the naming service

				NamingContextExt nc = NamingContextExtHelper.narrow(orb
						.resolve_initial_references("NameService"));
				nc.bind(nc.to_name("grid.example"), o);
			}

			orb.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
