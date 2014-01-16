package Components;

import UserInterface.MainFrame;

class ExitCommand extends Command{

    MainFrame frame;
    
    public ExitCommand(MainFrame frame) {
        this.frame = frame;
    }

    @Override
    public void execute() {
        frame.dispose();
    }

}
