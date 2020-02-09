import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;
import java.util.*;

public class GroceryExercise {
    public static void main(String [] args) throws FileNotFoundException {
        ArrayList<Login> listL = new ArrayList<>();
        ArrayList<ItemOrder> listt = new ArrayList<>();
        GroceryList a = new GroceryList();
        //String pattern = "dd-MM-yyyy HH:mm:ss";
        //SimpleDateFormat sdf = new SimpleDateFormat("E dd-MM/yyyy HH:mm:ss");
        Login test = new Login("Arne", "1234", listL); // Her er nogle defineret bruger
        Login test2 = new Login("BNent", "2222", listL); // Gælder også her.
        Date date = new Date();
        ItemOrder o = new ItemOrder("Milk", 1, 3);GroceryList2 listG = new GroceryList2();
        LoginSelection(listL ,listt, listG);

        Date date = new Date();

        GroceryList arrayGroceryList = new GroceryList();
        GroceryList2 arrayListGroceryList = new GroceryList2();

        menuSelectionAL(arrayListGroceryList); // Menu using arrayList
        //menuSelectionA(arrayGroceryList, date, o); // Menu using array

    }

    public static void menuSelectionA(GroceryList arrayGroceryList,  Date time) {
        SimpleDateFormat sdf = new SimpleDateFormat("E dd-MM/yyyy HH:mm");
        System.out.println("\nCurrent LocalTime: " + sdf.format(time));
        Scanner console = new Scanner(System.in);
        boolean flag = true;
        while(flag) {
            System.out.println("Welcome to GroceryList \n");
            System.out.println("Enter 1 - Add item \n" +
                    "Enter 2 - Show list \n" +
                    "Enter 3 - Calculate total cost \n" +
                    "Enter 4 - Exit");
            int chose = console.nextInt();
                switch(chose) {
                    case 1:
                        arrayGroceryList.createItem();
                        break;
                    case 2:
                        arrayGroceryList.printList();
                        break;
                    case 3:
                        arrayGroceryList.getTotalCost();
                        break;
                    case 4:
                        System.out.println("Exiting program");
                        flag = false;
                        break;
                    default:
                        System.out.println("Input format is incorrect \nPick a number between 1 and 4.");
                        break;
                }
        }
    }

    public static void LoginSelection(ArrayList<Login> listL, ArrayList<ItemOrder> listI, GroceryList2 listG) {
        boolean flag = true;
        while(flag) {
            System.out.println("Welcome to GroceryList");
            System.out.println("Enter 1 - Login \n " +
                    "Enter 2 - Register account");
            int choice = InputHelper.getOptionFromUser(1,2);
                switch(choice) {
                    case 1:
                        Login.loginCheck(listL,listI, listG);
                        break;
                    case 2:
                        Login.Register(listL);
                        break;
                }
        }

    }

    public static void menuSelectionAL(GroceryList2 arrayListGroceryList) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        boolean flag = true;
        while(flag) {
            System.out.println("Enter 1 - Add item \n" +
                    "Enter 2 - Remove Item \n" +
                    "Enter 3 - Edit Item \n" +
                    "Enter 4 - Calculate total cost \n" +
                    "Enter 5 - Print list \n" +
                    "Enter 6 - Save grocery list to disk \n" +
                    "Enter 7 - Load grocery list from disk - overwrites current list \n" +
                    "Enter 8 - Exit program");
            int chose = console.nextInt();
                switch(chose) {
                    case 1: // User creates new itemOrder
                        arrayListGroceryList.createItem();
                        break;
                    case 2: // User removes item
                        arrayListGroceryList.removeItem();
                        break;
                    case 3: // User edits item
                        arrayListGroceryList.editItem();
                        break;
                    case 4: // Prints all items and the total cost of them
                        arrayListGroceryList.getTotalCost();
                        break;
                    case 5: // Prints a list of all items
                        arrayListGroceryList.printList();
                        break;
                    case 6: // Saves current grocery list to disk
                        arrayListGroceryList.saveGroceryList();
                        break;
                    case 7: // Loads selected grocery list from disk
                        arrayListGroceryList.loadFromDisk();
                        break;
                    case 8: // Exits program
                        System.out.println("Exiting program ...");
                        flag = false;
                        break;
                }

        }
    }
}
