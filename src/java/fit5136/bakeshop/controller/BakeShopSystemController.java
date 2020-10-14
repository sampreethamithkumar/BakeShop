package fit5136.bakeshop.controller;

import com.sun.deploy.security.SelectableSecurityManager;
import fit5136.bakeshop.entities.*;
import fit5136.bakeshop.userinterface.UserInterface;

import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.nio.file.Files.readAllLines;

public class BakeShopSystemController {
    private BakeShop bakeshop;
    private User currentUser;
    private String userType;
    private String userInput;
    private Store currentStore;

    private static int orderId;


    public static void main(String[] str) {
        BakeShopSystemController controller = new BakeShopSystemController();
        controller.initialize();

    }
    public void initialize() {
        this.bakeshop = new BakeShop();
        Scanner scanner = new Scanner(System.in);
        //enter username
        UserInterface.displayLoginPageUsername();
        userInput = scanner.nextLine();
        while (!verifyEmployeeUsername(userInput)){
            UserInterface.displayUsernameError();
            userInput = scanner.nextLine();
        }
        userInput = null;
        //enter password
        UserInterface.displayLoginPagePassword();
        userInput = scanner.nextLine();
        while (!verifyPassword(userInput)){
            UserInterface.displayPasswordError();
            userInput = scanner.nextLine();
        }
        userInput = null;
        this.userType = currentUser.getClass().getName();
        System.out.println(this.userType);
        if (this.userType.equals("fit5136.bakeshop.entities.Owner")){
            UserInterface.displayOwnerWelcomePage();
            userInput = scanner.nextLine();
            while(true) {
                if (userInput.equals("1")) {
                    userInput = null;
                    UserInterface.displayStoreList(this.bakeshop.getListOfStore());
                    userInput = scanner.nextLine();
                    Store store = this.bakeshop.findStoreById(Integer.parseInt(userInput));
                    while (store == null) {
                        UserInterface.displayInputErrorPage();
                        userInput = scanner.nextLine();
                        store = this.bakeshop.findStoreById(Integer.parseInt(userInput));
                    }
                    this.currentStore = store;
                    break;
                } else if (userInput.equals("2")) {
                    System.exit(0);
                } else{
                    UserInterface.displayInputErrorPage();
                    userInput = scanner.nextLine();
                }
            }

        }
        else if(this.userType.equals("fit5136.bakeshop.entities.Manager")){
            Manager user = (Manager)this.currentUser;
            this.currentStore = this.bakeshop.findStoreById(user.getStoreId());
        }
        else if(this.userType.equals("fit5136.bakeshop.entities.Staff")){
            Staff user = (Staff)this.currentUser;
            this.currentStore = this.bakeshop.findStoreById(user.getStoreId());
        }
        UserInterface.displayMainMenu();
        userInput = scanner.nextLine();
        if(userInput.equals("1")) //create a new order
        {
            Order order = new Order();

            boolean endCreating= false;
            while(!endCreating){
                UserInterface.displayAddItemPage(currentStore.getInventory());
                String itemName = scanner.nextLine();
                if(itemName.equals("*")){
                    break;
                }
                Item currentItem = new Item();
                List<Item> items = currentStore.getInventory().getListItems();
                boolean isItemFind = false;
                while(!isItemFind) {
                    for (Item item : items) {
                        if (item.getItemName().equals(itemName)) {
                            currentItem = item;
                            isItemFind = true;
                            break;
                        }
                    }
                    if(!isItemFind) {
                        UserInterface.displayNoSuchItemFound();
                        itemName = scanner.nextLine();
                    }
                }
                int itemQuantity;

                UserInterface.displayEnterItemQuantity();
                while(true){
                    userInput = scanner.nextLine();
                    if(verifyInputNumber(currentItem,userInput)){
                        itemQuantity = Integer.parseInt(userInput);
                        break;
                    }
                    else
                        continue;
                }

                order.addToList(currentItem,itemQuantity);

            }
            UserInterface.displayEnterCustomerName();
            String customerName = scanner.nextLine();
            double totalCost = 0;
            for (Item item: order.getListOfItem().keySet()){
                totalCost += item.getCostPerItem() * order.getListOfItem().get(item);
            }
            String orderStatus = "preparing";
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date currentDate = new Date();
            String date = dateFormat.format(currentDate);
            DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
            Date currentTime = new Date();
            String time = timeFormat.format(currentTime);
            order.setCreatedBy(currentUser.getEmployeeName());
            order.setOrderStatus(orderStatus);
            order.setOrderDate(date);
            order.setOrderTime(time);
            Path path = Paths.get("order.txt");
            Path orderLinePath = Paths.get("orderLine.txt");
            int length = 0;
            try{
                length = readAllLines(path).size();
                length++;
                List<String> line = new ArrayList<>();
                line.add(currentUser.getEmployeeName() + ";" + date + ";" + time + ";" + orderStatus + ";" +customerName + ";" + totalCost + ";" + (length) + ";" +currentStore.getStoreId());
                Files.write(path, line, StandardCharsets.UTF_8, StandardOpenOption.APPEND);}
            catch(Exception e){

            }

            try{
                List<String> lines = new ArrayList<>();
                for (Item item : order.getListOfItem().keySet()) {
                    lines.add(length + ";" + item.getItemNum() + ";" + order.getListOfItem().get(item) );
                }
                    Files.write(orderLinePath, lines, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            }
            catch (Exception e){

            }

        }
    }

    public Boolean verifyEmployeeUsername(String username) {
        User userAttempted = this.bakeshop.findUserByUsername(username);
        if (userAttempted == null) {
            return false;
        } else {
            this.currentUser = userAttempted;
            return true;
        }
    }

    public Boolean verifyPassword(String password){
        if (this.currentUser.getPassword().equals(password)){
            return true;
        }
        else
            return false;
    }

    public boolean verifyInputNumber(Item item, String input){
        int itemQuantity = -1;
        try {
            itemQuantity = Integer.parseInt(input);
            if(itemQuantity > currentStore.getInventory().getItemNum(item)){
                UserInterface.displayNumberGreaterThanInventory();
                return false;
            }
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }

}
