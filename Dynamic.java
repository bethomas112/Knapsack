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
      int table[][] = buildTable(items);

      return traceBack(table, items);
   }

   private void printTable(int[][] table) {

      for (int i = 0; i < table.length; i++) {
         for (int j = 0; j < table[0].length; j++) {
            System.out.format("%5d", table[i][j]);
         }
         System.out.println();
      }

   }

   private ArrayList<Item> traceBack(int table[][], ArrayList<Item> items) {
      ArrayList<Item> sol = new ArrayList<Item>();
      int i = table.length - 1;
      int j = table[0].length - 1;
      int curVal;

      while (i > 0 && j > 0) {
         curVal = table[i][j];

         if (curVal == table[i-1][j]) {
         /*The ith item was not selected */
            i--;
         }
         else /*if (curVal == table[i-1][j] + items.get(i-1).value)*/ {
         /*The ith item was taken*/
            sol.add(0, items.get(i -1));
            i--;
            j = j - items.get(i).weight;
         }
      }

      return sol;
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

      /*Loops through the entire table, and fills it based on the recurrence relation:
      * V(i, j) = max{ V(i-1, j-w) + V(i), V(i-1, j) }
      *                Take the item       Don't take the item
      */
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
