package fit5136.bakeshop.controller;

import fit5136.bakeshop.entities.*;
import fit5136.bakeshop.userinterface.UserInterface;


import java.util.Scanner;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.nio.file.Files.readAllLines;


public class BakeShopSystemController {
    private BakeShop bakeshop;
    private User currentUser;
    private String userType;
    private String userInput;
    private Store currentStore;


    public static void main(String[] str) {
        BakeShopSystemController controller = new BakeShopSystemController();
        controller.initialize();

    }

    /**
     * Initializer
     */
    public void initialize() {
        this.bakeshop = new BakeShop();
        Scanner scanner = new Scanner(System.in);

        /**
         * Enter User name
         */
        UserInterface.displayLoginPageUsername();
        userInput = enterUserName();
        while (!verifyEmployeeUsername(userInput)) {
            UserInterface.displayUsernameError();
            userInput = enterUserName();
        }
        userInput = null;

        /**
         * Enter User Password
         */
        UserInterface.displayLoginPagePassword();
        userInput = enterUserPassword();
        while (!verifyPassword(userInput)) {
            UserInterface.displayPasswordError();
            userInput = enterUserPassword();
        }

        userInput = null;
        this.userType = currentUser.getClass().getName();

        /**
         * Perform task based on type of user Logged In
         */
        if (userTypeIsOwner(userType)) {
            performOwnerTask();
        } else if (userTypeIsManager(userType)) {
            Manager user = (Manager) this.currentUser;
            this.currentStore = this.bakeshop.findStoreById(user.getStoreId());
        } else if (userTypeIsStaff(userType)) {
            Staff user = (Staff) this.currentUser;
            this.currentStore = this.bakeshop.findStoreById(user.getStoreId());
        }


        Boolean errorStatus = false;
        loop:
        while (true) {
            if(!errorStatus) {
                UserInterface.displayMainMenu(this.currentUser);
            }

            userInput = optionSelectedByUser();

            /**
             * Option 1 : Create Order
             * Option 2 :
             * Option 3 :
             * Option 4 : Coffee Bean sold last month
             * Option 5 : Coffee Bean sold last month?
             *
             * Option # : Logout
             * Option unknown : Error message
             */
            if (userInput.equals("1"))
            {
                createOrder();
                errorStatus = false;
                continue;
            }
            else if (userInput.equals("4") && this.userType.equals("fit5136.bakeshop.entities.Owner"))
            {
                UserInterface.displayCoffeeBeanSoldLastMonth(currentStore.generateLastMonthCoffeeBeanSold());
                userInput = optionSelectedByUser();
                while (true) {
                    if (userInput.equals("*")) {
                        errorStatus = false;
                        continue loop;
                    } else {
                        UserInterface.displayInputErrorPage();
                        continue;
                    }
                }

            }
            else if (userInput.equals("5") && this.userType.equals("fit5136.bakeshop.entities.Owner")) {
                UserInterface.displayCoffeeBeanSoldLastMonth(currentStore.generateLastMonthFoodItemSold());
                userInput = optionSelectedByUser();
                while (true) {
                    if (userInput.equals("*")) {
                        errorStatus = false;
                        continue loop;
                    } else {
                        UserInterface.displayInputErrorPage();
                        continue;
                    }
                }
            }
            else if(userInput.equals("#")){
                System.exit(0);
            }
            else {
                while(true){
                    UserInterface.displayInputErrorPage();
                    errorStatus = true;
                    continue loop;
                }
            }
        }

    }

    /**
     * Verify if employee name with user input value present
     * @param username
     * @return boolean
     */
    private Boolean verifyEmployeeUsername(String username) {
        User userAttempted = this.bakeshop.findUserByUsername(username);
        if (userAttempted == null) {
            return false;
        } else {
            this.currentUser = userAttempted;
            return true;
        }
    }

    /**
     * Verify password entered by user
     * @param password
     * @return
     */
    private Boolean verifyPassword(String password) {
        if (this.currentUser.getPassword().equals(password)) {
            return true;
        } else
            return false;
    }

    /**
     * verify item quantity entred by the user, if quantity entered is greater than inventory quantity return false
     * @param item
     * @param input
     * @return boolean
     */
    private boolean verifyInputNumber(Item item, String input) {
        int itemQuantity = -1;
        try {
            itemQuantity = Integer.parseInt(input);
            if (itemQuantity > currentStore.getInventory().getItemNum(item)) {
                UserInterface.displayNumberGreaterThanInventory();
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Check if the logged in user is Owner
     * @param userType
     * @return boolean
     */
    private boolean userTypeIsOwner(String userType) {
        return userType.equals("fit5136.bakeshop.entities.Owner");
    }

    /**
     * If the logged in user is owner perform owner features
     */
    private void performOwnerTask() {
        UserInterface.displayOwnerWelcomePage();
        userInput = optionSelectedByUser();
        while (true) {
            if (userInput.equals("1")) {
                userInput = null;
                UserInterface.displayStoreList(this.bakeshop.getListOfStore());
                userInput = optionSelectedByUser();
                Store store = findStoreByInputId(userInput);
                while (store == null) {
                    UserInterface.displayInputErrorPage();
                    userInput = optionSelectedByUser();
                    store = findStoreByInputId(userInput);
                }
                this.currentStore = store;
                break;
            } else if (userInput.equals("2")) {
                System.exit(0);
            } else {
                UserInterface.displayInputErrorPage();
                userInput = optionSelectedByUser();
            }
        }
    }

    /**
     * find the store by store input number
     * @param userInput
     * @return Store
     */
    private Store findStoreByInputId(String userInput) {
        return this.bakeshop.findStoreById(Integer.parseInt(userInput));
    }

    /**
     * check if the user logged in is Mangaer
     * @param userType
     * @return boolean
     */
    private boolean userTypeIsManager(String userType) {
        return this.userType.equals("fit5136.bakeshop.entities.Manager");
    }

    /**
     * check if the user logged in is Staff
     * @param userType
     * @return boolean
     */
    private boolean userTypeIsStaff(String userType){
        return this.userType.equals("fit5136.bakeshop.entities.Staff");
    }

    /**
     * Create order function
     */
    private void createOrder() {
        Scanner scanner = new Scanner(System.in);
        Order order = new Order();

        boolean endCreating = false;
        while (!endCreating) {
            /**
             * Search an Item by entering the prefix.
             */
            UserInterface.displaySearchFunction();
            String itemName;

            /**
             * Loop as long as the user enters the right prefix.
             */
            List<String> itemsNameFromSearch = null;
            while (itemsNameFromSearch == null){
                itemName = optionSelectedByUser();
                itemsNameFromSearch = searchItemInInventoryByPrefixEntered(itemName);
                UserInterface.displayItemsFromSearchResult(itemsNameFromSearch);
            }

            /**
             * Ask the user to enter the Item from the result returned.
             */
            UserInterface.displayEnterItemFromSearch();
            itemName = optionSelectedByUser();
            Item currentItem = new Item();
            boolean isItemFind = false;
            while (!isItemFind) {
                currentItem = returnItemFromUserInput(itemName);
                if (currentItem == null){
                    UserInterface.displayNoSuchItemFound();
                    itemName = scanner.nextLine();
                }
                else{
                    isItemFind = true;
                }
            }

            /**
             * Ask the user to enter the item quantity.
             */
            int itemQuantity;
            UserInterface.displayEnterItemQuantity();
            while (true) {
                userInput = optionSelectedByUser();
                if (verifyInputNumber(currentItem, userInput)) {
                    itemQuantity = Integer.parseInt(userInput);
                    break;
                } else
                    continue;
            }

            /**
             * Creating the order and updating to txt file
             */
            order.addToList(currentItem, itemQuantity);
            UserInterface.displayEnterCustomerName();
            String customerName = scanner.nextLine();
            order = addOrderDetails(order,calculateTotalCost(order),customerName);
            writeOrderToTxt(order);
            writeOrderLineToTxt(order);
        }
    }

    /**
     * return the Item entered by user
     * @param userInput
     * @return Item
     */
    private Item returnItemFromUserInput(String userInput) {
        List<Item> items = currentStore.getInventory().getListItems();
        for (Item item : items) {
            if (item.getItemName().equals(userInput)) {
                return item;
            }
        }
        return null;
    }

    /**
     * add the order details
     * @param order
     * @param totalCost
     * @param customerName
     * @return Order
     */
    private Order addOrderDetails(Order order,double totalCost,String customerName){
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
        order.setStoreId(currentStore.getStoreId());
        order.setTotalCost(totalCost);
        order.setNameOfCustomer(customerName);
        return order;
    }

    /**
     * calculate total cost of the order
     * @param order
     * @return double
     */
    private double calculateTotalCost(Order order){
        double totalCost = 0;
        for (Item item : order.getListOfItem().keySet()) {
            totalCost += item.getCostPerItem() * order.getListOfItem().get(item);
        }
        return totalCost;
    }

    /**
     * write order to txt file
     * @param order
     */
    private void writeOrderToTxt(Order order){
        Path path = Paths.get("order.txt");
        try {
            int length = 0;
            length = readAllLines(path).size();
            order.setOrderNumber(++length);
            List<String> line = new ArrayList<>();
            line.add(order.getCreatedBy() + ";" + order.getOrderDate() + ";" + order.getOrderTime() + ";" + order.getOrderStatus() + ";" + order.getNameOfCustomer() + ";" + order.getTotalCost() + ";" + order.getOrderNumber() + ";" + order.getStoreId());
            Files.write(path, line, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * write order line to txt
     * @param order
     */
    private void writeOrderLineToTxt(Order order){
        Path orderLinePath = Paths.get("orderLine.txt");

        try {
            List<String> lines = new ArrayList<>();
            for (Item item : order.getListOfItem().keySet()) {
                lines.add(order.getOrderNumber() + ";" + item.getItemNum() + ";" + order.getListOfItem().get(item));
            }
            Files.write(orderLinePath, lines, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String enterUserName(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private String enterUserPassword(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private String optionSelectedByUser(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    /**
     * search item in inventory by the prefix entered
     * @param prefix
     * @return List<String>
     */
    private List<String> searchItemInInventoryByPrefixEntered(String prefix){
        if (prefix== null || prefix.length()==0)
            return null;

        if (prefix.length() > 1){
            String firstCharacter = Character.toString(prefix.charAt(0)).toUpperCase();
            String remainingPartOfString = prefix.substring(1).toLowerCase();
            prefix = firstCharacter + remainingPartOfString;
        }

        if (prefix.length() == 1)
            prefix = Character.toString(prefix.charAt(0)).toUpperCase();

        List<Item> items = currentStore.getInventory().getListItems();
        List<String> itemsName = new ArrayList<>();
        Pattern pattern = Pattern.compile(prefix);
        for (Item item: items){
            if (pattern.matcher(item.getItemName()).find())
                itemsName.add(item.getItemName());
        }
        return itemsName;
    }
}
