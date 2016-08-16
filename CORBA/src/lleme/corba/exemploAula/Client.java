package lleme.corba.exemploAula;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import lleme.corba.exemploAula.corbaClasses.PropertyFactory;
import lleme.corba.exemploAula.corbaClasses.PropertyFactoryHelper;

public class Client {
	public static void main(String args[]) {
		args = new String[2];
		args[0] = "propertyServant.ior";
		args[1] = "propertyFactoryServant.ior";
		try {
			ORB orb = ORB.init(args, null);
			org.omg.CORBA.Object obj = null;
			// String ior = null;
			// BufferedReader in = new BufferedReader(new FileReader(args[1]));
			// ior = in.readLine();
			// in.close();
			// obj = orb.string_to_object(ior);
			NamingContextExt nc = NamingContextExtHelper.narrow(orb
					.resolve_initial_references("NameService"));
			obj = nc.resolve(nc.to_name("property.factory"));
			PropertyFactory prop2 = PropertyFactoryHelper.narrow(obj);
			if (prop2 == null) {
				System.err
						.println("stringfied object reference is of wrong type");
				System.exit(-1);
			}
			String propriedade = "corba";
			prop2.create(propriedade, "****************");
			try {
				System.out.println(propriedade + "= "
						+ prop2.get(propriedade).get());
				prop2.get(propriedade).set("444444444444444");
				System.out.println(propriedade + "= "
						+ prop2.get(propriedade).get());
			} catch (NullPointerException excp) {
				System.out.println("Propriedade \"" + propriedade
						+ "\" não existe");
			}
		} catch (Exception ex) {
			System.err.println(ex);
		}
	}
}
