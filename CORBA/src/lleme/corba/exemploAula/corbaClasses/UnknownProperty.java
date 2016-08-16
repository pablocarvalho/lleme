package lleme.corba.exemploAula.corbaClasses;

/**
 * Generated from IDL definition of exception "UnknownProperty"
 * 
 * @author JacORB IDL compiler
 */

public final class UnknownProperty extends org.omg.CORBA.UserException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5393358184592200341L;

	public UnknownProperty() {
		super(lleme.corba.exemploAula.corbaClasses.UnknownPropertyHelper.id());
	}

	public java.lang.String name = "";

	public UnknownProperty(java.lang.String _reason, java.lang.String name) {
		super(lleme.corba.exemploAula.corbaClasses.UnknownPropertyHelper.id() + " "
				+ _reason);
		this.name = name;
	}

	public UnknownProperty(java.lang.String name) {
		super(lleme.corba.exemploAula.corbaClasses.UnknownPropertyHelper.id());
		this.name = name;
	}
}
