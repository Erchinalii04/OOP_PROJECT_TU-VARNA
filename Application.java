


import core.GameEngine;
import interfaces.FileHandler;
import models.Hero;
import models.Race;
import utils.FileUtils;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        GameEngine engine = new GameEngine();
        FileHandler fileHandler = new FileUtils();
        GameState state = new GameState();

        System.out.println("Избери раса (human, mage, warrior): ");
        Race race = Race.valueOf(scanner.nextLine().trim().toUpperCase());
        Hero hero = new Hero(race);
        state.setHero(hero);

        engine.registerCommand("open", new OpenCommand(fileHandler, state));
        engine.registerCommand("save", new SaveCommand(fileHandler, state));
        engine.registerCommand("help", new HelpCommand());
        engine.registerCommand("exit", new ExitCommand());
        engine.registerCommand("move", new MoveCommand(state));
        engine.registerCommand("fight", new FightCommand(state));

        System.out.println("Готово. Използвай 'help' за списък с команди.");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            engine.executeCommand(input);
        }
    }
}