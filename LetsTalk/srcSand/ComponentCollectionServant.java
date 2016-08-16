
/*import corbaObjects.letstalk.InvalidSubscriptionValues;
 import corbaObjects.letstalk.host.Host;
 import corbaObjects.letstalk.host.HostHelper;
 import corbaObjects.letstalk.userManager.UserManager;
 import corbaObjects.letstalk.userManager.UserManagerHelper;
 import corbaObjects.letstalk.userManager.enum_type;
 import corbaObjects.letstalk.userfacet.UserFacetPOA;
 import corbaObjects.scs.AlreadyConnected;
 import corbaObjects.scs.ExceededConnectionLimit;
 import corbaObjects.scs.IComponentPOA;
 import corbaObjects.scs.InvalidConnection;
 import corbaObjects.scs.InvalidName;
 import corbaObjects.scs.NoConnection;*/

public class ComponentCollectionServant extends ComponentCollectionPOA {

	public ComponentLoaderServant componentLoader = null;

	public IComponentPOA component = null;

	public ComponentCollectionServant() {
		System.out
				.println("ComponentCollectionServant:Objeto ComponentCollectionServant criado");
	}

	public ComponentHandle[] getComponents() {

		return (ComponentHandle[]) this.componentLoader.components.values()
				.toArray(new ComponentHandle[0]);
	}
}