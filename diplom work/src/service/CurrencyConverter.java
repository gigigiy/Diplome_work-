package service;

import model.Currency;
import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter {

    private final Map<Currency, Double> ratesToUSD = new HashMap<>();

    public CurrencyConverter() {
        ratesToUSD.put(Currency.USD, 1.0);
        ratesToUSD.put(Currency.EUR, 1.1);
        ratesToUSD.put(Currency.KGS, 0.011);
    }

    public double convert(double amount, Currency from, Currency to) {
        double usdAmount = amount * ratesToUSD.get(from);
        return usdAmount / ratesToUSD.get(to);
    }
}
