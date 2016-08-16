package lleme.corba.testes.jacORB.demo.grid.corbaObjects.MyServerPackage;

public final class Helper {
	private static org.omg.CORBA.TypeCode _type = org.omg.CORBA.ORB.init()
			.create_fixed_tc((short) 5, (short) 2);

	public static void insert(org.omg.CORBA.Any any, java.math.BigDecimal s) {
		any.insert_fixed(s, type());
	}

	public static java.math.BigDecimal extract(org.omg.CORBA.Any any) {
		return any.extract_fixed();
	}

	public static org.omg.CORBA.TypeCode type() {
		return _type;
	}

	public static String id() {
		return "IDL::1.0";
	}

	@SuppressWarnings("deprecation")
	public static java.math.BigDecimal read(
			final org.omg.CORBA.portable.InputStream in) {
		java.math.BigDecimal result = in.read_fixed();
		return result.movePointLeft(2);
	}

	@SuppressWarnings("deprecation")
	public static void write(final org.omg.CORBA.portable.OutputStream out,
			final java.math.BigDecimal s) {
		if (s.scale() != 2)
			throw new org.omg.CORBA.DATA_CONVERSION();
		java.math.BigDecimal max = new java.math.BigDecimal("1000");
		if (s.compareTo(max) != -1)
			throw new org.omg.CORBA.DATA_CONVERSION();
		out.write_fixed(s);
	}
}
