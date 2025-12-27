package service;

import model.Currency;
import model.Expense;
import repository.ExpenseRepository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class ReportService {

    private final ExpenseRepository repository;
    private final CurrencyConverter converter;

    public ReportService(ExpenseRepository repository, CurrencyConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    // 4.1 Общая сумма
    public double getTotal(Currency currency) {
        double total = 0;

        for (Expense e : repository.getAllExpenses()) {
            total += converter.convert(
                    e.getAmount(),
                    e.getCurrency(),
                    currency
            );
        }
        return total;
    }

    // 4.2 Отчёт по категориям ⭐
    public void reportByCategory(Currency currency) {

        Map<String, Double> result = new HashMap<>();

        for (Expense e : repository.getAllExpenses()) {

            double converted = converter.convert(
                    e.getAmount(),
                    e.getCurrency(),
                    currency
            );

            result.put(
                    e.getCategory(),
                    result.getOrDefault(e.getCategory(), 0.0) + converted
            );
        }

        System.out.println("Expenses by category:");
        result.forEach((k, v) ->
                System.out.println(k + ": " + v + " " + currency)
        );
    }

    // 4.3 Отчёт за период 📅
    public void reportByDateRange(
            LocalDate start,
            LocalDate end,
            Currency currency) {

        double total = 0;

        for (Expense e : repository.getAllExpenses()) {

            if (!e.getDate().isBefore(start)
                    && !e.getDate().isAfter(end)) {

                total += converter.convert(
                        e.getAmount(),
                        e.getCurrency(),
                        currency
                );
            }
        }

        System.out.println(
                "Total from " + start + " to " + end + ": "
                        + total + " " + currency
        );
    }

    // 4.4 Самый большой расход 🔍
    public void findMaxExpense() {

        Expense max = null;

        for (Expense e : repository.getAllExpenses()) {

            if (max == null || e.getAmount() > max.getAmount()) {
                max = e;
            }
        }

        if (max != null) {
            System.out.println(
                    "Max expense: ID=" + max.getId()
                            + ", Category=" + max.getCategory()
                            + ", Amount=" + max.getAmount()
                            + " " + max.getCurrency()
            );
        }
    }
}
