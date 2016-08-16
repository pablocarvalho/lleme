package lleme.corba.testes.jacORB.demo.grid.corbaObjects;

/**
 * Generated from IDL interface "MyServer"
 * 
 * @author JacORB IDL compiler V 2.2.2, 1-Jun-2005
 */

public class _MyServerStub extends org.omg.CORBA.portable.ObjectImpl implements
		lleme.corba.testes.jacORB.demo.grid.corbaObjects.MyServer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 794117802912399068L;

	private String[] ids = { "IDL:testes/jacORB/demo/grid/corbaObjects/MyServer:1.0" };

	public String[] _ids() {
		return ids;
	}

	public final static java.lang.Class _opsClass = lleme.corba.testes.jacORB.demo.grid.corbaObjects.MyServerOperations.class;

	public short height() {
		while (true) {
			if (!this._is_local()) {
				org.omg.CORBA.portable.InputStream _is = null;
				try {
					org.omg.CORBA.portable.OutputStream _os = _request(
							"_get_height", true);
					_is = _invoke(_os);
					return _is.read_short();
				} catch (org.omg.CORBA.portable.RemarshalException _rx) {
				} catch (org.omg.CORBA.portable.ApplicationException _ax) {
					String _id = _ax.getId();
					throw new RuntimeException("Unexpected exception " + _id);
				} finally {
					this._releaseReply(_is);
				}
			}

			else {
				org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke(
						"_get_height", _opsClass);
				if (_so == null)
					throw new org.omg.CORBA.UNKNOWN(
							"local invocations not supported!");
				MyServerOperations _localServant = (MyServerOperations) _so.servant;
				short _result;
				try {
					_result = _localServant.height();
				} finally {
					_servant_postinvoke(_so);
				}
				return _result;
			}
		}

	}

	public short opWithException()
			throws lleme.corba.testes.jacORB.demo.grid.corbaObjects.MyServerPackage.MyException {
		while (true) {
			if (!this._is_local()) {
				org.omg.CORBA.portable.InputStream _is = null;
				try {
					org.omg.CORBA.portable.OutputStream _os = _request(
							"opWithException", true);
					_is = _invoke(_os);
					short _result = _is.read_short();
					return _result;
				} catch (org.omg.CORBA.portable.RemarshalException _rx) {
				} catch (org.omg.CORBA.portable.ApplicationException _ax) {
					String _id = _ax.getId();
					if (_id
							.equals("IDL:testes/jacORB/demo/grid/corbaObjects/MyServer/MyException:1.0")) {
						throw lleme.corba.testes.jacORB.demo.grid.corbaObjects.MyServerPackage.MyExceptionHelper
								.read(_ax.getInputStream());
					}
					throw new RuntimeException("Unexpected exception " + _id);
				} finally {
					this._releaseReply(_is);
				}
			} else {
				org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke(
						"opWithException", _opsClass);
				if (_so == null)
					throw new org.omg.CORBA.UNKNOWN(
							"local invocations not supported!");
				MyServerOperations _localServant = (MyServerOperations) _so.servant;
				short _result;
				try {
					_result = _localServant.opWithException();
				} finally {
					_servant_postinvoke(_so);
				}
				return _result;
			}

		}

	}

	public void set(short n, short m, java.math.BigDecimal value) {
		while (true) {
			if (!this._is_local()) {
				org.omg.CORBA.portable.InputStream _is = null;
				try {
					org.omg.CORBA.portable.OutputStream _os = _request("set",
							true);
					_os.write_short(n);
					_os.write_short(m);
					lleme.corba.testes.jacORB.demo.grid.corbaObjects.MyServerPackage.fixedTHelper
							.write(_os, value);
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
				MyServerOperations _localServant = (MyServerOperations) _so.servant;
				try {
					_localServant.set(n, m, value);
				} finally {
					_servant_postinvoke(_so);
				}
				return;
			}

		}

	}

	public java.math.BigDecimal get(short n, short m) {
		while (true) {
			if (!this._is_local()) {
				org.omg.CORBA.portable.InputStream _is = null;
				try {
					org.omg.CORBA.portable.OutputStream _os = _request("get",
							true);
					_os.write_short(n);
					_os.write_short(m);
					_is = _invoke(_os);
					java.math.BigDecimal _result = lleme.corba.testes.jacORB.demo.grid.corbaObjects.MyServerPackage.fixedTHelper
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
				MyServerOperations _localServant = (MyServerOperations) _so.servant;
				java.math.BigDecimal _result;
				try {
					_result = _localServant.get(n, m);
				} finally {
					_servant_postinvoke(_so);
				}
				return _result;
			}

		}

	}

	public short width() {
		while (true) {
			if (!this._is_local()) {
				org.omg.CORBA.portable.InputStream _is = null;
				try {
					org.omg.CORBA.portable.OutputStream _os = _request(
							"_get_width", true);
					_is = _invoke(_os);
					return _is.read_short();
				} catch (org.omg.CORBA.portable.RemarshalException _rx) {
				} catch (org.omg.CORBA.portable.ApplicationException _ax) {
					String _id = _ax.getId();
					throw new RuntimeException("Unexpected exception " + _id);
				} finally {
					this._releaseReply(_is);
				}
			}

			else {
				org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke(
						"_get_width", _opsClass);
				if (_so == null)
					throw new org.omg.CORBA.UNKNOWN(
							"local invocations not supported!");
				MyServerOperations _localServant = (MyServerOperations) _so.servant;
				short _result;
				try {
					_result = _localServant.width();
				} finally {
					_servant_postinvoke(_so);
				}
				return _result;
			}
		}

	}

}
