package fit5136.bakeshop.entities;

import java.util.ArrayList;

public class Store {

    private int storeId;
    private String storeName;
    private String storeAddress;
    private ArrayList<Sale> listOfSales;
    private Inventory inventory;
    private ArrayList<Staff> listOfStaff;
    private Manager manager;

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public ArrayList<Sale> getListOfSales() {
        return listOfSales;
    }

    public void setListOfSales(ArrayList<Sale> listOfSales) {
        this.listOfSales = listOfSales;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public ArrayList<Staff> getListOfStaff() {
        return listOfStaff;
    }

    public void setListOfStaff(ArrayList<Staff> listOfStaff) {
        this.listOfStaff = listOfStaff;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
