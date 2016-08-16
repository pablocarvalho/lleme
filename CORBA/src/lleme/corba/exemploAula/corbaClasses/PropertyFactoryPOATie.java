package lleme.corba.exemploAula.corbaClasses;

import org.omg.PortableServer.POA;

/**
 * Generated from IDL interface "PropertyFactory"
 * 
 * @author JacORB IDL compiler V 2.2.2, 1-Jun-2005
 */

public class PropertyFactoryPOATie extends PropertyFactoryPOA {
	private PropertyFactoryOperations _delegate;

	private POA _poa;

	public PropertyFactoryPOATie(PropertyFactoryOperations delegate) {
		_delegate = delegate;
	}

	public PropertyFactoryPOATie(PropertyFactoryOperations delegate, POA poa) {
		_delegate = delegate;
		_poa = poa;
	}

	public lleme.corba.exemploAula.corbaClasses.PropertyFactory _this() {
		return lleme.corba.exemploAula.corbaClasses.PropertyFactoryHelper
				.narrow(_this_object());
	}

	public lleme.corba.exemploAula.corbaClasses.PropertyFactory _this(org.omg.CORBA.ORB orb) {
		return lleme.corba.exemploAula.corbaClasses.PropertyFactoryHelper
				.narrow(_this_object(orb));
	}

	public PropertyFactoryOperations _delegate() {
		return _delegate;
	}

	public void _delegate(PropertyFactoryOperations delegate) {
		_delegate = delegate;
	}

	public POA _default_POA() {
		if (_poa != null) {
			return _poa;
		}
		return super._default_POA();
	}

	public lleme.corba.exemploAula.corbaClasses.Property[] getAll() {
		return _delegate.getAll();
	}

	public lleme.corba.exemploAula.corbaClasses.Property get(java.lang.String name) {
		return _delegate.get(name);
	}

	public lleme.corba.exemploAula.corbaClasses.Property create(java.lang.String name,
			java.lang.String initial_value)
			throws lleme.corba.exemploAula.corbaClasses.PropertyAlreadyExists {
		return _delegate.create(name, initial_value);
	}

	public void destroy(java.lang.String name)
			throws lleme.corba.exemploAula.corbaClasses.UnknownProperty {
		_delegate.destroy(name);
	}

}
