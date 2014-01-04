package moneycalculator;

public interface ExchangeRateLoader {
    
    public ExchangeRate load(Currency input, Currency output, String URL);

}
