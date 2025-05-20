package commands;

import main.java.core.GameContext;
import main.java.entities.Hero;

/**
 * Command that displays the hero's current stats.
 */
public class StatsCommand implements Command {
    private final GameContext context;

    public StatsCommand(GameContext context) {
        this.context = context;
    }

    @Override
    public void execute(String[] args) {
        Hero hero = context.getHero();

        // Проверка дали героят е създаден
        if (hero == null) {
            System.out.println("No hero is available.");
            return;
        }

        // Извеждане на статистики
        System.out.println("Hero stats:");
        System.out.println("Name: " + hero.getName());
        System.out.println("Race: " + hero.getRace());
        System.out.println("Health: " + hero.getHealth());
        System.out.println("Strength: " + hero.getStrength());
        System.out.println("Position: (" + hero.getX() + ", " + hero.getY() + ")");
    }
}
