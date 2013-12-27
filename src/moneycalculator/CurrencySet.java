package moneycalculator;

import java.util.HashSet;

public class CurrencySet extends HashSet<Currency>{
    private static CurrencySet instance;

    private CurrencySet() {
    }
    
    public static CurrencySet getInstance(){
        if (instance == null) instance = new CurrencySet();
        return instance;
    }
    
    public Currency search(String code){
        for (Currency currency : this) {
            if (currency.getCode().equals(code)) return currency;
        }
        return null;
    }
}
