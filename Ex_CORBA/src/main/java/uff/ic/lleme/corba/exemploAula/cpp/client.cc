#include <CORBA.h>
#include <iostream.h>
#include "property.h"

int main (int argc, char** argv) {
   try {
      CORBA::ORB_var orb = CORBA::ORB_init(argc,argv);
      CORBA::Object_var obj = orb->string_to_object(argv[argc-2]);
      
      Property_var prop = Property::_narrow(obj);
      if (CORBA::is_nil(prop)) {
         cerr << "Referência NULL para o servidor" << endl;
         exit(-1);
      }

      cout << prop->name() << endl << prop->get() << endl;
      prop->set(argv[argc-1]);
      cout << prop->get() << endl;
   }
   catch (const CORBA::Exception& ex) {
      cerr << ex << endl;
   }

   return 0;
}
