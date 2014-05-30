import javax.swing.text.DefaultEditorKit;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by Brady on 5/29/2014.
 */
public class Main {

   public static void main(String args[]) throws FileNotFoundException {
      ArrayList<Item> items = new ArrayList<Item>();
      int capacity = readInput(args[0], items);
      int choice = 0;

      Scanner scan = new Scanner(System.in);
      ArrayList<Item> solved = new ArrayList<Item>();

      while (choice != 5) {
         switch (choice) {
            case 1:
               BruteForce brute = new BruteForce(capacity);
               solved = brute.fullEnum(items, 0);
               System.out.println("Using Brute force the best feasible solution found: <" + totalValue(solved) + "> <" +
                     totalWeight(solved) + ">");
               break;
            case 2:
               GreedySearch greed = new GreedySearch(capacity);
               solved = greed.greedy(items);
               System.out.println("Greedy solution (not necessarily optimal): <" + totalValue(solved) + "> <" +
                     totalWeight(solved) + ">");
               break;
            case 3:
               Dynamic dyn = new Dynamic(capacity);
               solved = dyn.solve(items);
               System.out.println("Dynamic Programming solution: <" + totalValue(solved) + "> <" +
                     totalWeight(solved) + ">");
               break;
            case 4:
               BranchAndBound bAndB = new BranchAndBound(capacity);
               solved = bAndB.solve(items);
               System.out.println("Using Branch and Bound the best feasible solution found: <" + totalValue(solved)
                     + "> <" + totalWeight(solved) + ">");
               break;
            default:
               break;
         }
         Collections.sort(solved);

         for (Item i : solved) {
            if (i.value > 0 ) {
               System.out.print("<" + i.id + "> ");
            }
         }

         System.out.println("\nWhich type of algorithm?\n" +
               "1. Full Enumeration\n" +
               "2. Greedy\n" +
               "3. Dynamic Programming\n" +
               "4. Branch and Bound\n" +
               "5. Exit");
         choice = scan.nextInt();
      }

   }


   public static int totalValue(ArrayList<Item> items){
      int total = 0;

      for (Item i : items) {
         total += i.value;
      }
      return total;
   }

   public static int totalWeight(ArrayList<Item> items) {
      int total = 0;
      for (Item i : items) {
         total += i.weight;
      }
      return total;
   }

   public static int readInput(String filename, ArrayList<Item> items) throws FileNotFoundException {
      Scanner scan = new Scanner(new File(filename));

      int count = scan.nextInt();

      for(int i = 0; i < count; i++) {
         items.add(new Item(scan.nextInt(), scan.nextInt(), scan.nextInt()));
      }

      return scan.nextInt();
   }
}
