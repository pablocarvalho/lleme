package uff.ic.lleme.letstalk.cbobjs.corbaObjects.scs;

/**
 * corbaObjects/scs/HelpInfoNotAvailableHolder.java . Generated by the
 * IDL-to-Java compiler (portable), version "3.2" from deployment.idl
 * Sexta-feira, 9 de Dezembro de 2005 18h26min28s BRST
 */

public final class HelpInfoNotAvailableHolder implements
		org.omg.CORBA.portable.Streamable {
	public uff.ic.lleme.letstalk.cbobjs.corbaObjects.scs.HelpInfoNotAvailable value = null;

	public HelpInfoNotAvailableHolder() {
	}

	public HelpInfoNotAvailableHolder(
			uff.ic.lleme.letstalk.cbobjs.corbaObjects.scs.HelpInfoNotAvailable initialValue) {
		value = initialValue;
	}

	public void _read(org.omg.CORBA.portable.InputStream i) {
		value = uff.ic.lleme.letstalk.cbobjs.corbaObjects.scs.HelpInfoNotAvailableHelper.read(i);
	}

	public void _write(org.omg.CORBA.portable.OutputStream o) {
		uff.ic.lleme.letstalk.cbobjs.corbaObjects.scs.HelpInfoNotAvailableHelper.write(o, value);
	}

	public org.omg.CORBA.TypeCode _type() {
		return uff.ic.lleme.letstalk.cbobjs.corbaObjects.scs.HelpInfoNotAvailableHelper.type();
	}

}
