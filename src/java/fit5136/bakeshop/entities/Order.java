package fit5136.bakeshop.entities;

import java.util.HashMap;

public class Order {
    private HashMap<Item, Integer> listOfItem;
    private String createdBy;
    private String orderData;
    private String orderTime;
    private boolean orderStatus;
    private String nameOfCustomer;
    private double totalCost;
    private int orderNumber;

    public Order(HashMap<Item, Integer> listOfItem, String createdBy, String orderData, String orderTime, boolean orderStatus, String nameOfCustomer, double totalCost, int orderNumber) {
        this.listOfItem = listOfItem;
        this.createdBy = createdBy;
        this.orderData = orderData;
        this.orderTime = orderTime;
        this.orderStatus = orderStatus;
        this.nameOfCustomer = nameOfCustomer;
        this.totalCost = totalCost;
        this.orderNumber = orderNumber;
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

    public String getOrderData() {
        return orderData;
    }

    public void setOrderData(String orderData) {
        this.orderData = orderData;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public boolean isOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(boolean orderStatus) {
        this.orderStatus = orderStatus;
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
}
