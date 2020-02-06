import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class GroceryList {
    //Fields

    private int index = 0;
    ItemOrder[] list = new ItemOrder[10];



    //Methods
    public void addItem(ItemOrder o) {
        Scanner console = new Scanner(System.in);
        if(index < 10) {
            System.out.println("Enter Item Name:");
            String name = console.next();
            System.out.println("Enter quantity: ");
            int quantity = InputHelper.getIntFromUser();
            System.out.println("Enter unitPrice: ");
            double unitPrice = InputHelper.getDoubleFromUser();

            ItemOrder temp = new ItemOrder(name, quantity, unitPrice);

            list[index] = temp;
            index++;

        } else {
            System.out.println("Inventory is filled.");
        }
    }

    public double getTotalCost() {
        double total = 0.0;
            for(int i = 0; i < index; i++) {
            total += list[i].getCost();
        }
        System.out.printf("Total Price: %.2f %n" , total);
        return total;
    }


    public String toString(){
        String returnString = "";
            for(int i = 0; i < index; i++) {
            returnString += list[i];
        }

        return returnString;
    }

    public void printList() {
        if(index > 0) {
            for(int i = 0; i < index; i++) {
                System.out.println(list[i]);
            }
        } else {
            System.out.println("Inventory is empty.");
        }
    }

    public void removeItem() {
        Scanner console = new Scanner(System.in);
        System.out.println("Which item to delete? ");
            for(int i = 0; i < index; i++) {
                System.out.println(list[i]);
        }
            int chose = console.nextInt();
    }

    public void readFromFile() throws FileNotFoundException {
        Scanner input = new Scanner(new File("src/whatever.txt"));
            while(input.hasNextLine()) {
                Scanner inputLine = new Scanner(input.nextLine());
                int quantity = inputLine.nextInt();
                String itemName = inputLine.next();
                double itemPrice = inputLine.nextDouble();

                ItemOrder temp = new ItemOrder(itemName, quantity, itemPrice, this);
                System.out.println(temp);



        }
    }

}
