package lleme.corba.testes.jacORB.demo.grid.corbaObjects.MyServerPackage;

/**
 * Generated from IDL definition of alias "fixedT"
 * 
 * @author JacORB IDL compiler
 */

public final class fixedTHolder implements org.omg.CORBA.portable.Streamable {
	public java.math.BigDecimal value;

	public fixedTHolder() {
	}

	public fixedTHolder(final java.math.BigDecimal initial) {
		value = initial;
	}

	public org.omg.CORBA.TypeCode _type() {
		return fixedTHelper.type();
	}

	public void _read(final org.omg.CORBA.portable.InputStream in) {
		value = fixedTHelper.read(in);
	}

	public void _write(final org.omg.CORBA.portable.OutputStream out) {
		fixedTHelper.write(out, value);
	}
}
