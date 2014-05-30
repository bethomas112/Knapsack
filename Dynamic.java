import java.util.ArrayList;

/**
 * Created by Brady on 5/29/2014.
 */
public class Dynamic {

   private int capacity;

   public Dynamic(int capacity) {
      this.capacity = capacity;
   }

   public ArrayList<Item> solve(ArrayList<Item> items) {
      ArrayList<Item> solved;
      int table[][] = buildTable(items);
      for (Item i : items) {
         System.out.println(i.toString());
      }

      printTable(table);


      return new ArrayList<Item>();
   }

   private void printTable(int[][] table) {

      for (int i = 0; i < table.length; i++) {
         for (int j = 0; j < table[0].length; j++) {
            System.out.format("%4d", table[i][j]);
         }
         System.out.println();
      }

   }

   private int[][] buildTable(ArrayList<Item> items) {
      int table[][] = new int[items.size() + 1][capacity + 1];
      Item cur;

      /*Initializes the base case for the table setting the 0 position in columns and rows to 0. */
      for (int i = 0; i < capacity + 1; i++) {
         if (i < items.size() + 1) {
            table[i][0] = 0;
         }
         table[0][i] = 0;
      }
      for (int i = 1; i < items.size() + 1; i++) {
         cur = items.get(i - 1);
         for (int j = 1; j < capacity + 1; j++) {
            if (j >= cur.weight) {
               table[i][j] = Math.max(table[i - 1][j],
                table[i - 1][j - cur.weight] + cur.value);
            }
            else {
               table[i][j] = table[i - 1][j];
            }
         }
      }


      return table;
   }
}
