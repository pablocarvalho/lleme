package lleme.corba.exemploAula;

import java.util.HashMap;

import lleme.corba.exemploAula.corbaClasses.Property;
import lleme.corba.exemploAula.corbaClasses.PropertyAlreadyExists;
import lleme.corba.exemploAula.corbaClasses.PropertyFactoryPOA;
import lleme.corba.exemploAula.corbaClasses.PropertyHelper;
import lleme.corba.exemploAula.corbaClasses.UnknownProperty;

/**
 * @author Luiz André
 * @version 0
 */
public class PropertyFactoryServant extends PropertyFactoryPOA {

	// Luiz André
	// Contém tabela de propriedades criadas por PropertyFactory
	private HashMap properties = null;

	public PropertyFactoryServant() {
		properties = new HashMap();
	}

	@SuppressWarnings("unchecked")
	public Property create(String name, String initial_value)
			throws PropertyAlreadyExists {
		if (properties.get(name) != null)
			throw new PropertyAlreadyExists();
		try {
			return (Property) properties.put(name, PropertyHelper.narrow(this
					._default_POA().servant_to_reference(
							new PropertyServant(name, initial_value))));
		} catch (Exception e) {
			System.err.println(e);
			return null;
		}
	}

	public void destroy(String name) throws UnknownProperty {
		if (properties.get(name) == null)
			throw new UnknownProperty();
		properties.remove(name);
	}

	public Property get(String name) {
		return (Property) properties.get(name);
	}

	public Property[] getAll() {
		// return properties.getAll();
		return null;
	}

}
