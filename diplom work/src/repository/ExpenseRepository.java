package repository;

import model.Expense;

import java.util.ArrayList;
import java.util.List;

public class ExpenseRepository {

    private final List<Expense> expenses = new ArrayList<>();

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public List<Expense> getAllExpenses() {
        return expenses;
    }

    public void removeById(int id) {
        expenses.removeIf(e -> e.getId() == id);
    }
}
