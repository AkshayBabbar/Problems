CORBA (Common Object Request Broker Architecture) is a standard defined by the Object Management Group (OMG) for enabling communication between various applications, regardless of the programming languages they are written in or the platforms they run on. The architecture of CORBA is based on the concept of an Object Request Broker (ORB), which handles communication between clients and servers.

### CORBA Architecture

The main components of CORBA architecture are:

1. **ORB (Object Request Broker):** The middleware that facilitates communication between clients and servers.
2. **IDL (Interface Definition Language):** Defines the interfaces that CORBA objects present to the outside world.
3. **Stub and Skeleton:**
    - **Stub:** Client-side proxy that represents the CORBA server object.
    - **Skeleton:** Server-side counterpart that receives requests from the ORB and forwards them to the actual server implementation.
4. **POA (Portable Object Adapter):** A part of the server-side ORB that manages the server objects.
5. **ORB Interface:** The API provided by the ORB to interact with it.

### Implementing Server-Side (Skeleton) Part of a CORBA Application

Here's a step-by-step guide on implementing the server-side (skeleton) part of a CORBA application using Java:

#### Step 1: Define the Interface using IDL

Create an IDL file that defines the interface for your CORBA objects.

**Hello.idl:**
```idl
module HelloApp {
  interface Hello {
    string sayHello();
  };
};
```

#### Step 2: Compile the IDL file

Use the IDL-to-Java compiler (`idlj`) to generate Java bindings for the IDL file.

```sh
idlj -fall Hello.idl
```

This command generates several files, including:
- `Hello.java`
- `HelloHelper.java`
- `HelloHolder.java`
- `HelloOperations.java`
- `HelloPOA.java` (the skeleton)

#### Step 3: Implement the Server (Skeleton)

Implement the server-side logic by extending the generated skeleton class (`HelloPOA`).

**HelloImpl.java:**
```java
import HelloApp.HelloPOA;

public class HelloImpl extends HelloPOA {

    @Override
    public String sayHello() {
        return "Hello, world!";
    }
}
```

#### Step 4: Create the Server Application

Write the server application that initializes the ORB, registers the implementation with the POA, and waits for client requests.

**HelloServer.java:**
```java
import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import HelloApp.Hello;

public class HelloServer {

    public static void main(String[] args) {
        try {
            // Initialize the ORB
            ORB orb = ORB.init(args, null);

            // Get reference to root POA and activate the POAManager
            POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootPOA.the_POAManager().activate();

            // Create servant and register it with the ORB
            HelloImpl helloImpl = new HelloImpl();

            // Get the object reference from the servant
            org.omg.CORBA.Object ref = rootPOA.servant_to_reference(helloImpl);
            Hello href = HelloApp.HelloHelper.narrow(ref);

            // Get the root naming context
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // Bind the object reference in naming
            String name = "Hello";
            NameComponent[] path = ncRef.to_name(name);
            ncRef.rebind(path, href);

            System.out.println("HelloServer ready and waiting ...");

            // Wait for invocations from clients
            orb.run();
        } catch (Exception e) {
            System.err.println("ERROR: " + e);
            e.printStackTrace(System.out);
        }

        System.out.println("HelloServer Exiting ...");
    }
}
```

#### Step 5: Create the Client Application

Write the client application that locates the server object and invokes methods on it.

**HelloClient.java:**
```java
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import HelloApp.Hello;
import HelloApp.HelloHelper;

public class HelloClient {

    public static void main(String[] args) {
        try {
            // Initialize the ORB
            ORB orb = ORB.init(args, null);

            // Get the root naming context
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // Resolve the object reference in naming
            String name = "Hello";
            Hello hello = HelloHelper.narrow(ncRef.resolve_str(name));

            // Call the sayHello method
            String response = hello.sayHello();
            System.out.println("Response from server: " + response);

        } catch (Exception e) {
            System.err.println("ERROR: " + e);
            e.printStackTrace(System.out);
        }
    }
}
```

### Step 6: Run the Application

1. Start the naming service (e.g., `tnameserv`):
   ```sh
   tnameserv -ORBInitialPort 1050
   ```

2. Start the server:
   ```sh
   java HelloServer -ORBInitialPort 1050 -ORBInitialHost localhost
   ```

3. Run the client:
   ```sh
   java HelloClient -ORBInitialPort 1050 -ORBInitialHost localhost
   ```

### Summary

In this guide, we've defined a CORBA interface using IDL, compiled it to generate Java bindings, and implemented a server-side (skeleton) class. We've also created a server application to register the implementation with the ORB and a client application to invoke the server's methods. This setup demonstrates the basic usage of CORBA for remote method invocation.