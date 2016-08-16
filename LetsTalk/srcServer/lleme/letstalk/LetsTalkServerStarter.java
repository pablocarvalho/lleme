package lleme.letstalk;

import lleme.letstalk.scs.server.LetsTalkServerServant;
import lleme.letstalk.scs.node.ContainerServant;

import java.io.IOException;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

public class LetsTalkServerStarter {

	public static LetsTalkServerServant main(ORB orb,
			ContainerServant container, int version) throws ServantNotActive,
			WrongPolicy, InvalidName, IOException {
		LetsTalkServer appWindow = new LetsTalkServer();
		LetsTalkServerServant servant = new LetsTalkServerServant(orb,
				container, appWindow, version);
		appWindow.setVisible(true);
		return servant;
	}

}
