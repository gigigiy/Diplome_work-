package service;

import model.Currency;
import model.Expense;
import repository.ExpenseRepository;

import java.time.LocalDate;

public class ExpenseService {

    private final ExpenseRepository repository;

    public ExpenseService(ExpenseRepository repository) {
        this.repository = repository;
    }

    public void addExpense(String category, String description,
                           double amount, Currency currency) {

        Expense expense = new Expense(
                category,
                description,
                amount,
                currency,
                LocalDate.now()
        );

        repository.addExpense(expense);
    }

    public void deleteExpense(int id) {
        repository.removeById(id);
    }
}
