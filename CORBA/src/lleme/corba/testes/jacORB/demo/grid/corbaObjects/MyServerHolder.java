package lleme.corba.testes.jacORB.demo.grid.corbaObjects;

/**
 * Generated from IDL interface "MyServer"
 * 
 * @author JacORB IDL compiler V 2.2.2, 1-Jun-2005
 */

public final class MyServerHolder implements org.omg.CORBA.portable.Streamable {
	public MyServer value;

	public MyServerHolder() {
	}

	public MyServerHolder(final MyServer initial) {
		value = initial;
	}

	public org.omg.CORBA.TypeCode _type() {
		return MyServerHelper.type();
	}

	public void _read(final org.omg.CORBA.portable.InputStream in) {
		value = MyServerHelper.read(in);
	}

	public void _write(final org.omg.CORBA.portable.OutputStream _out) {
		MyServerHelper.write(_out, value);
	}
}
