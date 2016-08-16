package lleme.corba.testes.jacORB.demo.grid.corbaObjects.MyServerPackage;

/**
 * Generated from IDL definition of exception "MyException"
 * 
 * @author JacORB IDL compiler
 */

public final class MyExceptionHelper {
	private static org.omg.CORBA.TypeCode _type = null;

	public static org.omg.CORBA.TypeCode type() {
		if (_type == null) {
			_type = org.omg.CORBA.ORB
					.init()
					.create_exception_tc(
							lleme.corba.testes.jacORB.demo.grid.corbaObjects.MyServerPackage.MyExceptionHelper
									.id(),
							"MyException",
							new org.omg.CORBA.StructMember[] { new org.omg.CORBA.StructMember(
									"why", org.omg.CORBA.ORB.init()
											.create_string_tc(0), null) });
		}
		return _type;
	}

	public static void insert(
			final org.omg.CORBA.Any any,
			final lleme.corba.testes.jacORB.demo.grid.corbaObjects.MyServerPackage.MyException s) {
		any.type(type());
		write(any.create_output_stream(), s);
	}

	public static lleme.corba.testes.jacORB.demo.grid.corbaObjects.MyServerPackage.MyException extract(
			final org.omg.CORBA.Any any) {
		return read(any.create_input_stream());
	}

	public static String id() {
		return "IDL:testes/jacORB/demo/grid/corbaObjects/MyServer/MyException:1.0";
	}

	public static lleme.corba.testes.jacORB.demo.grid.corbaObjects.MyServerPackage.MyException read(
			final org.omg.CORBA.portable.InputStream in) {
		lleme.corba.testes.jacORB.demo.grid.corbaObjects.MyServerPackage.MyException result = new lleme.corba.testes.jacORB.demo.grid.corbaObjects.MyServerPackage.MyException();
		if (!in.read_string().equals(id()))
			throw new org.omg.CORBA.MARSHAL("wrong id");
		result.why = in.read_string();
		return result;
	}

	public static void write(
			final org.omg.CORBA.portable.OutputStream out,
			final lleme.corba.testes.jacORB.demo.grid.corbaObjects.MyServerPackage.MyException s) {
		out.write_string(id());
		out.write_string(s.why);
	}
}
