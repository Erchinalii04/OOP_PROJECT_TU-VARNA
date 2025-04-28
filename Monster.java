

public class Monster {
    private int strength;
    private int mana;
    private int health;
    private double armorReduction;

    public Monster(int level) {
        this.strength = 25 + (level - 1) * 10;
        this.mana = 25 + (level - 1) * 10;
        this.health = 50 + (level - 1) * 10;
        this.armorReduction = 0.15 + (level - 1) * 0.05;
    }

    public int getStrength() { return strength; }
    public int getMana() { return mana; }
    public int getHealth() { return health; }
    public boolean isDead() { return health <= 0; }
    public double getArmorReduction() { return armorReduction; }

    public void reduceHealth(int damage) {
        this.health -= damage;
    }
}
