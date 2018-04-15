package uff.ic.lleme.letstalk.usrmgr.scs;

import uff.ic.lleme.letstalk.cbobjs.corbaObjects.letstalk.usermanager.UserManagerFacetPOA;
import uff.ic.lleme.letstalk.cbobjs.corbaObjects.letstalk.usermanager.enum_type;

public class UserManagerFacetServant extends UserManagerFacetPOA {

	public enum_type subscribe(String login, String password) {
		return enum_type.OK;
	}

	public enum_type connect(String login, String password) {
		return enum_type.OK;
	}

	public enum_type desconnect(String login) {
		return enum_type.OK;
	}

}
