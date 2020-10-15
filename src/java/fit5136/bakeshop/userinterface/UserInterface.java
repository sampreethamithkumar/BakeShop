package fit5136.bakeshop.userinterface;

import fit5136.bakeshop.entities.Store;
import fit5136.bakeshop.entities.Inventory;

import java.util.List;

public class UserInterface {
    public static void displayLoginPageUsername(){
        displayBakeShop();
        System.out.println("");
        System.out.println("  *************Login************  ");
        System.out.println("");
        System.out.println("    Please input your username:    ");
        System.out.print("        ");
    }
    public static void displayUsernameError(){
        displayBakeShop();
        System.out.println("        username is invalid!!      ");
        System.out.println("        Please input again:        ");
        System.out.print("        ");
    }
    public static void displayLoginPagePassword(){
        displayBakeShop();
        System.out.println("");
        System.out.println("  *************Login************  ");
        System.out.println("");
        System.out.println("    Please input your password:    ");
        System.out.println("");
        System.out.println("");
        System.out.print("        ");
    }
    public static void displayPasswordError(){
        System.out.println("        password is invalid!!      ");
        System.out.println("        Please input again:        ");
        System.out.print("        ");
    }

    public static void displayOwnerWelcomePage(){
        displayBakeShop();
        System.out.println("");
        System.out.println("  *********Welcome Owner*********  ");
        System.out.println("");
        System.out.println("    Please enter your options:    ");
        System.out.println("1.check stores");
        System.out.println("2.logout");
        System.out.println("");
        System.out.println("");
    }
    public static void displayStoreList(List<Store> stores){
        displayBakeShop();
        System.out.println("");
        System.out.println("  *********Welcome Owner*********  ");
        System.out.println("");
        System.out.println("     Please choose your store:     ");
        for (Store store : stores){
            System.out.println(store.getStoreId() + ". " + store.getStoreName());
        }
        System.out.println("");
        System.out.println("");
        System.out.println("#.logout");
        System.out.println("");
        System.out.println("");
    }
    public static void displayMainMenu(){
        displayBakeShop();
        System.out.println("         Welcome to BakeShop       ");
        System.out.println("===================================");
        System.out.println("");
        System.out.println("         choose you option:        ");
        System.out.println("1.Add new orders");
        System.out.println("2.View or complete orders");
        System.out.println("3.Update or delete orders");
        System.out.println("");
        System.out.println("");
        System.out.println("#.Logout");
        System.out.println("");
        System.out.println("");
    }

    public static void displayInputErrorPage(){
        displayBakeShop();
        System.out.print("          invalid!!             ");
        System.out.println();
        System.out.println("   Please input again:        ");
        System.out.print("        ");

    }

    public static void displayAddItemPage(Inventory inventory){
        displayBakeShop();
        System.out.println("         Create a new order        ");
        System.out.println("===================================");
        System.out.println("");
        System.out.println("   Please choose an item to add:   ");
        System.out.println(inventory.getItemNameList());
        System.out.println("");
        System.out.println("");
        System.out.println("*.Finish the order");
        System.out.println("#.Logout");
        System.out.println("");
        System.out.println("");

    }

    public static void displayEnterItemQuantity(){
        displayBakeShop();
        System.out.print("   Please Enter the item Quantity:   ");
    }

    public static void displayNoSuchItemFound(){
        displayBakeShop();
        System.out.print("   !!No Such Item Found!!   ");
        System.out.println("");
        System.out.print("   Please Enter the Item Again   ");
    }

    public static void displayEnterNumber(){
        displayBakeShop();
        System.out.println("         Create a new order        ");
        System.out.println("===================================");
        System.out.println("");
        System.out.println("Please enter the Number of the item:");
        System.out.println("");
        System.out.println("");
        System.out.println("#.Logout");
        System.out.println("");
        System.out.println("");

    }

    public static void displayEnterCustomerName(){
        displayBakeShop();
        System.out.println("         Enter Customer Name        ");
        System.out.println("===================================");
        System.out.println("");
        System.out.println("   Please enter Customer Name:    ");
    }

    public static void displayErrorNumber(){
        displayBakeShop();
        System.out.println("         Create a new order        ");
        System.out.println("===================================");
        System.out.println("");
        System.out.println("           Error input             ");
        System.out.println("");
        System.out.println("Please enter the Number of the item:");
        System.out.println("");
        System.out.println("");
        System.out.println("#.Logout");
        System.out.println("");
        System.out.println("");
    }

    public static void displayNumberGreaterThanInventory(){
        displayBakeShop();
        System.out.println("         Create a new order        ");
        System.out.println("===================================");
        System.out.println("");
        System.out.println("The input number is greater than inventory");
        System.out.println("");
        System.out.println("Please enter the Number of the item:");
        System.out.println("");
        System.out.println("");
        System.out.println("#.Logout");
        System.out.println("");
        System.out.println("");
    }

    public static void displayBakeShop(){
        for(int i = 0; i < 50; i++){
            System.out.println("");
        }
        System.out.println("===================================");
        System.out.println("             Bake Shop             ");
        System.out.println("===================================");
    }

}
