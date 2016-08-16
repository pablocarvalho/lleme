package lleme.corba.testes.jacORB.demo.grid.corbaObjects;

/**
 * Generated from IDL interface "MyServer"
 * 
 * @author JacORB IDL compiler V 2.2.2, 1-Jun-2005
 */

public final class MyServerHelper {
	public static void insert(final org.omg.CORBA.Any any,
			final lleme.corba.testes.jacORB.demo.grid.corbaObjects.MyServer s) {
		any.insert_Object(s);
	}

	public static lleme.corba.testes.jacORB.demo.grid.corbaObjects.MyServer extract(
			final org.omg.CORBA.Any any) {
		return narrow(any.extract_Object());
	}

	public static org.omg.CORBA.TypeCode type() {
		return org.omg.CORBA.ORB.init().create_interface_tc(
				"IDL:testes/jacORB/demo/grid/corbaObjects/MyServer:1.0",
				"MyServer");
	}

	public static String id() {
		return "IDL:testes/jacORB/demo/grid/corbaObjects/MyServer:1.0";
	}

	public static MyServer read(final org.omg.CORBA.portable.InputStream in) {
		return narrow(in.read_Object());
	}

	public static void write(final org.omg.CORBA.portable.OutputStream _out,
			final lleme.corba.testes.jacORB.demo.grid.corbaObjects.MyServer s) {
		_out.write_Object(s);
	}

	public static lleme.corba.testes.jacORB.demo.grid.corbaObjects.MyServer narrow(
			final java.lang.Object obj) {
		if (obj instanceof lleme.corba.testes.jacORB.demo.grid.corbaObjects.MyServer) {
			return (lleme.corba.testes.jacORB.demo.grid.corbaObjects.MyServer) obj;
		} else if (obj instanceof org.omg.CORBA.Object) {
			return narrow((org.omg.CORBA.Object) obj);
		}
		throw new org.omg.CORBA.BAD_PARAM("Failed to narrow in helper");
	}

	public static lleme.corba.testes.jacORB.demo.grid.corbaObjects.MyServer narrow(
			final org.omg.CORBA.Object obj) {
		if (obj == null)
			return null;
		try {
			return (lleme.corba.testes.jacORB.demo.grid.corbaObjects.MyServer) obj;
		} catch (ClassCastException c) {
			if (obj
					._is_a("IDL:testes/jacORB/demo/grid/corbaObjects/MyServer:1.0")) {
				lleme.corba.testes.jacORB.demo.grid.corbaObjects._MyServerStub stub;
				stub = new lleme.corba.testes.jacORB.demo.grid.corbaObjects._MyServerStub();
				stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl) obj)
						._get_delegate());
				return stub;
			}
		}
		throw new org.omg.CORBA.BAD_PARAM("Narrow failed");
	}

	public static lleme.corba.testes.jacORB.demo.grid.corbaObjects.MyServer unchecked_narrow(
			final org.omg.CORBA.Object obj) {
		if (obj == null)
			return null;
		try {
			return (lleme.corba.testes.jacORB.demo.grid.corbaObjects.MyServer) obj;
		} catch (ClassCastException c) {
			lleme.corba.testes.jacORB.demo.grid.corbaObjects._MyServerStub stub;
			stub = new lleme.corba.testes.jacORB.demo.grid.corbaObjects._MyServerStub();
			stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl) obj)
					._get_delegate());
			return stub;
		}
	}
}
