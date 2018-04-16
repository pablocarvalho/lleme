package uff.ic.lleme.corba.testes.jacORB.demo.grid.corbaObjects.MyServerPackage;

/**
 * Generated from IDL definition of exception "MyException"
 * 
 * @author JacORB IDL compiler
 */

public final class MyExceptionHolder implements
		org.omg.CORBA.portable.Streamable {
	public uff.ic.lleme.corba.testes.jacORB.demo.grid.corbaObjects.MyServerPackage.MyException value;

	public MyExceptionHolder() {
	}

	public MyExceptionHolder(
			final uff.ic.lleme.corba.testes.jacORB.demo.grid.corbaObjects.MyServerPackage.MyException initial) {
		value = initial;
	}

	public org.omg.CORBA.TypeCode _type() {
		return uff.ic.lleme.corba.testes.jacORB.demo.grid.corbaObjects.MyServerPackage.MyExceptionHelper
				.type();
	}

	public void _read(final org.omg.CORBA.portable.InputStream _in) {
		value = uff.ic.lleme.corba.testes.jacORB.demo.grid.corbaObjects.MyServerPackage.MyExceptionHelper
				.read(_in);
	}

	public void _write(final org.omg.CORBA.portable.OutputStream _out) {
		uff.ic.lleme.corba.testes.jacORB.demo.grid.corbaObjects.MyServerPackage.MyExceptionHelper
				.write(_out, value);
	}
}
