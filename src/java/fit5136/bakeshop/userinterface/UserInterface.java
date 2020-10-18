package fit5136.bakeshop.userinterface;

import fit5136.bakeshop.entities.Item;
import fit5136.bakeshop.entities.Store;
import fit5136.bakeshop.entities.Inventory;
import fit5136.bakeshop.entities.User;

import java.util.HashMap;
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

    public static void displayMainMenu() {
        displayBakeShop();
    }
    public static void displayMainMenu(User user){
        displayBakeShop();
        System.out.println("         Welcome to BakeShop       ");
        System.out.println("===================================");
        System.out.println("");
        System.out.println("         choose you option:        ");
        System.out.println("1.Add new orders");
        System.out.println("2.View or complete orders");
        System.out.println("3.Update or delete orders");
        if (user.getClass().getName().equals("fit5136.bakeshop.entities.Owner")){
            System.out.println("4.Reports of last month");
        }
        System.out.println("");
        System.out.println("#.Logout");
        System.out.println("");
    }

    public static void displayInputErrorPage(){
        System.out.print("        invalid input!!          ");
        System.out.println();
        System.out.println("   Please input again:        ");
        System.out.print("");

    }


    public static void displayEnterItemQuantity(){
        displayBakeShop();
        System.out.print("   Please Enter the item Quantity:   ");
        System.out.println("");
    }

    public static void displayNoSuchItemFound(){
        displayBakeShop();
        System.out.print("   !!No Such Item Found!!   ");
        System.out.println("");
    }

    public static void displayEnterNumber(){
        displayBakeShop();
        System.out.println("         Create a new order        ");
        System.out.println("===================================");
        System.out.println("");
        System.out.println("Please enter the Number of the item:");
        System.out.println("");
        System.out.println("#.Back to Main Page");
        System.out.println("");
    }

    public static void displayEnterCustomerName(){
        displayBakeShop();
        System.out.println("        Enter Customer Name        ");
        System.out.println("===================================");
        System.out.println("");
        System.out.println("   Please enter Customer Name:    ");
        System.out.println("");
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
    }

    public static void displayReportMenu(){
        displayBakeShop();
        System.out.println("         Welcome to BakeShop       ");
        System.out.println("===================================");
        System.out.println("");
        System.out.println("Choose the report you want to check");
        System.out.println("");
        System.out.println("1.Coffee bean sold last month");
        System.out.println("2.Food item sold last month");
        System.out.println("3.Coffee Sold last month");
        System.out.println("4.Peak Day Of The Month");
        System.out.println("5.Last Month Total Sale");
        System.out.println("6.Item low in inventory");
        System.out.println("");
        System.out.println("*.Return to main menu");
    }

    public static void displayReport(String data){
        displayBakeShop();
        System.out.println();
        System.out.println(data);
        System.out.println();
        System.out.println();
        System.out.println("*.Return to report menu");


    }


    public static void displayBakeShop(){
        for(int i = 0; i < 10; i++){
            System.out.println("");
        }
        System.out.println("===================================");
        System.out.println("             Bake Shop             ");
        System.out.println("===================================");
    }

    public static void displaySearchFunction(boolean isFistTime){
        displayBakeShop();
        System.out.println();
        System.out.println("Please enter item to search in the inventory: ");
        if(isFistTime)
            System.out.println("Enter * to go back to Main Menu");
        else
            System.out.println("Enter * to finish the order");
        System.out.println();
    }

    public static void displayItemsFromSearchResult(HashMap<Integer, Item> searchItems){
        displayBakeShop();
        System.out.println("     List of items in inventory    ");
        System.out.println("===================================");
        System.out.println();
        System.out.println("");
        if (searchItems.size() == 0){
            System.out.println("No Items found.");
            System.out.println("Please Enter the item again: ");
        }
        else
        {
            for(int i = 1; i < searchItems.size() + 1; i++)
            {
                System.out.println(i + "    " + searchItems.get(i).getItemName() + "\n");
            }
        }
        System.out.println("===================================");
        System.out.println();
    }

    public static void displayEnterItemFromSearch(){
        System.out.println("===================================");
        System.out.print("Please Enter Item number to choose an item from the list: ");
        System.out.println();
        System.out.print("Enter * to go back to search page");
        System.out.println();
    }

    public static void displayCurrentOrder(String orderDetail){
        System.out.println("===================================");
        System.out.println();
        System.out.println(orderDetail);
        System.out.println();
        System.out.println("===================================");
        System.out.println("Enter * to finish the order");
        System.out.print("or enter any other key to continue add items");
        System.out.println();
    }

    public static void displayFinshedOrder(String orderDetail){
        System.out.println("===================================");
        System.out.println(orderDetail);
        System.out.println("===================================");
        System.out.println("Enter any key back to Main Menu");
        System.out.println();
    }

}
