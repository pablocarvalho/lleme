package uff.ic.corba.exemploAula.corbaClasses;

/**
 * Generated from IDL definition of exception "UnknownProperty"
 * 
 * @author JacORB IDL compiler
 */

public final class UnknownPropertyHolder implements
		org.omg.CORBA.portable.Streamable {
	public uff.ic.corba.exemploAula.corbaClasses.UnknownProperty value;

	public UnknownPropertyHolder() {
	}

	public UnknownPropertyHolder(
			final uff.ic.corba.exemploAula.corbaClasses.UnknownProperty initial) {
		value = initial;
	}

	public org.omg.CORBA.TypeCode _type() {
		return uff.ic.corba.exemploAula.corbaClasses.UnknownPropertyHelper.type();
	}

	public void _read(final org.omg.CORBA.portable.InputStream _in) {
		value = uff.ic.corba.exemploAula.corbaClasses.UnknownPropertyHelper.read(_in);
	}

	public void _write(final org.omg.CORBA.portable.OutputStream _out) {
		uff.ic.corba.exemploAula.corbaClasses.UnknownPropertyHelper.write(_out, value);
	}
}
