package lleme.corba.exemploAula.corbaClasses;

/**
 * Generated from IDL interface "PropertyFactory"
 * 
 * @author JacORB IDL compiler V 2.2.2, 1-Jun-2005
 */

public final class PropertyFactoryHelper {
	public static void insert(final org.omg.CORBA.Any any,
			final lleme.corba.exemploAula.corbaClasses.PropertyFactory s) {
		any.insert_Object(s);
	}

	public static lleme.corba.exemploAula.corbaClasses.PropertyFactory extract(
			final org.omg.CORBA.Any any) {
		return narrow(any.extract_Object());
	}

	public static org.omg.CORBA.TypeCode type() {
		return org.omg.CORBA.ORB.init().create_interface_tc(
				"IDL:exemploAula/corbaClasses/PropertyFactory:1.0",
				"PropertyFactory");
	}

	public static String id() {
		return "IDL:exemploAula/corbaClasses/PropertyFactory:1.0";
	}

	public static PropertyFactory read(
			final org.omg.CORBA.portable.InputStream in) {
		return narrow(in.read_Object());
	}

	public static void write(final org.omg.CORBA.portable.OutputStream _out,
			final lleme.corba.exemploAula.corbaClasses.PropertyFactory s) {
		_out.write_Object(s);
	}

	public static lleme.corba.exemploAula.corbaClasses.PropertyFactory narrow(
			final java.lang.Object obj) {
		if (obj instanceof lleme.corba.exemploAula.corbaClasses.PropertyFactory) {
			return (lleme.corba.exemploAula.corbaClasses.PropertyFactory) obj;
		} else if (obj instanceof org.omg.CORBA.Object) {
			return narrow((org.omg.CORBA.Object) obj);
		}
		throw new org.omg.CORBA.BAD_PARAM("Failed to narrow in helper");
	}

	public static lleme.corba.exemploAula.corbaClasses.PropertyFactory narrow(
			final org.omg.CORBA.Object obj) {
		if (obj == null)
			return null;
		try {
			return (lleme.corba.exemploAula.corbaClasses.PropertyFactory) obj;
		} catch (ClassCastException c) {
			if (obj._is_a("IDL:exemploAula/corbaClasses/PropertyFactory:1.0")) {
				lleme.corba.exemploAula.corbaClasses._PropertyFactoryStub stub;
				stub = new lleme.corba.exemploAula.corbaClasses._PropertyFactoryStub();
				stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl) obj)
						._get_delegate());
				return stub;
			}
		}
		throw new org.omg.CORBA.BAD_PARAM("Narrow failed");
	}

	public static lleme.corba.exemploAula.corbaClasses.PropertyFactory unchecked_narrow(
			final org.omg.CORBA.Object obj) {
		if (obj == null)
			return null;
		try {
			return (lleme.corba.exemploAula.corbaClasses.PropertyFactory) obj;
		} catch (ClassCastException c) {
			lleme.corba.exemploAula.corbaClasses._PropertyFactoryStub stub;
			stub = new lleme.corba.exemploAula.corbaClasses._PropertyFactoryStub();
			stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl) obj)
					._get_delegate());
			return stub;
		}
	}
}
