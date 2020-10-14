package fit5136.bakeshop.entities;

import java.util.Date;

public class Sale {
    private int foodItemSold;
    private int coffeeSold;
    private int coffeeBeanSold;
    private Date peakDayOfTheMonth;
    private double monthlyTotalSale;
    private double monthlyTotalRevenue;

    public int getFoodItemSold() {
        return foodItemSold;
    }

    public void setFoodItemSold(int foodItemSold) {
        this.foodItemSold = foodItemSold;
    }

    public int getCoffeeSold() {
        return coffeeSold;
    }

    public void setCoffeeSold(int coffeeSold) {
        this.coffeeSold = coffeeSold;
    }

    public int getCoffeeBeanSold() {
        return coffeeBeanSold;
    }

    public void setCoffeeBeanSold(int coffeeBeanSold) {
        this.coffeeBeanSold = coffeeBeanSold;
    }

    public Date getPeakDayOfTheMonth() {
        return peakDayOfTheMonth;
    }

    public void setPeakDayOfTheMonth(Date peakDayOfTheMonth) {
        this.peakDayOfTheMonth = peakDayOfTheMonth;
    }

    public double getMonthlyTotalSale() {
        return monthlyTotalSale;
    }

    public void setMonthlyTotalSale(double monthlyTotalSale) {
        this.monthlyTotalSale = monthlyTotalSale;
    }

    public double getMonthlyTotalRevenue() {
        return monthlyTotalRevenue;
    }

    public void setMonthlyTotalRevenue(double monthlyTotalRevenue) {
        this.monthlyTotalRevenue = monthlyTotalRevenue;
    }

}