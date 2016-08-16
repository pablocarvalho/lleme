package lleme.corba.exemploAula;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

public class Server {
	public static void main(String args[]) {
		args = new String[1];
		args[0] = "propertyServant.ior";
		try {
			ORB orb = ORB.init(args, null);
			POA poa = POAHelper.narrow(orb
					.resolve_initial_references("RootPOA"));
			poa.the_POAManager().activate();
			PropertyFactoryServant servant = new PropertyFactoryServant();
			org.omg.CORBA.Object obj = poa.servant_to_reference(servant);
			NamingContextExt nc = NamingContextExtHelper.narrow(orb
					.resolve_initial_references("NameService"));
			nc.bind(nc.to_name("property.factory"), obj);
			try {
				PrintWriter out = new PrintWriter(new BufferedWriter(
						new FileWriter("propertyFactoryServant.ior")));
				out.println(orb.object_to_string(obj));
				out.close();
			} catch (Exception e) {
				System.err.println(e);
			}
			orb.run();
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
