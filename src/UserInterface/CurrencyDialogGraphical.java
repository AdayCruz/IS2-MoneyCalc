package UserInterface;

import Model.CurrencySet;
import Model.Currency;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class CurrencyDialogGraphical extends JPanel implements CurrencyDialog{
    
    private Currency currency;
    
    public CurrencyDialogGraphical() {
        this(CurrencySet.getInstance().search("EUR"));
    }

    public CurrencyDialogGraphical(Currency currency) {
        super(new FlowLayout(FlowLayout.LEFT));
        this.currency = currency;
        this.createComponents();
    }

    private void createComponents() {
        this.add(createComboBox());
    }
    
    private JComboBox createComboBox() {
        String[] currencies = CurrencySet.getInstance().getArray();
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

    @Override
    public Currency getCurrency() {
        return currency;
    }
}
