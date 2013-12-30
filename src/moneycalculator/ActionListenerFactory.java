package moneycalculator;

import java.awt.event.ActionListener;

public interface ActionListenerFactory {
    public ActionListener createActionListner(String action);
}
