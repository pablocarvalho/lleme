package lleme.corba.testes.jacORB.demo.grid.corbaObjects;

/**
 * Generated from IDL interface "MyServer"
 * 
 * @author JacORB IDL compiler V 2.2.2, 1-Jun-2005
 */

public interface MyServerOperations {
	/* constants */
	/* operations */
	short height();

	short width();

	void set(short n, short m, java.math.BigDecimal value);

	java.math.BigDecimal get(short n, short m);

	short opWithException()
			throws lleme.corba.testes.jacORB.demo.grid.corbaObjects.MyServerPackage.MyException;
}
