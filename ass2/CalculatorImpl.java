import org.omg.CORBA.ORB;
import CalculatorApp.CalculatorPOA;
public class CalculatorImpl extends CalculatorPOA {
   private ORB orb;
   public CalculatorImpl(ORB orb) {
       this.orb = orb;
}
   @Override
   public double add(double x, double y) {
return x + y; }
   @Override
   public double subtract(double x, double y) {
return x - y; }
@Override
   public double multiply(double x, double y) {
return x * y; }
   @Override
   public double divide(double x, double y) {
       if (y == 0) {
           return Double.MAX_VALUE;
}
return x / y; }
   @Override
   public void shutdown() {
       orb.shutdown(false);
   }
}
