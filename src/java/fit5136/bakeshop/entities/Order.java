package fit5136.bakeshop.entities;

import java.util.HashMap;

public class Order {
    private HashMap<Item, Integer> listOfItem;
    private String createdBy;
    private String orderDate;
    private String orderTime;
    private String orderStatus;
    private String nameOfCustomer;
    private double totalCost;
    private int orderNumber;
    private int storeId;

    public Order(HashMap<Item, Integer> listOfItem, String createdBy, String orderDate, String orderTime, String orderStatus, String nameOfCustomer, double totalCost, int orderNumber, int storeId) {
        this.listOfItem = listOfItem;
        this.createdBy = createdBy;
        this.orderDate = orderDate;
        this.orderTime = orderTime;
        this.orderStatus = orderStatus;
        this.nameOfCustomer = nameOfCustomer;
        this.totalCost = totalCost;
        this.orderNumber = orderNumber;
        this.storeId = storeId;
    }

    public Order(){
        this.listOfItem = new HashMap<Item, Integer>();
    }

    public HashMap<Item, Integer> getListOfItem() {
        return listOfItem;
    }

    public void setListOfItem(HashMap<Item, Integer> listOfItem) {
        this.listOfItem = listOfItem;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getNameOfCustomer() {
        return nameOfCustomer;
    }

    public void setNameOfCustomer(String nameOfCustomer) {
        this.nameOfCustomer = nameOfCustomer;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void addToList(Item item, int quanity){
        listOfItem.put(item,quanity);
    }
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    @Override
    public String toString(){
        //
        return "";
    }
}
