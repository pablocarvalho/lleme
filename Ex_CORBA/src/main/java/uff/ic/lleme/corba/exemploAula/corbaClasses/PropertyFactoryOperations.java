package uff.ic.lleme.corba.exemploAula.corbaClasses;

/**
 * Generated from IDL interface "PropertyFactory"
 * 
 * @author JacORB IDL compiler V 2.2.2, 1-Jun-2005
 */

public interface PropertyFactoryOperations {
	/* constants */
	/* operations */
	uff.ic.lleme.corba.exemploAula.corbaClasses.Property create(java.lang.String name,
			java.lang.String initial_value)
			throws uff.ic.lleme.corba.exemploAula.corbaClasses.PropertyAlreadyExists;

	void destroy(java.lang.String name)
			throws uff.ic.lleme.corba.exemploAula.corbaClasses.UnknownProperty;

	uff.ic.lleme.corba.exemploAula.corbaClasses.Property get(java.lang.String name);

	uff.ic.lleme.corba.exemploAula.corbaClasses.Property[] getAll();
}
