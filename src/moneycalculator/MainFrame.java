package moneycalculator;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
    
    private MoneyDialog moneyDialog;
    private CurrencyDialog currencyDialog;
    private MoneyViewer moneyViewer;
    private ActionListenerFactory factory;
    
    public MainFrame (ActionListenerFactory factory) {
        
        this.setTitle("Money Calculator");
        this.factory = factory;
        this.setSize(300,300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        createComponents();
        this.setVisible(true);
    }
    
    public MoneyDialog getMoneyDialog(){
        return moneyDialog;
    }

    public CurrencyDialog getCurrencyDialog(){
        return currencyDialog;
    }
    
    public MoneyViewer getMoneyViewer(){
        return moneyViewer;
    }
    
    private void createComponents() {
        this.add(createMoneyDialog());
        this.add(createToolbar(), BorderLayout.SOUTH);
    }

    private JPanel createToolbar() {
        JPanel toolbar = new JPanel ();
        toolbar.setLayout(new FlowLayout(FlowLayout.RIGHT));
        toolbar.add(createCalculateButton());
        toolbar.add(createExitButton());
        return toolbar;
    }

    private JButton createCalculateButton() {
        JButton button = new JButton("Calculate");
        this.getRootPane().setDefaultButton(button);
        button.addActionListener(factory.createActionListner("calculate"));
        return button;
    }

    private JButton createExitButton() {
        JButton button = new JButton ("Exit");
        button.addActionListener(factory.createActionListner("exit"));
        return button;
    }

    private JPanel createMoneyDialog() {
        JPanel panel = new JPanel();
        panel.add(new MoneyDialogGraphical());
        panel.add(new CurrencyDialogGraphical());
        return panel;
    }

}
