package lleme.corba.exemploAula.corbaClasses;

/**
 * Generated from IDL interface "Property"
 * 
 * @author JacORB IDL compiler V 2.2.2, 1-Jun-2005
 */

@SuppressWarnings("unchecked")
public abstract class PropertyPOA extends org.omg.PortableServer.Servant
		implements org.omg.CORBA.portable.InvokeHandler,
		lleme.corba.exemploAula.corbaClasses.PropertyOperations {
	static private final java.util.Hashtable m_opsHash = new java.util.Hashtable();

	static {
		m_opsHash.put("name", new java.lang.Integer(0));
		m_opsHash.put("set", new java.lang.Integer(1));
		m_opsHash.put("get", new java.lang.Integer(2));
	}

	private String[] ids = { "IDL:exemploAula/corbaClasses/Property:1.0" };

	public lleme.corba.exemploAula.corbaClasses.Property _this() {
		return lleme.corba.exemploAula.corbaClasses.PropertyHelper.narrow(_this_object());
	}

	public lleme.corba.exemploAula.corbaClasses.Property _this(org.omg.CORBA.ORB orb) {
		return lleme.corba.exemploAula.corbaClasses.PropertyHelper
				.narrow(_this_object(orb));
	}

	public org.omg.CORBA.portable.OutputStream _invoke(String method,
			org.omg.CORBA.portable.InputStream _input,
			org.omg.CORBA.portable.ResponseHandler handler)
			throws org.omg.CORBA.SystemException {
		org.omg.CORBA.portable.OutputStream _out = null;
		// do something
		// quick lookup of operation
		java.lang.Integer opsIndex = (java.lang.Integer) m_opsHash.get(method);
		if (null == opsIndex)
			throw new org.omg.CORBA.BAD_OPERATION(method + " not found");
		switch (opsIndex.intValue()) {
		case 0: // name
		{
			_out = handler.createReply();
			_out.write_string(name());
			break;
		}
		case 1: // set
		{
			java.lang.String _arg0 = _input.read_string();
			_out = handler.createReply();
			set(_arg0);
			break;
		}
		case 2: // get
		{
			_out = handler.createReply();
			_out.write_string(get());
			break;
		}
		}
		return _out;
	}

	public String[] _all_interfaces(org.omg.PortableServer.POA poa,
			byte[] obj_id) {
		return ids;
	}
}
