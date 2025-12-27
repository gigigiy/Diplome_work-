import model.Currency;
import repository.ExpenseRepository;
import service.CurrencyConverter;
import service.ExpenseService;
import service.ReportService;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        ExpenseRepository repo = new ExpenseRepository();
        CurrencyConverter converter = new CurrencyConverter();

        ExpenseService expenseService = new ExpenseService(repo);
        ReportService reportService = new ReportService(repo, converter);

        expenseService.addExpense("Food", "Lunch", 120, Currency.USD);
        expenseService.addExpense("Transport", "Taxi", 2000, Currency.KGS);
        expenseService.addExpense("Hotel", "Business trip", 80, Currency.EUR);

        reportService.reportByCategory(Currency.USD);
        reportService.reportByDateRange(
                LocalDate.now().minusDays(1),
                LocalDate.now(),
                Currency.USD
        );

        reportService.findMaxExpense();
    }
}
