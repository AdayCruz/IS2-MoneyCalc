package moneycalculator;

import java.util.Arrays;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class CurrencyDialogGraphical extends JPanel implements CurrencyDialog{
    private Currency currency;
    
    public CurrencyDialogGraphical() {
        this.add(createComboBox());
    }
    
    private JComboBox createComboBox() {
        String[] currencies = getCurrencies();
        JComboBox comboBox = new JComboBox(currencies);
        return comboBox;
    }

    private String[] getCurrencies() {
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

    @Override
    public Currency getCurrency() {
        return currency;
    }
}
