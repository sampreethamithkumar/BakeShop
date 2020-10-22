package fit5136.bakeshop.entities;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static java.nio.file.Files.readAllLines;

public class Store {

    private int storeId;
    private String storeName;
    private String storeAddress;
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
        inventory.setStoreId(this.getStoreId());
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
        ArrayList<Order> orders = new ArrayList<>();
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
        this.listOfOrders = orders;

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

    public void generateSales(){

    }
    public String generateLastMonthCoffeeBeanSold(){
//        2020/10/14;21:49:14

        int amount = 0;
        for (Order order: listOfOrders) {
            String s = order.getOrderDate();
            DateFormat dateFormat = new SimpleDateFormat("yyyy");
            String year = dateFormat.format(new Date());
            DateFormat dateFormat1 = new SimpleDateFormat("MM");
            String month = dateFormat1.format(new Date());
            String[] s1 = s.split("/");
            if (s1[0].equals(year) && Integer.parseInt(s1[1]) == (Integer.parseInt(month)-1)) {
                HashMap<Item, Integer> items = order.getListOfItem();
                for (Item item : items.keySet())
                    if (item.getType().equals("coffeeBean")) {
                        amount += items.get(item);
                    }
            }


        }
        return "The coffee bean sold in last month is " + amount;
    }

    public String generateLastMonthFoodItemSold(){
        int amount = 0;
        for (Order order: listOfOrders) {
            String s = order.getOrderDate();
            DateFormat dateFormat = new SimpleDateFormat("yyyy");
            String year = dateFormat.format(new Date());
            DateFormat dateFormat1 = new SimpleDateFormat("MM");
            String month = dateFormat1.format(new Date());
            String[] s1 = s.split("/");
            if (s1[0].equals(year) && Integer.parseInt(s1[1]) == (Integer.parseInt(month)-1)) {
                HashMap<Item, Integer> items = order.getListOfItem();
                for (Item item : items.keySet())
                    if (item.getType().equals("foodItem")) {
                        amount += items.get(item);
                    }
            }


        }
        return "The food item sold in last month is " + amount;
    }

    public String generateLastMonthCoffeeSold(){
        int amount = 0;
        for (Order order: listOfOrders) {
            String s = order.getOrderDate();
            DateFormat dateFormat = new SimpleDateFormat("yyyy");
            String year = dateFormat.format(new Date());
            DateFormat dateFormat1 = new SimpleDateFormat("MM");
            String month = dateFormat1.format(new Date());
            String[] s1 = s.split("/");
            if (s1[0].equals(year) && Integer.parseInt(s1[1]) == (Integer.parseInt(month)-1)) {
                HashMap<Item, Integer> items = order.getListOfItem();
                for (Item item : items.keySet())
                    if (item.getType().equals("coffee")) {
                        amount += items.get(item);
                    }
            }


        }
        return "The coffee sold in last month is " + amount;
    }

    public String generatePeakDayLastMonth() {
        double peakDayCost = 0;
        int peakDay = 0;
        for (int day = 1; day <= 31; day++) {
            double costPerDay = 0;
            for (Order order : listOfOrders) {
                String s = order.getOrderDate();
                DateFormat dateFormat = new SimpleDateFormat("yyyy");
                String year = dateFormat.format(new Date());
                DateFormat dateFormat1 = new SimpleDateFormat("MM");
                String month = dateFormat1.format(new Date());
                DateFormat dateFormat2 = new SimpleDateFormat("dd");
                String days = dateFormat2.format(new Date());
                String[] s1 = s.split("/");
                if (s1[0].equals(year) && Integer.parseInt(s1[1]) == (Integer.parseInt(month) - 1) && Integer.parseInt(days) == day) {
                    costPerDay += order.getTotalCost();
                }
            }
            if(costPerDay > peakDayCost){
                peakDayCost = costPerDay;
                peakDay = day;

            }
        }
        return "The peak day in last month is " + peakDay + " with sale of " + peakDayCost;
    }

    public String generateLastMonthTotalSale(){
        int sale = 0;
        for (Order order: listOfOrders) {
            String s = order.getOrderDate();
            DateFormat dateFormat = new SimpleDateFormat("yyyy");
            String year = dateFormat.format(new Date());
            DateFormat dateFormat1 = new SimpleDateFormat("MM");
            String month = dateFormat1.format(new Date());
            String[] s1 = s.split("/");
            if (s1[0].equals(year) && Integer.parseInt(s1[1]) == (Integer.parseInt(month)-1)) {
                sale += order.getTotalCost();
            }


        }
        return "The total sale in last month is " + sale;
    }

    public String generateItemLowInInventory(){
        HashMap<Item,Integer> items = this.inventory.generateItemLow();
        String report = "";
        int index = 1;
        for (Item item : items.keySet()){
            report += index + ". " + item.getItemName() + " with quantity: " + items.get(item) + "\n";
            index++;
        }
        return "The items low in inventory is: \n" + report;
    }

}
