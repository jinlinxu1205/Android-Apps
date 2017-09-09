package com.example.jinlin.spendingtracker;

/**This class is the Expense class. It creates expense objects which have variables like item, amount,
 * location, date and imagePath. It has hashcode, getters, and setters methods.
 * Created by Jinlin on 4/17/17.
 */

public class Expense {
    private String item;
    private double amount;
    private String location;
    private String date;
    private String imagePath;

    public Expense(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Expense expense = (Expense) o;

        if (Double.compare(expense.amount, amount) != 0) return false;
        if (item != null ? !item.equals(expense.item) : expense.item != null) return false;
        if (location != null ? !location.equals(expense.location) : expense.location != null)
            return false;
        if (date != null ? !date.equals(expense.date) : expense.date != null) return false;
        return imagePath != null ? imagePath.equals(expense.imagePath) : expense.imagePath == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = item != null ? item.hashCode() : 0;
        temp = Double.doubleToLongBits(amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (imagePath != null ? imagePath.hashCode() : 0);
        return result;
    }

    public Expense(String item, double amount, String location, String date, String imagePath) {
        this.item = item;
        this.amount = amount;
        this.location = location;
        this.date = date;
        this.imagePath = imagePath;
    }

    public String getItem() {
        return item;
    }

    public double getAmount() {
        return amount;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setMonth(String date) {
        this.date = date;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }


}
