package fit5136.bakeshop.userinterface;

import fit5136.bakeshop.entities.Store;
import fit5136.bakeshop.entities.Inventory;
import fit5136.bakeshop.entities.User;

import java.util.List;

public class UserInterface {
    public static void displayLoginPageUsername(){
        System.out.println("===================================");
        System.out.println("             Bake Shop             ");
        System.out.println("===================================");
        System.out.println("");
        System.out.println("  *************Login************  ");
        System.out.println("");
        System.out.println("    Please input your username:    ");
        System.out.print("        ");
    }
    public static void displayUsernameError(){
        System.out.println("        username is invalid!!      ");
        System.out.println("        Please input again:        ");
        System.out.print("        ");
    }
    public static void displayLoginPagePassword(){
        for(int i = 0; i < 50; i++){
            System.out.println("");
        }
        System.out.println("===================================");
        System.out.println("             Bake Shop             ");
        System.out.println("===================================");
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
        for(int i = 0; i < 50; i++){
            System.out.println("");
        }
        System.out.println("===================================");
        System.out.println("             Bake Shop             ");
        System.out.println("===================================");
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
        for(int i = 0; i < 50; i++){
            System.out.println("");
        }
        System.out.println("===================================");
        System.out.println("             Bake Shop             ");
        System.out.println("===================================");
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
    public static void displayMainMenu(User user){
        for(int i = 0; i < 50; i++){
            System.out.println("");
        }
        System.out.println("===================================");
        System.out.println("             Bake Shop             ");
        System.out.println("===================================");
        System.out.println("         Welcome to BakeShop       ");
        System.out.println("===================================");
        System.out.println("");
        System.out.println("         choose you option:        ");
        System.out.println("1.Add new orders");
        System.out.println("2.View or complete orders");
        System.out.println("3.Update or delete orders");
        if (user.getClass().getName().equals("fit5136.bakeshop.entities.Owner")){
            System.out.println("4.Coffee bean sold last month");
            System.out.println("5.Food item sold last month");
        }
        System.out.println("");
        System.out.println("");
        System.out.println("#.Logout");
        System.out.println("");
        System.out.println("");
    }

    public static void displayInputErrorPage(){
        System.out.print("        ");
        System.out.println(" invalid!!Please input again:        ");
        System.out.print("        ");

    }

    public static void displayAddItemPage(Inventory inventory){
        for(int i = 0; i < 50; i++){
            System.out.println("");
        }
        System.out.println("===================================");
        System.out.println("             Bake Shop             ");
        System.out.println("===================================");
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
        System.out.print("   Please Enter the item Quantity:   ");
    }

    public static void displayNoSuchItemFound(){
        System.out.print("   No Such Item Found:   ");
        System.out.println("");
        System.out.print("   Please Enter the Item Again   ");
    }

    public static void displayEnterNumber(){
        for(int i = 0; i < 50; i++){
            System.out.println("");
        }
        System.out.println("===================================");
        System.out.println("             Bake Shop             ");
        System.out.println("===================================");
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
        System.out.println("   Please enter Customer Name:    ");
    }

    public static void displayErrorNumber(){
        for(int i = 0; i < 50; i++){
            System.out.println("");
        }
        System.out.println("===================================");
        System.out.println("             Bake Shop             ");
        System.out.println("===================================");
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
        for(int i = 0; i < 50; i++){
            System.out.println("");
        }
        System.out.println("===================================");
        System.out.println("             Bake Shop             ");
        System.out.println("===================================");
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
}
