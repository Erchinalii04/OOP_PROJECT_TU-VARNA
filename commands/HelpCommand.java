package commands;

/**
 * Command that displays a list of available commands and their usage.
 */
public class HelpCommand implements Command {

    public HelpCommand() {
        // Няма нужда от контекст
    }

    @Override
    public void execute(String[] args) {
        // Извежда списък с всички поддържани команди
        System.out.println("Available commands:");
        System.out.println("  start             - стартира нова игра (създава герой и зарежда карта)");
        System.out.println("  map               - показва текущата карта с позицията на героя");
        System.out.println("  move <dir>        - мести героя (up, down, left, right)");
        System.out.println("  stats             - показва статистиките на героя");
        System.out.println("  inventory         - показва предметите в инвентара");
        System.out.println("  help              - показва този списък с команди");
        System.out.println("  exit              - изход от играта");
    }
}
