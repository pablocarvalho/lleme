package lleme.corba.exemploAula.corbaClasses;

/**
 * Generated from IDL definition of exception "UnknownProperty"
 * 
 * @author JacORB IDL compiler
 */

public final class UnknownPropertyHelper {
	private static org.omg.CORBA.TypeCode _type = null;

	public static org.omg.CORBA.TypeCode type() {
		if (_type == null) {
			_type = org.omg.CORBA.ORB
					.init()
					.create_exception_tc(
							lleme.corba.exemploAula.corbaClasses.UnknownPropertyHelper.id(),
							"UnknownProperty",
							new org.omg.CORBA.StructMember[] { new org.omg.CORBA.StructMember(
									"name", org.omg.CORBA.ORB.init()
											.create_string_tc(0), null) });
		}
		return _type;
	}

	public static void insert(final org.omg.CORBA.Any any,
			final lleme.corba.exemploAula.corbaClasses.UnknownProperty s) {
		any.type(type());
		write(any.create_output_stream(), s);
	}

	public static lleme.corba.exemploAula.corbaClasses.UnknownProperty extract(
			final org.omg.CORBA.Any any) {
		return read(any.create_input_stream());
	}

	public static String id() {
		return "IDL:exemploAula/corbaClasses/UnknownProperty:1.0";
	}

	public static lleme.corba.exemploAula.corbaClasses.UnknownProperty read(
			final org.omg.CORBA.portable.InputStream in) {
		lleme.corba.exemploAula.corbaClasses.UnknownProperty result = new lleme.corba.exemploAula.corbaClasses.UnknownProperty();
		if (!in.read_string().equals(id()))
			throw new org.omg.CORBA.MARSHAL("wrong id");
		result.name = in.read_string();
		return result;
	}

	public static void write(final org.omg.CORBA.portable.OutputStream out,
			final lleme.corba.exemploAula.corbaClasses.UnknownProperty s) {
		out.write_string(id());
		out.write_string(s.name);
	}
}
