package fit5136.bakeshop.entities;

public class Item {
    private int itemNum;
    private String itemName;
    private double costPerItem;
    private String type;

    public Item(int itemNum, String itemName, double costPerItem, String type) {
        this.itemNum = itemNum;
        this.itemName = itemName;
        this.costPerItem = costPerItem;
        this.type = type;
    }

    public int getItemNum() {
        return itemNum;
    }

    public String getItemName() {
        return itemName;
    }

    public double getCostPerItem() {
        return costPerItem;
    }

    public String getType() {
        return type;
    }

    public void setItemNum(int itemNum) {
        this.itemNum = itemNum;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setCostPerItem(double costPerItem) {
        this.costPerItem = costPerItem;
    }

    public void setType(String type) {
        this.type = type;
    }
}
