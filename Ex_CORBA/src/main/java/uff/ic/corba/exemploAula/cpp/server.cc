#include <CORBA.h>
#include <iostream.h>
#include "servant.h"

int main (int argc, char** argv) {
   try {
      CORBA::ORB_var orb = CORBA::ORB_init(argc,argv);
      CORBA::Object_var obj;
      obj = orb->resolve_initial_references("RootPOA");
      PortableServer::POA_var poa = PortableServer::POA::_narrow(obj);
      PortableServer::POAManager_var mgr = poa->the_POAManager();
      mgr->activate();
      
      PropertyServant servant ("Hello World!");
      Property_var object = servant._this();
      CORBA::String_var str = orb->object_to_string(object);
      cout << str << endl;

      orb->run();
   }
   catch (CORBA::Exception& ex) {
      cerr << ex << endl;
   }

   return 0;
}
