package fit5136.bakeshop.entities;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.nio.file.Files.readAllLines;

public class Store {

    private int storeId;
    private String storeName;
    private String storeAddress;
    private ArrayList<Sale> listOfSales;
    private ArrayList<Order> listOfOrders;
    private Inventory inventory;
    private ArrayList<Staff> listOfStaff;
    private Manager manager;
    public Store(int storeId){
        this.storeId = storeId;
        Path path = Paths.get("inventory.txt");
        List<String> userDatas = null;
        List<Item> items = items();
        Inventory inventory = new Inventory();
        try {
            userDatas = readAllLines(path);
        }
        catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        for (String inventoryItem : userDatas) {
            String[] userData = inventoryItem.split(";");
            for (Item item: items) {
                if (userData[1].equals(item.getItemName())&&userData[0].equals(storeId+"")){
                    inventory.addItem(item, Integer.parseInt(userData[2]));

                }
            }
        }
        this.inventory = inventory;
        path = Paths.get("order.txt");
        userDatas = null;
        List<Order> orders = new ArrayList<>();
        try {
            userDatas = readAllLines(path);
        }
        catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        for (String orderData : userDatas) {
            String[] orderDataLine = orderData.split(";");
            if(Integer.parseInt(orderDataLine[7]) == this.storeId){
            Order order = new Order();
            order.setCreatedBy(orderDataLine[0]);
            order.setOrderDate(orderDataLine[1]);
            order.setOrderTime(orderDataLine[2]);
            order.setOrderStatus(orderDataLine[3]);
            order.setNameOfCustomer(orderDataLine[4]);
            order.setTotalCost(Double.parseDouble(orderDataLine[5]));
            order.setOrderNumber(Integer.parseInt(orderDataLine[6]));
            order.setStoreId(this.storeId);
            Path orderLinePath = Paths.get("orderLine.txt");
            List<String> orderLineData = null;
            HashMap<Item,Integer> itemsLines = new HashMap<>();
            try {
                orderLineData = readAllLines(orderLinePath);
            }
            catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            for (String line : orderLineData){

                String[] orderLine = line.split(";");
                if( Integer.parseInt(orderLine[0]) == order.getOrderNumber()){
                Item orderItem = null;
                for (Item item : this.getInventory().getListItems()){
                    if(item.getItemNum() == Integer.parseInt(orderLine[1])){
                        orderItem = item;
                    }
                }
                itemsLines.put(orderItem,Integer.parseInt(orderLine[2]));}
            }
            order.setListOfItem(itemsLines);
            orders.add(order);}
        }
    }
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

    public ArrayList<Order> getListOfOrders() {
        return listOfOrders;
    }

    public void setListOfOrders(ArrayList<Order> listOfOrders) {
        this.listOfOrders = listOfOrders;
    }

    private List<Item> items() {
        Path path = Paths.get("item.txt");
        List<String> userDatas = null;
        List<Item> listOfItem = new ArrayList<>();
        try {
            userDatas = readAllLines(path);
        }
        catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        for (String items : userDatas) {
            String[] userData = items.split(";");
            Item item = new Item(Integer.parseInt(userData[0]),userData[1],Integer.parseInt(userData[2]),userData[3]);
            listOfItem.add(item);
        }
        return listOfItem;
    }
    public void generateLastMonthCoffeeBeanSold(){
        Sale lastMonthSale = this.listOfSales.get(-1);
        System.out.println("The coffee bean sold in last month is " + lastMonthSale.getCoffeeBeanSold());
    }

    public void generateLastMonthFoodItemSold(){
        Sale lastMonthSale = this.listOfSales.get(-1);
        System.out.println("The coffee bean sold in last month is " + lastMonthSale.getFoodItemSold());
    }

}
