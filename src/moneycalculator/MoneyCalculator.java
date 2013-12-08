package moneycalculator;

public class MoneyCalculator {

    public static void main(String[] args) {
        CurrencySetLoaderCSV loader = new CurrencySetLoaderCSV();
        loader.load("C:\\Users\\Aday\\Documents\\NetBeansProjects\\IS2-MoneyCalc\\currencies.csv");
        MainFrame mainFrame = new MainFrame();
    }
}
