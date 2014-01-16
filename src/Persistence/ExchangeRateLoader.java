package Persistence;

import Model.ExchangeRate;
import Model.Currency;

public interface ExchangeRateLoader {
    
    public ExchangeRate load(Currency input, Currency output);

}
