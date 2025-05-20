package items;

/**
 * Interface representing an item that can be stored in the hero's inventory.
 */
public interface Item {
    String getName();
    String getType(); // Например: "Weapon", "Armor"
    double getBonus(); // бонус като десетичен процент (напр. 0.20 = 20%)
}
