package commands;

import main.java.core.GameContext;
import main.java.core.LevelGenerator;
import main.java.entities.Hero;
import main.java.entities.Monster;
import main.java.items.Item;
import main.java.map.GameMap;

import java.util.Map;

/**
 * Command that moves the hero in a given direction.
 * Handles walls, treasures, monsters and level transitions.
 */
public class MoveCommand implements Command {
    private final GameContext context;

    public MoveCommand(GameContext context) {
        this.context = context;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: move <up|down|left|right>");
            return;
        }

        Hero hero = context.getHero();
        GameMap map = context.getMap();

        if (hero == null || map == null) {
            System.out.println("Hero or map is not available.");
            return;
        }

        int dx = 0, dy = 0;
        switch (args[0].toLowerCase()) {
            case "up" -> dy = -1;
            case "down" -> dy = 1;
            case "left" -> dx = -1;
            case "right" -> dx = 1;
            default -> {
                System.out.println("Invalid direction. Use: up, down, left, right.");
                return;
            }
        }

        int newX = hero.getX() + dx;
        int newY = hero.getY() + dy;
        char destination = map.getTile(newX, newY);

        if (destination == '#') {
            System.out.println("You hit a wall and cannot move there.");
            return;
        }

        // Преминаване към следващо ниво
        if (destination == 'E') {
            System.out.println("You reached the exit. Loading next level...");
            context.advanceLevel();
            int nextLevel = context.getCurrentLevel();

            GameMap newMap = LevelGenerator.loadLevel(nextLevel);
            context.setMap(newMap);

            Map<String, Item> newTreasures = LevelGenerator.loadTreasureItems(nextLevel);
            context.setTreasures(newTreasures);

            Map<String, Monster> newMonsters = LevelGenerator.loadMonsters(newMap);
            context.setMonsters(newMonsters);

            hero.moveTo(1, 1);
            System.out.println("Level " + nextLevel + " loaded.");
            return;
        }

        // Преместване на героя
        hero.move(dx, dy);
        System.out.println("Hero moved to: (" + hero.getX() + ", " + hero.getY() + ")");

        String key = hero.getX() + "_" + hero.getY();
        char tile = map.getTile(hero.getX(), hero.getY());

        // Сражение при стъпване на чудовище
        if (tile == 'M') {
            Monster monster = context.getMonsters().get(key);
            if (monster != null && monster.isAlive()) {
                int damage = hero.getStrength();
                monster.takeDamage(damage);
                System.out.println("You strike the monster for " + damage + " damage!");

                if (!monster.isAlive()) {
                    System.out.println("You defeated the monster!");
                    context.getMonsters().remove(key);
                } else {
                    int retaliation = monster.getStrength();
                    hero.takeDamage(retaliation);
                    System.out.println("The monster strikes back for " + retaliation + " damage!");

                    if (!hero.isAlive()) {
                        System.out.println("You have been slain by the monster. Game over.");
                        System.exit(0);
                    }
                }
            }
        }

        // Проверка за съкровище (ако не е върху чудовище или изход)
        Item item = context.getTreasures().get(key);
        if (item != null && tile != 'M' && tile != 'E') {
            hero.addItem(item);
            context.getTreasures().remove(key);
            System.out.println("You found a treasure: " + item.getName() + "!");
        }
    }
}
