#ifndef SERVANT_H
#define SERVANT_H

#include "property.h"

class PropertyServant: virtual public POA_Property,
                       virtual public PortableServer::RefCountServantBase {
   CORBA::String_var val;
public:
   PropertyServant (const char* init_value)
   { val = CORBA::string_dup(init_value); }

   virtual char* name() throw (CORBA::SystemException)
   { return CORBA::string_dup("Prop Name"); }

   virtual char* get () throw (CORBA::SystemException)
   { return CORBA::string_dup(val); }

   virtual void set (const char* value) throw (CORBA::SystemException)
   { val = value; }
};

#endif
