package lleme.corba.exemploAula.corbaClasses;

/**
 * Generated from IDL interface "PropertyFactory"
 * 
 * @author JacORB IDL compiler V 2.2.2, 1-Jun-2005
 */

public abstract class PropertyFactoryPOA extends org.omg.PortableServer.Servant
		implements org.omg.CORBA.portable.InvokeHandler,
		lleme.corba.exemploAula.corbaClasses.PropertyFactoryOperations {
	static private final java.util.Hashtable m_opsHash = new java.util.Hashtable();

	static {
		m_opsHash.put("getAll", new java.lang.Integer(0));
		m_opsHash.put("get", new java.lang.Integer(1));
		m_opsHash.put("create", new java.lang.Integer(2));
		m_opsHash.put("destroy", new java.lang.Integer(3));
	}

	private String[] ids = { "IDL:exemploAula/corbaClasses/PropertyFactory:1.0" };

	public lleme.corba.exemploAula.corbaClasses.PropertyFactory _this() {
		return lleme.corba.exemploAula.corbaClasses.PropertyFactoryHelper
				.narrow(_this_object());
	}

	public lleme.corba.exemploAula.corbaClasses.PropertyFactory _this(org.omg.CORBA.ORB orb) {
		return lleme.corba.exemploAula.corbaClasses.PropertyFactoryHelper
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
		case 0: // getAll
		{
			_out = handler.createReply();
			lleme.corba.exemploAula.corbaClasses.PropertySeqHelper.write(_out, getAll());
			break;
		}
		case 1: // get
		{
			java.lang.String _arg0 = _input.read_string();
			_out = handler.createReply();
			lleme.corba.exemploAula.corbaClasses.PropertyHelper.write(_out, get(_arg0));
			break;
		}
		case 2: // create
		{
			try {
				java.lang.String _arg0 = _input.read_string();
				java.lang.String _arg1 = _input.read_string();
				_out = handler.createReply();
				lleme.corba.exemploAula.corbaClasses.PropertyHelper.write(_out, create(
						_arg0, _arg1));
			} catch (lleme.corba.exemploAula.corbaClasses.PropertyAlreadyExists _ex0) {
				_out = handler.createExceptionReply();
				lleme.corba.exemploAula.corbaClasses.PropertyAlreadyExistsHelper.write(
						_out, _ex0);
			}
			break;
		}
		case 3: // destroy
		{
			try {
				java.lang.String _arg0 = _input.read_string();
				_out = handler.createReply();
				destroy(_arg0);
			} catch (lleme.corba.exemploAula.corbaClasses.UnknownProperty _ex0) {
				_out = handler.createExceptionReply();
				lleme.corba.exemploAula.corbaClasses.UnknownPropertyHelper
						.write(_out, _ex0);
			}
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
