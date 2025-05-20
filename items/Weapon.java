package items;

/**
 * Represents a weapon item that boosts the hero's strength in combat.
 */
public class Weapon implements Item {
    private final String name;
    private final double bonusPercent; // Например 0.20 = +20%

    public Weapon(String name, double bonusPercent) {
        this.name = name;
        this.bonusPercent = bonusPercent;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return "Weapon";
    }

    @Override
    public double getBonus() {
        return bonusPercent;
    }
}
