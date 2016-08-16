package lleme.corba.exemploAula.corbaClasses;

/**
 * Generated from IDL definition of exception "PropertyAlreadyExists"
 * 
 * @author JacORB IDL compiler
 */

public final class PropertyAlreadyExists extends org.omg.CORBA.UserException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7684047541582096573L;

	public PropertyAlreadyExists() {
		super(lleme.corba.exemploAula.corbaClasses.PropertyAlreadyExistsHelper.id());
	}

	public lleme.corba.exemploAula.corbaClasses.Property prop;

	public PropertyAlreadyExists(java.lang.String _reason,
			lleme.corba.exemploAula.corbaClasses.Property prop) {
		super(lleme.corba.exemploAula.corbaClasses.PropertyAlreadyExistsHelper.id() + " "
				+ _reason);
		this.prop = prop;
	}

	public PropertyAlreadyExists(lleme.corba.exemploAula.corbaClasses.Property prop) {
		super(lleme.corba.exemploAula.corbaClasses.PropertyAlreadyExistsHelper.id());
		this.prop = prop;
	}
}
