package items;

/**
 * Represents armor that increases the hero's defense or resistance.
 * For now, bonusPercent can reduce damage received.
 */
public class Armor implements Item {
    private final String name;
    private final double bonusPercent; // Например 0.15 = 15% по-малко щета

    public Armor(String name, double bonusPercent) {
        this.name = name;
        this.bonusPercent = bonusPercent;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return "Armor";
    }

    @Override
    public double getBonus() {
        return bonusPercent;
    }
}
