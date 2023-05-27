import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class Server {
   public static void main(String[] args) {
       try {
           // Set hostname for the server using javaProperty
           System.setProperty("java.rmi.server.hostname", "127.0.0.1");
 
           Circle stub = new CircleImpl();
// Register the exported class in RMI registry with some
           // Client will use that name to get the reference of those exported object
           // Get the registry to register the object.
           Registry registry = LocateRegistry.createRegistry(1050);
           registry.rebind("rmi://localhost:1050/circle", stub);
           System.out.println("Server is up and running...");
       } catch (Exception e) {
           System.out.println("Server Error: " + e);
} }
}