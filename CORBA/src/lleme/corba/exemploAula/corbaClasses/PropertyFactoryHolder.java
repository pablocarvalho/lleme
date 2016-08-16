package lleme.corba.exemploAula.corbaClasses;

/**
 * Generated from IDL interface "PropertyFactory"
 * 
 * @author JacORB IDL compiler V 2.2.2, 1-Jun-2005
 */

public final class PropertyFactoryHolder implements
		org.omg.CORBA.portable.Streamable {
	public PropertyFactory value;

	public PropertyFactoryHolder() {
	}

	public PropertyFactoryHolder(final PropertyFactory initial) {
		value = initial;
	}

	public org.omg.CORBA.TypeCode _type() {
		return PropertyFactoryHelper.type();
	}

	public void _read(final org.omg.CORBA.portable.InputStream in) {
		value = PropertyFactoryHelper.read(in);
	}

	public void _write(final org.omg.CORBA.portable.OutputStream _out) {
		PropertyFactoryHelper.write(_out, value);
	}
}
