package commands;

/**
 * Command that terminates the game.
 */
public class ExitCommand implements Command {

    public ExitCommand() {
        // Няма нужда от контекст
    }

    @Override
    public void execute(String[] args) {
        // Изход от програмата
        System.out.println("Exiting the game...");
        System.exit(0);
    }
}
