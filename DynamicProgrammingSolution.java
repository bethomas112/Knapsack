import java.util.ArrayList;

/**
 * Created by Brady on 5/29/2014.
 */
public class DynamicProgrammingSolution {

   private int capacity;

   public DynamicProgrammingSolution(int capacity) {
      this.capacity = capacity;
   }

   public ArrayList<Item> solve(ArrayList<Item> items) {
      ArrayList<Item> solved;
      int table[][] = buildTable(items);


      return solved;
   }

   private int[][] buildTable(ArrayList<Item> items) {
      int table[][] = new int[items.size() + 1][items.size() + 1];

      return table;
   }
}
