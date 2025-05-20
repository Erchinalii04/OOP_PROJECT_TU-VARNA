package core;

import interfaces.Command;
import java.util.HashMap;
import java.util.Map;

public class GameEngine {
    private final Map<String, Command> commands = new HashMap<>();

    public void registerCommand(String name, Command command) {
        commands.put(name.toLowerCase(), command);
    }

    public void executeCommand(String input) throws Exception {
        String[] parts = input.trim().split("\s+");
        String cmdName = parts[0];
        String[] args = java.util.Arrays.copyOfRange(parts, 1, parts.length);
        Command cmd = commands.get(cmdName.toLowerCase());
        if (cmd == null) System.out.println("Invalid command. Type 'help'.");
        else cmd.execute(args);
    }
}