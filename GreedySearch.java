import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Brady on 5/29/2014.
 */
public class GreedySearch {
   private int capacity;

   public GreedySearch(int capacity) {
      this.capacity = capacity;
   }

   public ArrayList<Item> greedy(ArrayList<Item> items) {
      ArrayList<Item> sol = new ArrayList<Item>();
      int weight = 0;

      /* This comparator sorts based off of the value over weight ratio. */
      ItemComparator comp = new ItemComparator();

      /*I am sorting items based on their value to weight ratio. I believe this is the best criteria because
      * the point of knapsack is maximizing value over weight.*/
      Collections.sort(items, comp);


      for (Item i : items) {
         if ((i.weight + weight) <= capacity) {
            weight += i.weight;
            sol.add(i);
         }
      }
      return sol;
   }
}
