package Model;

import java.util.Arrays;
import java.util.HashSet;

public class CurrencySet extends HashSet<Currency>{
    private static CurrencySet instance;

    private CurrencySet() {
    }
    
    public static CurrencySet getInstance(){
        if (instance == null) instance = new CurrencySet();
        return instance;
    }
    
    public String[] getArray() {
        CurrencySet currencySet = CurrencySet.getInstance();
        String[] currencies = new String[currencySet.size()];
        int i=0;
        for (Currency currency : currencySet) {
            currencies[i]=currency.getCode();
            i++;
        }
        Arrays.sort(currencies);
        return currencies;
    }
    
    public Currency search(String code){
        for (Currency currency : this) {
            if (currency.getCode().equals(code)) return currency;
        }
        return null;
    }
}
