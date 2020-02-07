import java.util.ArrayList;
import java.util.Scanner;

public class GroceryList2 {

    //Fields
    ArrayList<ItemOrder> list = new ArrayList<>();

    //Methods
    public void addItem(ArrayList<ItemOrder> list)  {
        Scanner console = new Scanner(System.in);
        if(list.size() < 10) {
                System.out.println("Enter Item:");
                String name = console.nextLine();
                System.out.println("Enter quantity:");
                int quantity = console.nextInt();
                System.out.println("Enter price for unit:");
                double unitPrice = console.nextDouble();

                ItemOrder temp = new ItemOrder(name, quantity, unitPrice);
                list.add(list.size(), temp);
        } else {
                System.out.println("Inventory is filled.");
        }
    }

    public void printList(ArrayList<ItemOrder> list) {
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
    
    public void editItem(ArrayList<ItemOrder> list) {
        Scanner console = new Scanner(System.in);
        for(int i = 0; i < list.size(); i++) {
            System.out.printf("%d. %s", i + 1, list.get(i));
        }
        int targetIndex = InputHelper.getOptionFromUser(1, list.size()) - 1;
        ItemOrder chosenItem = list.get(targetIndex);
        System.out.println("What would you like to edit?");
        System.out.println("Enter 1 - Edit name \n" + "Enter 2 - Edit quantity \n" + "Enter 3 - Edit unitprice");
        int choice = InputHelper.getOptionFromUser(1,3);
        switch(choice){
            case 1:
                System.out.println("What would you like to change the name to?");
                String newName = console.nextLine();
                chosenItem.setName(newName);
                System.out.printf("Item name has been changed to %s %n %n", newName);
                break;
            case 2:
                System.out.println("What would you like to changed the amount to?");
                int newQuantity = InputHelper.getIntFromUser();
                chosenItem.setQuantity(newQuantity);
                System.out.printf("Item quantity has been changed to %d %n %n", newQuantity);
                break;
            case 3:
                System.out.println("What would you like to change the unit price?");
                double newUnitPrice = InputHelper.getDoubleFromUser();
                chosenItem.setUnitPrice(newUnitPrice);
                System.out.printf("Unit price has been changed to %.2f %n %n", newUnitPrice);
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
    }

    public String toString() {
        String returnString = "";
        for (int i = 0; i < list.size(); i++) {
            returnString += list.get(i);
        }
        return returnString;
    }

   public double getTotalCost(ArrayList<ItemOrder> list) {
        double total = 0.0;
            for(int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
                total += list.get(list.size() - 1).getCost();
            }
            System.out.printf("Total Price: %.2f DKK %n \n" , total);
                return total;
    }
}
