import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
public class Client {
   public static void main(String[] args) {
       try {
           // Locate the registry
           Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1050);
           Circle circle = (Circle)
           registry.lookup("rmi://localhost:1050/circle");
           Scanner sc = new Scanner(System.in);
           System.out.print("Enter radius: ");
           int radius = sc.nextInt();
           System.out.printf("Area = %.3f sq units\n",
            circle.getArea(radius));
           System.out.printf("Perimeter = %.3f units\n",
            circle.getPerimeter(radius));
           sc.close();
       } catch (Exception e) {
           System.out.println("Client Error: " + e);
} }
}
