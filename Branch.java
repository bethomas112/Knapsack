import java.util.ArrayList;

/**
 * Created by Brady on 5/29/2014.
 */
public class Branch {
   private int remainingCapacity;
   private int level;
   private int currentValue;
   private double max; /*This is the upper bound*/


   public Branch(int level, int currentValue, ArrayList<Item> items) {
      this.level = level;
      this.currentValue = currentValue;

   }

   private void computeUpperBound(ArrayList<Item> items) {

   }
}
