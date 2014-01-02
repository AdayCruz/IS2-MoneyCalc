package moneycalculator;

class ExitCommand extends Command{

    public ExitCommand() {
    }

    @Override
    public void execute() {
        System.exit(0);
    }

}
