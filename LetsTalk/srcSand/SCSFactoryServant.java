import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import org.omg.CORBA.ORB;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

/*import corbaObjects.scs.IComponent;
 import corbaObjects.scs.IComponentHelper;
 import corbaObjects.scs.IComponentPOA;
 import corbaObjects.scs.SCSPOA;*/

public class SCSFactoryServant extends SCSPOA {

	private HashMap components = null;

	public SCSFactoryServant() {
		components = new HashMap();
	}

	public IComponent getIComponent(String className, int instance_id)
			throws InternalError {

		String fullname = className + instance_id;

		IComponentPOA componentServant = null;
		IComponent component = null;
		if (components.get(fullname) == null) {
			try {
				Class iComponent = null;
				Class[] orbArgsClass = new Class[] { ORB.class };
				ORB orb = this._orb();
				Object[] orbArgs = new Object[] { orb };
				Constructor orbArgsConstructor = null;

				iComponent = Class.forName(className + "Servant");
				orbArgsConstructor = iComponent.getConstructor(orbArgsClass);
				componentServant = (IComponentPOA) orbArgsConstructor
						.newInstance(orbArgs);

				components.put(fullname, componentServant);

				/**
				 * Class classDefinition; classDefinition =
				 * Class.forName(className + "Servant"); componentServant =
				 * (IComponentPOA) classDefinition .newInstance();
				 * components.put(className, componentServant);
				 */
			} catch (ClassNotFoundException e) {
				throw new InternalError(e.getMessage());
			} catch (InstantiationException e) {
				throw new InternalError(e.getMessage());
			} catch (IllegalAccessException e) {
				throw new InternalError(e.getMessage());
			} catch (SecurityException e) {
				throw new InternalError(e.getMessage());
			} catch (NoSuchMethodException e) {
				throw new InternalError(e.getMessage());
			} catch (IllegalArgumentException e) {
				throw new InternalError(e.getMessage());
			} catch (InvocationTargetException e) {
				throw new InternalError(e.getMessage());
			} catch (Throwable e) {
				throw new InternalError(e.getMessage());
			}
		} else {
			componentServant = (IComponentPOA) components.get(fullname);
		}
		try {
			org.omg.CORBA.Object obj = null;
			obj = this._default_POA().servant_to_reference(componentServant);
			component = IComponentHelper.narrow(obj);
			// NamingContextExt nc = null;
			// nc = NamingContextExtHelper.narrow(this._orb()
			// .resolve_initial_references("TNameService"));
			// nc.rebind(nc.to_name("registry"), obj);
		} catch (ServantNotActive e) {
			throw new InternalError(e.getMessage());
		} catch (WrongPolicy e) {
			throw new InternalError(e.getMessage());
			// } catch (org.omg.CORBA.ORBPackage.InvalidName e) {
			// throw new InternalError(e.getMessage());
			// } catch (NotFound e) {
			// throw new InternalError(e.getMessage());
			// } catch (CannotProceed e) {
			// throw new InternalError(e.getMessage());
			// } catch (org.omg.CosNaming.NamingContextPackage.InvalidName e) {
			// throw new InternalError(e.getMessage());
		}
		return component;
	}

	public IComponent releaseIComponent(String className, int instance_id) {
		String fullname = className + instance_id;
		return (IComponent) components.remove(className);
	}
}
