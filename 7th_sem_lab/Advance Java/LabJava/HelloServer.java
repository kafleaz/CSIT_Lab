import HelloApp.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

class HelloImpl extends HelloApp._HelloImplBase {
    @Override
    public String sayHello() {
        return "Hello, World!";
    }
}

public class HelloServer {
    public static void main(String[] args) {
        try {
            // Initialize ORB
            ORB orb = ORB.init(args, null);

            // Get reference to RootPOA and activate the POAManager
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            // Create and register the servant
            HelloImpl helloImpl = new HelloImpl();
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(helloImpl);
            Hello helloRef = HelloHelper.narrow(ref);

            // Bind the object reference in the naming context
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            String name = "Hello";
            NameComponent path[] = ncRef.to_name(name);
            ncRef.rebind(path, helloRef);

            System.out.println("HelloServer ready and waiting...");

            // Wait for invocations
            orb.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
