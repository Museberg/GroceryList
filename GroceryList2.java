import java.util.ArrayList;
import java.util.Scanner;

public class GroceryList2 {

    //Fields
    ArrayList<ItemOrder> list = new ArrayList<>();
    int index = 0;

    //Methods
    public void addItem(ArrayList<ItemOrder> list)  {
        Scanner console = new Scanner(System.in);
        if(index < 10) {
                System.out.println("Enter Item:");
                String name = console.nextLine();
                System.out.println("Enter quantity:");
                int quantity = console.nextInt();
                System.out.println("Enter price for unit:");
                double unitPrice = console.nextDouble();

                ItemOrder temp = new ItemOrder(name, quantity, unitPrice);
                list.add(index, temp);
                index++;
        } else {
                System.out.println("Inventory is filled.");
        }
    }

    public void printList(ArrayList<ItemOrder> list) {
        for(int i = 0; i < index; i++){
            System.out.println(list.get(i));
        }
    }

    public void removeItem(ArrayList<ItemOrder> list) {
        Scanner console = new Scanner(System.in);
        System.out.println("Which item would you like to delete?");
            for(int i = 0; i < list.size(); i++) {
                System.out.println(1 + i + ". " + list.get(i));
            }
        int targetIndex = console.nextInt();
        System.out.println("This item " + list.get(targetIndex - 1).getName() + " has been removed. \n");
        list.remove(targetIndex - 1);
        index--;

    }

    public String toString() {
        String returnString = "";
        for (int i = 0; i < index; i++) {
            returnString += list.get(i);
        }
        return returnString;
    }

   public double getTotalCost(ArrayList<ItemOrder> list) {
        double total = 0.0;
            for(int i = 0; i < index; i++) {
                System.out.println(list.get(i));
                total += list.get(list.size() - 1).getCost();
            }
            System.out.printf("Total Price: %.2f DKK %n \n" , total);
                return total;
    }
}
