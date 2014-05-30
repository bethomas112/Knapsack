/**
 * Created by Brady on 5/29/2014.
 */
public class Item implements Comparable<Item> {

   public final int value;
   public final int id;
   public final int weight;
   public final double ratio;

   public Item(int id, int value, int weight) {
      this.value = value;
      this.weight = weight;
      this.id = id;
      ratio = (double)value / (double)weight;
   }

   public int compareTo(Item a) {
      return id - a.id;
   }

   public String toString(){
      return "Value: " + value + " Weight: " + weight + " Ratio: " + ratio;
   }
}
