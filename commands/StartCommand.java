package commands;

import main.java.core.GameContext;
import main.java.core.LevelGenerator;
import main.java.entities.Hero;
import main.java.entities.Race;
import main.java.map.GameMap;
import main.java.items.Item;
import main.java.entities.Monster;

import java.util.Map;
import java.util.Scanner;

/**
 * Command that starts a new game, creates a hero, and loads the first level.
 */
public class StartCommand implements Command {
    private final GameContext context;

    public StartCommand(GameContext context) {
        this.context = context;
    }

    @Override
    public void execute(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Starting a new game...");
        System.out.print("Enter hero name: ");
        String name = scanner.nextLine();

        System.out.println("Choose a race: HUMAN, MAGE, WARRIOR");
        Race race = null;
        while (race == null) {
            System.out.print("Enter race: ");
            try {
                race = Race.valueOf(scanner.nextLine().trim().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid race. Try again.");
            }
        }

        Hero hero = new Hero(name, race);
        context.setHero(hero);

        int level = context.getCurrentLevel();

        // Зареждане на карта
        GameMap map = LevelGenerator.loadLevel(level);
        context.setMap(map);

        // Зареждане на съкровища
        Map<String, Item> treasures = LevelGenerator.loadTreasureItems(level);
        context.setTreasures(treasures);

        // Зареждане на чудовища
        Map<String, Monster> monsters = LevelGenerator.loadMonsters(map);
        context.setMonsters(monsters);

        System.out.println("Hero created: " + hero.getName() + " the " + hero.getRace());
        System.out.println("Map loaded from level" + level + ".txt");
        System.out.println("Type 'map' to view the world, or 'help' for commands.");
    }
}
