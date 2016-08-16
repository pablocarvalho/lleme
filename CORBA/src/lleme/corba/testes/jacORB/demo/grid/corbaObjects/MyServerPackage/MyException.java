package lleme.corba.testes.jacORB.demo.grid.corbaObjects.MyServerPackage;

/**
 * Generated from IDL definition of exception "MyException"
 * 
 * @author JacORB IDL compiler
 */

public final class MyException extends org.omg.CORBA.UserException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9215013982164895157L;

	public MyException() {
		super(
				lleme.corba.testes.jacORB.demo.grid.corbaObjects.MyServerPackage.MyExceptionHelper
						.id());
	}

	public java.lang.String why = "";

	public MyException(java.lang.String _reason, java.lang.String why) {
		super(
				lleme.corba.testes.jacORB.demo.grid.corbaObjects.MyServerPackage.MyExceptionHelper
						.id()
						+ " " + _reason);
		this.why = why;
	}

	public MyException(java.lang.String why) {
		super(
				lleme.corba.testes.jacORB.demo.grid.corbaObjects.MyServerPackage.MyExceptionHelper
						.id());
		this.why = why;
	}
}
