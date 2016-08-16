package lleme.corba.exemploAula.corbaClasses;

/**
 * Generated from IDL definition of exception "UnknownProperty"
 * 
 * @author JacORB IDL compiler
 */

public final class UnknownPropertyHolder implements
		org.omg.CORBA.portable.Streamable {
	public lleme.corba.exemploAula.corbaClasses.UnknownProperty value;

	public UnknownPropertyHolder() {
	}

	public UnknownPropertyHolder(
			final lleme.corba.exemploAula.corbaClasses.UnknownProperty initial) {
		value = initial;
	}

	public org.omg.CORBA.TypeCode _type() {
		return lleme.corba.exemploAula.corbaClasses.UnknownPropertyHelper.type();
	}

	public void _read(final org.omg.CORBA.portable.InputStream _in) {
		value = lleme.corba.exemploAula.corbaClasses.UnknownPropertyHelper.read(_in);
	}

	public void _write(final org.omg.CORBA.portable.OutputStream _out) {
		lleme.corba.exemploAula.corbaClasses.UnknownPropertyHelper.write(_out, value);
	}
}
