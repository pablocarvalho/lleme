package lleme.corba.exemploAula.corbaClasses;

/**
 * Generated from IDL interface "Property"
 * 
 * @author JacORB IDL compiler V 2.2.2, 1-Jun-2005
 */

public class _PropertyStub extends org.omg.CORBA.portable.ObjectImpl implements
		lleme.corba.exemploAula.corbaClasses.Property {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5231659918850186000L;

	private String[] ids = { "IDL:exemploAula/corbaClasses/Property:1.0" };

	public String[] _ids() {
		return ids;
	}

	public final static java.lang.Class _opsClass = lleme.corba.exemploAula.corbaClasses.PropertyOperations.class;

	public java.lang.String name() {
		while (true) {
			if (!this._is_local()) {
				org.omg.CORBA.portable.InputStream _is = null;
				try {
					org.omg.CORBA.portable.OutputStream _os = _request("name",
							true);
					_is = _invoke(_os);
					java.lang.String _result = _is.read_string();
					return _result;
				} catch (org.omg.CORBA.portable.RemarshalException _rx) {
				} catch (org.omg.CORBA.portable.ApplicationException _ax) {
					String _id = _ax.getId();
					throw new RuntimeException("Unexpected exception " + _id);
				} finally {
					this._releaseReply(_is);
				}
			} else {
				org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke(
						"name", _opsClass);
				if (_so == null)
					throw new org.omg.CORBA.UNKNOWN(
							"local invocations not supported!");
				PropertyOperations _localServant = (PropertyOperations) _so.servant;
				java.lang.String _result;
				try {
					_result = _localServant.name();
				} finally {
					_servant_postinvoke(_so);
				}
				return _result;
			}

		}

	}

	public void set(java.lang.String value) {
		while (true) {
			if (!this._is_local()) {
				org.omg.CORBA.portable.InputStream _is = null;
				try {
					org.omg.CORBA.portable.OutputStream _os = _request("set",
							true);
					_os.write_string(value);
					_is = _invoke(_os);
					return;
				} catch (org.omg.CORBA.portable.RemarshalException _rx) {
				} catch (org.omg.CORBA.portable.ApplicationException _ax) {
					String _id = _ax.getId();
					throw new RuntimeException("Unexpected exception " + _id);
				} finally {
					this._releaseReply(_is);
				}
			} else {
				org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke(
						"set", _opsClass);
				if (_so == null)
					throw new org.omg.CORBA.UNKNOWN(
							"local invocations not supported!");
				PropertyOperations _localServant = (PropertyOperations) _so.servant;
				try {
					_localServant.set(value);
				} finally {
					_servant_postinvoke(_so);
				}
				return;
			}

		}

	}

	public java.lang.String get() {
		while (true) {
			if (!this._is_local()) {
				org.omg.CORBA.portable.InputStream _is = null;
				try {
					org.omg.CORBA.portable.OutputStream _os = _request("get",
							true);
					_is = _invoke(_os);
					java.lang.String _result = _is.read_string();
					return _result;
				} catch (org.omg.CORBA.portable.RemarshalException _rx) {
				} catch (org.omg.CORBA.portable.ApplicationException _ax) {
					String _id = _ax.getId();
					throw new RuntimeException("Unexpected exception " + _id);
				} finally {
					this._releaseReply(_is);
				}
			} else {
				org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke(
						"get", _opsClass);
				if (_so == null)
					throw new org.omg.CORBA.UNKNOWN(
							"local invocations not supported!");
				PropertyOperations _localServant = (PropertyOperations) _so.servant;
				java.lang.String _result;
				try {
					_result = _localServant.get();
				} finally {
					_servant_postinvoke(_so);
				}
				return _result;
			}

		}

	}

}
