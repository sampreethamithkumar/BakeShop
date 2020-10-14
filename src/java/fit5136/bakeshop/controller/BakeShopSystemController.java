package fit5136.bakeshop.controller;

import fit5136.bakeshop.entities.*;
import fit5136.bakeshop.userinterface.UserInterface;

import java.util.Scanner;

public class BakeShopSystemController {
    private BakeShop bakeshop;
    private User currentUser;
    private String userType;
    private String userInput;
    private Store CurrentStore;
    private Inventory inventory;

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
                    this.CurrentStore = store;
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
            this.CurrentStore = this.bakeshop.findStoreById(user.getStoreId());
        }
        else if(this.userType.equals("fit5136.bakeshop.entities.Staff")){
            Staff user = (Staff)this.currentUser;
            this.CurrentStore = this.bakeshop.findStoreById(user.getStoreId());
        }
        UserInterface.displayMainMenu();
        userInput = scanner.nextLine();
        if(userInput.equals("1")) //create a new order
        {	
        	UserInterface.displayAddItemPage(bakeshop.itemCountInInventory());
        	

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
}
