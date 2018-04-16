package uff.ic.lleme.letstalk.client;

import uff.ic.lleme.letstalk.client.scs.LetsTalkServant;
import uff.ic.lleme.letstalk.node.scs.ContainerServant;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

public class LetsTalkStarter {

	public static LetsTalkServant main(ORB orb, ContainerServant container,
			int version) throws ServantNotActive, WrongPolicy, InvalidName {
		LetsTalk appWindow = new LetsTalk();
		LetsTalkServant servant = new LetsTalkServant(orb, container,
				appWindow, version);
		appWindow.letsTalkServant = servant;
		appWindow.setVisible(true);
		return servant;
	}
}
