import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Brady on 5/29/2014.
 */
public class Branch implements Comparable<Branch> {
   public final int remainingCapacity;
   public final int level;
   public final int currentValue;
   public final double max; /*This is the upper bound*/
   public final Branch parent;


   public Branch(int level, int currentValue, int remainingCapacity, ArrayList<Item> items, Branch parent) {
      this.level = level;
      this.currentValue = currentValue;
      this.remainingCapacity = remainingCapacity;
      this.max = boundingFunction(items);
      this.parent = parent;
   }

   private double boundingFunction(ArrayList<Item> items) {
      double max = 0.0;
      int weightLeft = remainingCapacity;

      for (int i = level; i < items.size() && weightLeft != 0; i++) {
         for (int k = items.get(i).weight; k > 0 && weightLeft != 0; k--, weightLeft--) {
            max += items.get(i).ratio;
         }
      }
      return max + currentValue;
   }


   public int compareTo(Branch a) {
      return Double.compare(a.max, max);
   }
}
