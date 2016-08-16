package lleme.corba.exemploAula.corbaClasses;

/**
 * Generated from IDL interface "PropertyFactory"
 * 
 * @author JacORB IDL compiler V 2.2.2, 1-Jun-2005
 */

public interface PropertyFactoryOperations {
	/* constants */
	/* operations */
	lleme.corba.exemploAula.corbaClasses.Property create(java.lang.String name,
			java.lang.String initial_value)
			throws lleme.corba.exemploAula.corbaClasses.PropertyAlreadyExists;

	void destroy(java.lang.String name)
			throws lleme.corba.exemploAula.corbaClasses.UnknownProperty;

	lleme.corba.exemploAula.corbaClasses.Property get(java.lang.String name);

	lleme.corba.exemploAula.corbaClasses.Property[] getAll();
}
