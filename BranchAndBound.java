import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Brady on 5/29/2014.
 */
public class BranchAndBound {
   private int capacity;

   public BranchAndBound(int capacity) {
      this.capacity = capacity;
   }


   public ArrayList<Item> solve(ArrayList<Item> items) {
      Comparator<Item> comp = new ItemComparator();
      Collections.sort(items, comp);
      return branchAndBound(items);
   }

   private ArrayList<Item> branchAndBound(ArrayList<Item> items) {
      PriorityQueue<Branch> queue = new PriorityQueue<Branch>();
      Branch curBranch; /*The current node of the branch*/
      Branch maxBranch; /*The branch pointing to the highest valued branch*/
      Item curItem; /*The item on the current level of tree*/
      int level; /*The current level in the tree*/

      Branch root = new Branch(0, 0, capacity, items, null);
      maxBranch = root;
      queue.add(root);

      while(!queue.isEmpty()) {
         curBranch = queue.remove();
         level = curBranch.level;

         if (curBranch.currentValue >= maxBranch.currentValue) {
            maxBranch = curBranch;
         }

         if (maxBranch.currentValue <= curBranch.max) {
            /*Make sure we are not at the last item*/
            if (level < items.size()) {
               curItem = items.get(level);
               /*Build a branch to the left including the item at this level if it can fit in the sack*/
               if (curBranch.remainingCapacity - curItem.weight >= 0) {
                  queue.add(new Branch(level + 1, curBranch.currentValue + curItem.value,
                        curBranch.remainingCapacity - curItem.weight, items, curBranch));
               }
               /*Build a branch to the right without the current item*/
               queue.add(new Branch(level + 1, curBranch.currentValue, curBranch.remainingCapacity, items, curBranch));
            }
         }
         /*else if (level == items.size()) {
            System.out.println("breaking");
            break;
         }*/
      }

      return traceBranch(maxBranch, items);
   }

   private ArrayList<Item> traceBranch(Branch solved, ArrayList<Item> items) {
      ArrayList<Item> solution = new ArrayList<Item>();
      Branch cur = solved;

      while (cur.parent != null) {
         if (cur.currentValue != cur.parent.currentValue) {
            solution.add(items.get(cur.level - 1));
         }
         cur = cur.parent;
      }

      return solution;
   }


}
