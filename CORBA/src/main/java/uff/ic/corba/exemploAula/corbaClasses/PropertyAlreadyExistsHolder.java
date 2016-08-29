package uff.ic.corba.exemploAula.corbaClasses;

/**
 * Generated from IDL definition of exception "PropertyAlreadyExists"
 * 
 * @author JacORB IDL compiler
 */

public final class PropertyAlreadyExistsHolder implements
		org.omg.CORBA.portable.Streamable {
	public uff.ic.corba.exemploAula.corbaClasses.PropertyAlreadyExists value;

	public PropertyAlreadyExistsHolder() {
	}

	public PropertyAlreadyExistsHolder(
			final uff.ic.corba.exemploAula.corbaClasses.PropertyAlreadyExists initial) {
		value = initial;
	}

	public org.omg.CORBA.TypeCode _type() {
		return uff.ic.corba.exemploAula.corbaClasses.PropertyAlreadyExistsHelper.type();
	}

	public void _read(final org.omg.CORBA.portable.InputStream _in) {
		value = uff.ic.corba.exemploAula.corbaClasses.PropertyAlreadyExistsHelper.read(_in);
	}

	public void _write(final org.omg.CORBA.portable.OutputStream _out) {
		uff.ic.corba.exemploAula.corbaClasses.PropertyAlreadyExistsHelper.write(_out, value);
	}
}
