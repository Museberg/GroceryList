public class ItemOrder {
    //Fields
    private String name;
    private int quantity = 1;
    private double unitPrice;

    //Constructor
    public ItemOrder(String name, int quantity, double unitPrice, GroceryList list) {
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;

        list.addItem(this);

    }

    public ItemOrder(String name, int quantity, double unitPrice, GroceryList2 list) {
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;

        list.addItem(this);

    }
    public ItemOrder(String name, int quantity, double unitPrice) {
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;

    }

    public ItemOrder(String name) {

        this.name = name;
    }

    /*public ItemOrder(String name, int quantity, double unitPrice) {
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }*/

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public int getQuantity() {

        return quantity;
    }

    public void setQuantity(int quantity) {

        this.quantity = quantity;
    }

    public double getUnitPrice() {

        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {

        this.unitPrice = unitPrice;
    }

    public double getCost() {

        return quantity * unitPrice;
    }

    public String toString() {

        return String.format("%-3d %-20s %.2f DKK", quantity, name, unitPrice);
    }
}
