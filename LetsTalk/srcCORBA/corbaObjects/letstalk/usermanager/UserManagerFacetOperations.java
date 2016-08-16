package corbaObjects.letstalk.usermanager;

/**
 * corbaObjects/letstalk/usermanager/UserManagerFacetOperations.java . Generated
 * by the IDL-to-Java compiler (portable), version "3.2" from letstalk.idl
 * Sexta-feira, 9 de Dezembro de 2005 18h26min29s BRST
 */

public interface UserManagerFacetOperations {
	corbaObjects.letstalk.usermanager.enum_type subscribe(String login,
			String password);

	corbaObjects.letstalk.usermanager.enum_type connect(String login,
			String password);

	corbaObjects.letstalk.usermanager.enum_type desconnect(String login);
} // interface UserManagerFacetOperations
