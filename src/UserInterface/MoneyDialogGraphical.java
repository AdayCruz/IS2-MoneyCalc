package UserInterface;

import Model.Money;
import Model.Number;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MoneyDialogGraphical extends JPanel implements MoneyDialog{

    private String amount = "1";
    private CurrencyDialog currencyDialog;
    
    public MoneyDialogGraphical() {
        super(new FlowLayout(FlowLayout.LEFT));
        this.createComponents();
    }

    private JTextField createTextField() {
        JTextField textField = new JTextField (10);
        return textField;
    }

    @Override
    public Money getMoney() {
        return new Money(new Number(Double.parseDouble(amount)), currencyDialog.getCurrency());
    }

    private void createComponents() {
        this.add(createAmountWidget());
        this.add(createCurrencyDialogGraphical());
    }

    private JTextField createAmountWidget() {
        final JTextField textField = new JTextField(amount, 10);
        textField.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
            }

            @Override
            public void keyPressed(KeyEvent ke) {
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                amount = textField.getText();
            }
        });
        return textField;
    }

    private JPanel createCurrencyDialogGraphical() {
        CurrencyDialogGraphical panel = new CurrencyDialogGraphical();
        this.currencyDialog = panel;
        return panel;
    }
    
}
