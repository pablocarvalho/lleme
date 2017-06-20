package uff.ic.corba.exemploAula.corbaClasses;

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
		super(uff.ic.corba.exemploAula.corbaClasses.PropertyAlreadyExistsHelper.id());
	}

	public uff.ic.corba.exemploAula.corbaClasses.Property prop;

	public PropertyAlreadyExists(java.lang.String _reason,
			uff.ic.corba.exemploAula.corbaClasses.Property prop) {
		super(uff.ic.corba.exemploAula.corbaClasses.PropertyAlreadyExistsHelper.id() + " "
				+ _reason);
		this.prop = prop;
	}

	public PropertyAlreadyExists(uff.ic.corba.exemploAula.corbaClasses.Property prop) {
		super(uff.ic.corba.exemploAula.corbaClasses.PropertyAlreadyExistsHelper.id());
		this.prop = prop;
	}
}
