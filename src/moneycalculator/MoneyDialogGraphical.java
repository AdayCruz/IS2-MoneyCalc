package moneycalculator;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class MoneyDialogGraphical extends JPanel{


    public MoneyDialogGraphical() {
        this.add(createTextField());
        this.add(new CurrencyDialogGraphical());
    }

    private JTextField createTextField() {
        JTextField textField = new JTextField (10);
        return textField;
    }
}
