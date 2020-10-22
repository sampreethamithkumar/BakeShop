package fit5136.bakeshop.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fit5136.bakeshop.entities.Item;

public class Inventory {
    private HashMap<Item, Integer> listOfItems;
    private int storeId;


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

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public HashMap<Item, Integer> getListOfItems() {
        return listOfItems;
    }

    public List<Item> getListItems() {
        return new ArrayList<>(listOfItems.keySet());
    }

    public HashMap<Item, Integer> generateItemLow(){
        HashMap<Item, Integer> result = new HashMap<>();
        for (Item item : this.listOfItems.keySet()){
            if (this.listOfItems.get(item) <= 20){
                result.put(item,this.listOfItems.get(item));
            }
        }
        return  result;
    }
}
