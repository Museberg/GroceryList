import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class GroceryList2 {

    //Fields
    ArrayList<ItemOrder> list = new ArrayList<>();

    //Methods
    public void createItem()  {
        Scanner console = new Scanner(System.in);
        if(list.size() < 10) {
            System.out.println("Enter Item:");
            String name = console.nextLine();
            System.out.println("Enter quantity:");
            int quantity = console.nextInt();
            System.out.println("Enter price for unit:");
            double unitPrice = console.nextDouble();

            ItemOrder temp = new ItemOrder(name, quantity, unitPrice);
            list.add(temp);
        }
        else {
            System.out.println("Inventory is filled.");
        }
    }

    public void addItem(ItemOrder order){
        if(list.size() < 10){
            list.add(order);
        }
        else {
            System.out.println("Inventory is filled.");
        }
    }

    public void printList() {
        System.out.println("----------------------------------");
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
        System.out.println("----------------------------------");
    }

    
    public void editItem(ArrayList<ItemOrder> list) {
        Scanner console = new Scanner(System.in);
        for(int i = 0; i < list.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, list.get(i));
        }
        System.out.println(); // Newline after item has printed
        int targetIndex = InputHelper.getOptionFromUser(1, list.size()) - 1;
        ItemOrder chosenItem = list.get(targetIndex);
        System.out.println("What would you like to edit?");
        System.out.println("Enter 1 - Edit name \n" + "Enter 2 - Edit quantity \n" + "Enter 3 - Edit unit price");
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
                System.out.println("What would you like to change the unit price to?");
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

    public double getTotalCost() {
        double total = 0.0;
        System.out.println("----------------------------------");
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            total += list.get(list.size() - 1).getCost();
        }
        System.out.println("----------------------------------");
        System.out.printf("Total Price: %.2f DKK %n" , total);
        System.out.println("----------------------------------");
        return total;
    }

    public void loadFromDisk() throws FileNotFoundException {
        list.clear();
        // Printing all lists saved on the disk
        int index = 0;
        File files = new File("src/GroceryLists/");
        System.out.println("Please select the grocery list you want to load. Please not this deletes all unsaved data.");
        for(File file : files.listFiles()){
            if(file.isFile()){
                index++;
                System.out.printf("%d - %s%n", index, file.getName());
            }
        }
        Scanner scan = new Scanner(System.in);
        int selectedIndex = InputHelper.getOptionFromUser(1, index);
        File selectedFile = files.listFiles()[selectedIndex - 1];
        // Traversing selected file and populating grocery list with its items
        Scanner fileScan = new Scanner(selectedFile);
        while(fileScan.hasNextLine()){
            Scanner scanLine = new Scanner(fileScan.nextLine());
            scanLine.useDelimiter(", ");
            // Reading properties of item from file
            int quantity = scanLine.nextInt();
            String name = scanLine.next();
            double unitPrice = scanLine.nextDouble();

            new ItemOrder(name, quantity, unitPrice, this);
        }
    }

    public void saveGroceryList() throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the name of the grocery list");
        String groceryListName = scan.nextLine();
        PrintStream output = new PrintStream(new File(String.format("src/GroceryLists/%s.txt", groceryListName)));
        for(ItemOrder order : list){
            output.printf("%d, %s, %.2f%n", order.getQuantity(), order.getName(), order.getUnitPrice());
        }
    }

}
