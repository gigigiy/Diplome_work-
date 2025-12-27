package model;

import java.time.LocalDate;

public class Expense {

    private static int counter = 1;

    private int id;
    private String category;
    private String description;
    private double amount;
    private Currency currency;
    private LocalDate date;

    public Expense(String category, String description,
                   double amount, Currency currency, LocalDate date) {
        this.id = counter++;
        this.category = category;
        this.description = description;
        this.amount = amount;
        this.currency = currency;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public LocalDate getDate() {
        return date;
    }
}
