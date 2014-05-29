/**
 * Created by Brady on 5/29/2014.
 */
public class Item implements Comparable<Item> {

   private int value;
   private int id;
   private int weight;
   private double ratio;

   public Item(int id, int value, int weight) {
      this.value = value;
      this.weight = weight;
      this.id = id;
      ratio = (double)value / (double)weight;
   }

   public int getId() {
      return id;
   }

   public int getValue() {
      return value;
   }

   public int getWeight() {
      return weight;
   }

   public double getRatio(){
      return ratio;
   }


   public int compareTo(Item a) {
      return id - a.getId();
   }

   public String toString(){
      return "Value: " + value + " Weight: " + weight + " Ratio: " + ratio;
   }
}
