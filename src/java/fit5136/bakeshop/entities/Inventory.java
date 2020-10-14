package fit5136.bakeshop.entities;

import java.util.HashMap;
import fit5136.bakeshop.entities.Item;

public class Inventory {
    private HashMap<Item, Integer> listOfItems;

    public Inventory(HashMap<Item, Integer> listOfItems) {
        this.listOfItems = listOfItems;
    }

    public Inventory() {
        this.listOfItems = new HashMap<Item, Integer>();
    }

    public void addItem(Item item, Integer num){
        this.listOfItems.put(item, num);
    }

    public int getItemNum(Item item){
        return this.listOfItems.get(item);
    }

    public String getItemNameList(){
        String itemNameList = "";
        for (Item i : listOfItems.keySet())
        {
            itemNameList += i.getItemNum();
            itemNameList += "   ";
            itemNameList += i.getItemName();
            itemNameList += "\n";
        }
        return itemNameList;
    }

    @Override
    public String toString() {
        String inventoryList = "";
        for (Item i : listOfItems.keySet())
        {
            inventoryList += i.getItemName();
            inventoryList += "      ";
            inventoryList += listOfItems.get(i);
            inventoryList += "\n";
        }
        return inventoryList;
    }


}
