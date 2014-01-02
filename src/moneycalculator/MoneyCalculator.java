package moneycalculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class MoneyCalculator {

    public static void main(String[] args) {
        new MoneyCalculator().execute();
    }
    
    private HashMap<String, Command> commandMap;

    private void execute() {
        CurrencySetLoaderCSV loader = new CurrencySetLoaderCSV();
        loader.load("C:\\Users\\Aday\\Documents\\NetBeansProjects\\IS2-MoneyCalc\\currencies.csv");
        createCommands(createMainFrame());
    }

    private void createCommands(MainFrame frame) {
        commandMap = new HashMap<>();
        commandMap.put("Calculate", new CalculateCommand(
                    frame.getMoneyDialog(),
                    frame.getCurrencyDialog(),
                    frame.getMoneyViewer()
                ));
        commandMap.put("Exit", new ExitCommand());
    }
    
    private MainFrame createMainFrame(){
        return new MainFrame(new ActionListenerFactory() {

            @Override
            public ActionListener createActionListner(final String action) {
                return new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        Command command = commandMap.get(action);
                        if (command == null){
                            return;
                        }
                        command.execute();
                    }
                };
            }
            });
        }
}
