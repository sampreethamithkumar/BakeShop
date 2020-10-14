package fit5136.bakeshop.entities;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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
            Store store = new Store();
            store.setStoreId(Integer.parseInt(storeData[0]));
            store.setStoreName(storeData[1]);
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
    
    public Inventory itemCountInInventory() {
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
    			if (userData[0].equals(item.getItemName()))
    				inventory.addItem(item, Integer.parseInt(userData[1]));
    		}
    	}
    	
    	return inventory;
    }
}
