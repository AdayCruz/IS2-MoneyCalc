package moneycalculator;

public class CalculateCommand extends Command{
    
    private final MoneyDialog moneyDialog;
    private final CurrencyDialog currencyDialog;
    private final MoneyViewer moneyViewer;

    public CalculateCommand(MoneyDialog moneyDialog, CurrencyDialog currencyDialog, MoneyViewer moneyViewer) {
        this.moneyDialog = moneyDialog;
        this.currencyDialog = currencyDialog;
        this.moneyViewer = moneyViewer;
    }

    @Override
    public void execute() {
        moneyViewer.show(new Money(calculateAmount(), currencyDialog.getCurrency()));
    }

    private Number calculateAmount() {
        return moneyDialog.getMoney().getAmount().multiply(getExchangeRate());
    }

    private Number getExchangeRate() {
        ExchangeRateLoader loader = new ExchangeRateLoaderCSV();
        return loader.load(moneyDialog.getMoney().getCurrency(),currencyDialog.getCurrency(),"C:\\Users\\Aday\\Documents\\NetBeansProjects\\IS2-MoneyCalc\\eur-rates.csv").getRate();
    }

}
