import java.util.ArrayList;

/**
 * Created by Brady on 5/29/2014.
 */
public class BruteForce {

   private int capacity;

   public BruteForce(int capacity) {
      this.capacity = capacity;
   }

   public ArrayList<Item> fullEnum(ArrayList<Item> items, int ndx) {
      /*Base case, there are no more subsets to iterate over*/
      if (ndx == items.size()) {
         return items;
      }
      else {
         /*Create two new lists of items*/
         ArrayList<Item> items1 = new ArrayList<Item>(items);
         ArrayList<Item> items2 = new ArrayList<Item>(items);
         /*Do not include the 'ndxth' item in the first subset*/
         items1.set(ndx, new Item(0, 0, 0));
         /*Call recursively on the smaller subset of items*/
         items1 = fullEnum(items1, ndx + 1);
         items2 = fullEnum(items2, ndx + 1);
         /*returns the sack with the greater value. getSackValue() will return -1 if sack is overweight*/
         if (getSackValue(items1) > getSackValue(items2)) {
            return items1;
         }
         else {
            return items2;
         }

      }
   }

   /*This function will return the value of all the items in the current sack.
   * -1 will be returned if the items in the sack weigh more than the capacity.
    */
   private int getSackValue(ArrayList<Item> items) {
      int totalVal = 0;
      int totalWeight = 0;

      for (Item i : items) {
         totalVal += i.value;
         totalWeight += i.weight;
      }

      return totalWeight > capacity ? -1 : totalVal;
   }
}
