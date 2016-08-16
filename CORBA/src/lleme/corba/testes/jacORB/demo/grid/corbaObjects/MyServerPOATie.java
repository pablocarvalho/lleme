package lleme.corba.testes.jacORB.demo.grid.corbaObjects;

import org.omg.PortableServer.POA;

/**
 * Generated from IDL interface "MyServer"
 * 
 * @author JacORB IDL compiler V 2.2.2, 1-Jun-2005
 */

public class MyServerPOATie extends MyServerPOA {
	private MyServerOperations _delegate;

	private POA _poa;

	public MyServerPOATie(MyServerOperations delegate) {
		_delegate = delegate;
	}

	public MyServerPOATie(MyServerOperations delegate, POA poa) {
		_delegate = delegate;
		_poa = poa;
	}

	public lleme.corba.testes.jacORB.demo.grid.corbaObjects.MyServer _this() {
		return lleme.corba.testes.jacORB.demo.grid.corbaObjects.MyServerHelper
				.narrow(_this_object());
	}

	public lleme.corba.testes.jacORB.demo.grid.corbaObjects.MyServer _this(
			org.omg.CORBA.ORB orb) {
		return lleme.corba.testes.jacORB.demo.grid.corbaObjects.MyServerHelper
				.narrow(_this_object(orb));
	}

	public MyServerOperations _delegate() {
		return _delegate;
	}

	public void _delegate(MyServerOperations delegate) {
		_delegate = delegate;
	}

	public POA _default_POA() {
		if (_poa != null) {
			return _poa;
		}
		return super._default_POA();
	}

	public short height() {
		return _delegate.height();
	}

	public short opWithException()
			throws lleme.corba.testes.jacORB.demo.grid.corbaObjects.MyServerPackage.MyException {
		return _delegate.opWithException();
	}

	public void set(short n, short m, java.math.BigDecimal value) {
		_delegate.set(n, m, value);
	}

	public java.math.BigDecimal get(short n, short m) {
		return _delegate.get(n, m);
	}

	public short width() {
		return _delegate.width();
	}

}
