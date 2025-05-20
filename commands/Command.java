package commands;

/**
 * Interface for all game commands.
 * Each command must implement the execute method.
 */
public interface Command {
    /**
     * Executes the command with the given arguments.
     *
     * @param args command-line arguments
     */
    void execute(String[] args);
}
