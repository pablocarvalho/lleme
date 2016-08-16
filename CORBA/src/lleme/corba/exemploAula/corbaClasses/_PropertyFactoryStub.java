package lleme.corba.exemploAula.corbaClasses;

/**
 * Generated from IDL interface "PropertyFactory"
 * 
 * @author JacORB IDL compiler V 2.2.2, 1-Jun-2005
 */

public class _PropertyFactoryStub extends org.omg.CORBA.portable.ObjectImpl
		implements lleme.corba.exemploAula.corbaClasses.PropertyFactory {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3167757628237527666L;

	private String[] ids = { "IDL:exemploAula/corbaClasses/PropertyFactory:1.0" };

	public String[] _ids() {
		return ids;
	}

	public final static java.lang.Class _opsClass = lleme.corba.exemploAula.corbaClasses.PropertyFactoryOperations.class;

	public lleme.corba.exemploAula.corbaClasses.Property[] getAll() {
		while (true) {
			if (!this._is_local()) {
				org.omg.CORBA.portable.InputStream _is = null;
				try {
					org.omg.CORBA.portable.OutputStream _os = _request(
							"getAll", true);
					_is = _invoke(_os);
					lleme.corba.exemploAula.corbaClasses.Property[] _result = lleme.corba.exemploAula.corbaClasses.PropertySeqHelper
							.read(_is);
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
						"getAll", _opsClass);
				if (_so == null)
					throw new org.omg.CORBA.UNKNOWN(
							"local invocations not supported!");
				PropertyFactoryOperations _localServant = (PropertyFactoryOperations) _so.servant;
				lleme.corba.exemploAula.corbaClasses.Property[] _result;
				try {
					_result = _localServant.getAll();
				} finally {
					_servant_postinvoke(_so);
				}
				return _result;
			}

		}

	}

	public lleme.corba.exemploAula.corbaClasses.Property get(java.lang.String name) {
		while (true) {
			if (!this._is_local()) {
				org.omg.CORBA.portable.InputStream _is = null;
				try {
					org.omg.CORBA.portable.OutputStream _os = _request("get",
							true);
					_os.write_string(name);
					_is = _invoke(_os);
					lleme.corba.exemploAula.corbaClasses.Property _result = lleme.corba.exemploAula.corbaClasses.PropertyHelper
							.read(_is);
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
				PropertyFactoryOperations _localServant = (PropertyFactoryOperations) _so.servant;
				lleme.corba.exemploAula.corbaClasses.Property _result;
				try {
					_result = _localServant.get(name);
				} finally {
					_servant_postinvoke(_so);
				}
				return _result;
			}

		}

	}

	public lleme.corba.exemploAula.corbaClasses.Property create(java.lang.String name,
			java.lang.String initial_value)
			throws lleme.corba.exemploAula.corbaClasses.PropertyAlreadyExists {
		while (true) {
			if (!this._is_local()) {
				org.omg.CORBA.portable.InputStream _is = null;
				try {
					org.omg.CORBA.portable.OutputStream _os = _request(
							"create", true);
					_os.write_string(name);
					_os.write_string(initial_value);
					_is = _invoke(_os);
					lleme.corba.exemploAula.corbaClasses.Property _result = lleme.corba.exemploAula.corbaClasses.PropertyHelper
							.read(_is);
					return _result;
				} catch (org.omg.CORBA.portable.RemarshalException _rx) {
				} catch (org.omg.CORBA.portable.ApplicationException _ax) {
					String _id = _ax.getId();
					if (_id
							.equals("IDL:exemploAula/corbaClasses/PropertyAlreadyExists:1.0")) {
						throw lleme.corba.exemploAula.corbaClasses.PropertyAlreadyExistsHelper
								.read(_ax.getInputStream());
					}
					throw new RuntimeException("Unexpected exception " + _id);
				} finally {
					this._releaseReply(_is);
				}
			} else {
				org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke(
						"create", _opsClass);
				if (_so == null)
					throw new org.omg.CORBA.UNKNOWN(
							"local invocations not supported!");
				PropertyFactoryOperations _localServant = (PropertyFactoryOperations) _so.servant;
				lleme.corba.exemploAula.corbaClasses.Property _result;
				try {
					_result = _localServant.create(name, initial_value);
				} finally {
					_servant_postinvoke(_so);
				}
				return _result;
			}

		}

	}

	public void destroy(java.lang.String name)
			throws lleme.corba.exemploAula.corbaClasses.UnknownProperty {
		while (true) {
			if (!this._is_local()) {
				org.omg.CORBA.portable.InputStream _is = null;
				try {
					org.omg.CORBA.portable.OutputStream _os = _request(
							"destroy", true);
					_os.write_string(name);
					_is = _invoke(_os);
					return;
				} catch (org.omg.CORBA.portable.RemarshalException _rx) {
				} catch (org.omg.CORBA.portable.ApplicationException _ax) {
					String _id = _ax.getId();
					if (_id
							.equals("IDL:exemploAula/corbaClasses/UnknownProperty:1.0")) {
						throw lleme.corba.exemploAula.corbaClasses.UnknownPropertyHelper
								.read(_ax.getInputStream());
					}
					throw new RuntimeException("Unexpected exception " + _id);
				} finally {
					this._releaseReply(_is);
				}
			} else {
				org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke(
						"destroy", _opsClass);
				if (_so == null)
					throw new org.omg.CORBA.UNKNOWN(
							"local invocations not supported!");
				PropertyFactoryOperations _localServant = (PropertyFactoryOperations) _so.servant;
				try {
					_localServant.destroy(name);
				} finally {
					_servant_postinvoke(_so);
				}
				return;
			}

		}

	}

}
