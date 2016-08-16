package lleme.corba.exemploAula.corbaClasses;

/**
 * Generated from IDL definition of exception "PropertyAlreadyExists"
 * 
 * @author JacORB IDL compiler
 */

public final class PropertyAlreadyExistsHelper {
	private static org.omg.CORBA.TypeCode _type = null;

	public static org.omg.CORBA.TypeCode type() {
		if (_type == null) {
			_type = org.omg.CORBA.ORB
					.init()
					.create_exception_tc(
							lleme.corba.exemploAula.corbaClasses.PropertyAlreadyExistsHelper
									.id(),
							"PropertyAlreadyExists",
							new org.omg.CORBA.StructMember[] { new org.omg.CORBA.StructMember(
									"prop",
									org.omg.CORBA.ORB
											.init()
											.create_interface_tc(
													"IDL:exemploAula/corbaClasses/Property:1.0",
													"Property"), null) });
		}
		return _type;
	}

	public static void insert(final org.omg.CORBA.Any any,
			final lleme.corba.exemploAula.corbaClasses.PropertyAlreadyExists s) {
		any.type(type());
		write(any.create_output_stream(), s);
	}

	public static lleme.corba.exemploAula.corbaClasses.PropertyAlreadyExists extract(
			final org.omg.CORBA.Any any) {
		return read(any.create_input_stream());
	}

	public static String id() {
		return "IDL:exemploAula/corbaClasses/PropertyAlreadyExists:1.0";
	}

	public static lleme.corba.exemploAula.corbaClasses.PropertyAlreadyExists read(
			final org.omg.CORBA.portable.InputStream in) {
		lleme.corba.exemploAula.corbaClasses.PropertyAlreadyExists result = new lleme.corba.exemploAula.corbaClasses.PropertyAlreadyExists();
		if (!in.read_string().equals(id()))
			throw new org.omg.CORBA.MARSHAL("wrong id");
		result.prop = lleme.corba.exemploAula.corbaClasses.PropertyHelper.read(in);
		return result;
	}

	public static void write(final org.omg.CORBA.portable.OutputStream out,
			final lleme.corba.exemploAula.corbaClasses.PropertyAlreadyExists s) {
		out.write_string(id());
		lleme.corba.exemploAula.corbaClasses.PropertyHelper.write(out, s.prop);
	}
}
