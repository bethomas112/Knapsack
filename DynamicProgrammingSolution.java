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


      return new ArrayList<Item>();
   }

   private int[][] buildTable(ArrayList<Item> items) {
      int table[][] = new int[items.size() + 1][capacity + 1];

      /*Initializes the base case for the table setting the 0 position in columns and rows to 0. */
      for (int i = 0; i < capacity + 1; i++) {
         if (i < items.size() + 1)
            table[i][0] = 0;
         table[0][i] = 0;
      }

      return table;
   }
}
