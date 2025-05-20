package commands;

import main.java.core.GameContext;
import main.java.entities.Hero;
import main.java.items.Item;

import java.util.List;

/**
 * Command that displays the contents of the hero's inventory.
 */
public class InventoryCommand implements Command {
    private final GameContext context;

    public InventoryCommand(GameContext context) {
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

        List<Item> inventory = hero.getInventory();

        // Проверка за празен инвентар
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
            return;
        }

        // Извеждане на предметите
        System.out.println("Inventory:");
        for (Item item : inventory) {
            System.out.println("- " + item.getName() + " (" + item.getType() + ")");
        }
    }
}
