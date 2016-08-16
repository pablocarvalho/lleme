package lleme.corba.exemploAula;

import lleme.corba.exemploAula.corbaClasses.PropertyPOA;

public class PropertyServant extends PropertyPOA {
	private String name;

	private String value;

	public PropertyServant() {
		this.name = "Default name";
		this.value = "Default value";
	}

	public PropertyServant(String initialName, String initialValue) {
		this.name = initialName;
		this.value = initialValue;
	}

	public String name() {
		return this.name;
	}

	public String get() {
		return this.value;
	}

	public void set(String new_value) {
		value = new_value;
	}
}
