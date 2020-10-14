package fit5136.bakeshop.entities;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.nio.file.Files.readAllLines;

public class BakeShop {

    private List<Store> listOfStore;
    private List<User> listOfUser;

    public BakeShop() {
        List<Owner> owners = new ArrayList<Owner>();
        List<Staff> staffs = new ArrayList<Staff>();
        List<Manager> managers = new ArrayList<Manager>();
        listOfUser = new ArrayList<User>();
        listOfStore = new ArrayList<Store>();
        //read owner
        Path path = Paths.get("owner.txt");
        List<String> userDatas = null;
        try {
            userDatas = (readAllLines(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String userLine : userDatas) {
            String[] userData = userLine.split(";");
            Owner owner = new Owner(Integer.parseInt(userData[0]), userData[1], userData[2], userData[3], userData[4], userData[5], Integer.parseInt(userData[6]));
            owners.add(owner);
        }
        listOfUser.addAll(owners);
        //read manager
        path = Paths.get("manager.txt");
        userDatas = null;
        try {
            userDatas = (readAllLines(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String userLine : userDatas) {
            String[] userData = userLine.split(";");
            Manager manager = new Manager(Integer.parseInt(userData[0]), userData[1], userData[2], userData[3], userData[4], userData[5], Integer.parseInt(userData[6]), Integer.parseInt(userData[7]));
            managers.add(manager);
        }
        listOfUser.addAll(managers);
        ///read staff
        path = Paths.get("staff.txt");
        userDatas = null;
        try {
            userDatas = (readAllLines(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String userLine : userDatas) {
            String[] userData = userLine.split(";");
            Staff staff = new Staff(Integer.parseInt(userData[0]), userData[1], userData[2], userData[3], userData[4], userData[5], Integer.parseInt(userData[6]), Integer.parseInt(userData[7]));
            staffs.add(staff);
        }
        listOfUser.addAll(staffs);
        path = Paths.get("stores.txt");
        List<String> storeDatas = null;
        try {
            storeDatas = (readAllLines(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String storeLine : storeDatas) {
            String[] storeData = storeLine.split(";");
            Store store = new Store(Integer.parseInt(storeData[0]));
            store.setStoreName(storeData[1]);
            Manager manager = null;
            for (User user:this.listOfUser){
                if(user.getClass().getName().equals("fit5136.bakeshop.entities.Manager")){
                    Manager target = (Manager)user;
                    if(target.getStoreId() == store.getStoreId()){
                        manager = target;
                    }
                }
            }
            store.setManager(manager);
            ArrayList<Staff> staffList = new ArrayList<>();
            for (User user:this.listOfUser){
                if(user.getClass().getName().equals("fit5136.bakeshop.entities.Staff")){
                    Staff target = (Staff)user;
                    if(target.getStoreId() == store.getStoreId()){
                        staffList.add(target);
                    }
                }
            }
            store.setListOfStaff(staffList);
            this.listOfStore.add(store);
        }
    }

    public List<Store> getListOfStore() {
        return listOfStore;
    }

    public void setListOfStore(List<Store> listOfStore) {
        this.listOfStore = listOfStore;
    }

    public List<User> getListOfUser() {
        return listOfUser;
    }

    public void setListOfUser(List<User> listOfUser) {
        this.listOfUser = listOfUser;
    }

    public User findUserByUsername(String username) {
        for (User user : listOfUser) {
            if (user.getEmployeeName().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public Store findStoreById(int id) {
        for (Store store : listOfStore) {
            if (store.getStoreId() == id) {
                return store;
            }
        }
        return null;
    }
    

    


    public boolean checkItemPresent(String itemName){
        List<Item> items = items();

        for (Item item: items){
            if (item.getItemName().equals(itemName))
                return true;
        }
        return false;
    }

    private Item findItemByName(String itemName){
        List<Item> items = items();

        for (Item item: items){
            if (item.getItemName().equals(itemName))
                return item;
        }
        return null;
    }

    public void addItemToOrder(String itemName,int itemQuantity){
        Item item = findItemByName(itemName);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String date = new Date().toString();
        DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String time = new Date().toString();

    }

    public List<Item> items() {
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
}
