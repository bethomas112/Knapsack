import java.util.Comparator;

/**
 * Created by Brady on 5/29/2014.
 */
public class ItemComparator implements Comparator<Item> {

   public int compare(Item a, Item b) {
      if (a.ratio - b.ratio < 0.0) {
         return 1;
      }
      else if (a.ratio - b.ratio > 0.0) {
         return -1;
      }
      else {
         return 0;
      }
   }
}
