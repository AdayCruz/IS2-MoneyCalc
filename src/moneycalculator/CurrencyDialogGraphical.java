package moneycalculator;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
        comboBox.setSelectedIndex(0);
        currency = CurrencySet.getInstance().search(comboBox.getSelectedItem().toString());
        comboBox.addItemListener(new ItemListener(){

            @Override
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() != ItemEvent.SELECTED) return;
                currency = CurrencySet.getInstance().search(event.getItem().toString());
            }
            
        });
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
