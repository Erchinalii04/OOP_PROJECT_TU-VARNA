package items;

/**
 * Represents a magical spell that increases magical damage (mana-based).
 */
public class Spell implements Item {
    private final String name;
    private final double bonusPercent; // Например 0.25 = +25% магическа сила

    public Spell(String name, double bonusPercent) {
        this.name = name;
        this.bonusPercent = bonusPercent;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return "Spell";
    }

    @Override
    public double getBonus() {
        return bonusPercent;
    }
}
