package lleme.corba.exemploAula.corbaClasses;

import org.omg.PortableServer.POA;

/**
 * Generated from IDL interface "Property"
 * 
 * @author JacORB IDL compiler V 2.2.2, 1-Jun-2005
 */

public class PropertyPOATie extends PropertyPOA {
	private PropertyOperations _delegate;

	private POA _poa;

	public PropertyPOATie(PropertyOperations delegate) {
		_delegate = delegate;
	}

	public PropertyPOATie(PropertyOperations delegate, POA poa) {
		_delegate = delegate;
		_poa = poa;
	}

	public lleme.corba.exemploAula.corbaClasses.Property _this() {
		return lleme.corba.exemploAula.corbaClasses.PropertyHelper.narrow(_this_object());
	}

	public lleme.corba.exemploAula.corbaClasses.Property _this(org.omg.CORBA.ORB orb) {
		return lleme.corba.exemploAula.corbaClasses.PropertyHelper
				.narrow(_this_object(orb));
	}

	public PropertyOperations _delegate() {
		return _delegate;
	}

	public void _delegate(PropertyOperations delegate) {
		_delegate = delegate;
	}

	public POA _default_POA() {
		if (_poa != null) {
			return _poa;
		}
		return super._default_POA();
	}

	public java.lang.String name() {
		return _delegate.name();
	}

	public void set(java.lang.String value) {
		_delegate.set(value);
	}

	public java.lang.String get() {
		return _delegate.get();
	}

}
