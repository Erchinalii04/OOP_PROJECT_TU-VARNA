package core;

import main.java.commands.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Command-line interface for the D&D game.
 * Handles REPL input and dispatches commands using a dynamic map.
 */
public class GameMenu {
    private final GameContext context = new GameContext();
    private final Map<String, Command> commands = new HashMap<>();

    /**
     * Initializes the command map with available commands.
     */
    public GameMenu() {
        commands.put("start", new StartCommand(context));
        commands.put("map", new MapCommand(context));
        commands.put("move", new MoveCommand(context));
        commands.put("stats", new StatsCommand(context));
        commands.put("inventory", new InventoryCommand(context));
        commands.put("help", new HelpCommand());
        commands.put("exit", new ExitCommand());
    }

    /**
     * Runs the REPL game loop. Reads input, parses commands, and executes them.
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to D&D Console Adventure!");
        System.out.println("Type 'help' to see available commands.");

        while (true) {
            System.out.print("> ");
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split("\\s+");
            String commandName = parts[0].toLowerCase();
            String[] args = new String[parts.length - 1];
            System.arraycopy(parts, 1, args, 0, args.length);

            Command command = commands.get(commandName);
            if (command != null) {
                command.execute(args);
            } else {
                System.out.println("Unknown command: " + commandName + ". Type 'help' for a list of commands.");
            }
        }
    }
}
