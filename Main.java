import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Brady on 5/29/2014.
 */
public class Main {

   public static void main(String args[]) throws FileNotFoundException {
      ArrayList<Item> items = new ArrayList<Item>();
      int capacity = readInput(args[0], items);


      System.out.println("Which type of algorithm?\n" +
                         "1. Full Enumeration\n" +
                         "2. Greedy\n" +
                         "3. Dynamic Programming\n" +
                         "4. Branch and Bound");
      Scanner scan = new Scanner(System.in);
      ArrayList<Item> solved = new ArrayList<Item>();
      switch (scan.nextInt()) {
         case 1 :
            BruteForce brute = new BruteForce(capacity);
            solved = brute.fullEnum(items, 0);
            System.out.println("Using Brute force the best feasible solution found: <" + totalValue(solved) + "> <" +
             totalWeight(solved) + ">");
            break;
         case 2 :
            GreedySearch greed = new GreedySearch(capacity);
            solved = greed.greedy(items);
            System.out.println("Greedy solution (not necessarily optimal): <" + totalValue(solved) + "> <" +
             totalWeight(solved) + ">");
            break;
         case 3 :
            System.out.println("Not yet implemented");
            break;
         case 4 :
            System.out.println("Not yet implemented");
            break;
      }

      Collections.sort(solved);

      for (Item i : solved) {
         if (i.getValue() > 0 ) {
            System.out.print("<" + i.getId() + "> ");
         }
      }


   }

   public static int totalValue(ArrayList<Item> items){
      int total = 0;

      for (Item i : items) {
         total += i.getValue();
      }
      return total;
   }

   public static int totalWeight(ArrayList<Item> items) {
      int total = 0;
      for (Item i : items) {
         total += i.getWeight();
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
