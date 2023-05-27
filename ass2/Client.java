import java.util.Scanner;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import CalculatorApp.Calculator;
import CalculatorApp.CalculatorHelper;
public class Client {
   public static void main(String[] args) {
       try {
           ORB orb = ORB.init(args, null);
           org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
           NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
           Calculator addObj = CalculatorHelper.narrow(ncRef.resolve_str("ABC"));
           Scanner sc = new Scanner(System.in);
           System.out.println("Welcome to addition system:");
           while (true) {
               System.out.println("1. Add");
               System.out.println("2. Subtract");
               System.out.println("3. Multiply");
               System.out.println("4. Divide");
               System.out.println("Press any key to exit");
               System.out.print("Enter your choice: ");
               int choice = sc.nextInt();
               if (choice == 1) {
                   System.out.print("Enter first no: ");
                   double x = sc.nextDouble();
                   System.out.print("Enter second no: ");
                   double y = sc.nextDouble();
                    System.out.println(x + " + " + y + " = " + addObj.add(x, y));
               } else if (choice == 2) {
                   System.out.print("Enter first no: ");
                   double x = sc.nextDouble();
                   System.out.print("Enter second no: ");
                   double y = sc.nextDouble();
                   System.out.println(x + " - " + y + " = " + addObj.subtract(x, y));
               } else if (choice == 3) {
                   System.out.print("Enter first no: ");
                   double x = sc.nextDouble();
                   System.out.print("Enter second no: ");
                   double y = sc.nextDouble();
                   System.out.println(x + " * " + y + " = " + addObj.multiply(x, y));
               } else if (choice == 4) {
                   System.out.print("Enter first no: ");
                   double x = sc.nextDouble();
                   System.out.print("Enter second no: ");
                   double y = sc.nextDouble();
                   System.out.println(x + " / " + y + " = " + addObj.divide(x, y));
               } else {
                   break;
}
System.out.println("-------------------------------------");
               System.out.println();
}
           sc.close();
       } catch (Exception e) {
           System.out.println("Client Error: " + e);
           e.printStackTrace(System.out);
       }
}

}