package moneycalculator;

import java.util.Date;

public class ExchangeRate {
    private final Date date; 
    private final Currency inputCurrency;
    private final Currency outputCurrency;
    private final Number rate;

    public ExchangeRate(Date date, Currency inputCurrency, Currency outputCurrency, Number rate) {
        this.date = date;
        this.inputCurrency = inputCurrency;
        this.outputCurrency = outputCurrency;
        this.rate = rate;
    }

    public ExchangeRate(Currency inputCurrency, Currency outputCurrency, Number rate) {
        this.inputCurrency = inputCurrency;
        this.outputCurrency = outputCurrency;
        this.rate = rate;
        date = new Date();
    }

    public Date getDate() {
        return date;
    }

    public Currency getInputCurrency() {
        return inputCurrency;
    }

    public Currency getOutputCurrency() {
        return outputCurrency;
    }

    public Number getRate() {
        return rate;
    }
    
}
