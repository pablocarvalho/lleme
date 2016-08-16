package lleme.corba.exemploAula.corbaClasses;

/**
 * Generated from IDL interface "Property"
 * 
 * @author JacORB IDL compiler V 2.2.2, 1-Jun-2005
 */

public final class PropertyHolder implements org.omg.CORBA.portable.Streamable {
	public Property value;

	public PropertyHolder() {
	}

	public PropertyHolder(final Property initial) {
		value = initial;
	}

	public org.omg.CORBA.TypeCode _type() {
		return PropertyHelper.type();
	}

	public void _read(final org.omg.CORBA.portable.InputStream in) {
		value = PropertyHelper.read(in);
	}

	public void _write(final org.omg.CORBA.portable.OutputStream _out) {
		PropertyHelper.write(_out, value);
	}
}
