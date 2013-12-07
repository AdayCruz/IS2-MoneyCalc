package moneycalculator;

import java.awt.Dimension;
import javax.swing.JFrame;

public class MainFrame extends JFrame {
    
    public MainFrame () {
        
        this.setTitle("Money Calculator");
        this.setMinimumSize(new Dimension(300,300));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createComponents();
        this.setVisible(true);
    }

    private void createComponents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
