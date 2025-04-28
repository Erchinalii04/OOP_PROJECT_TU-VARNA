package dndgame;

public class Monster {
    private int strength, mana, health;
    private double armorReduction;

    public Monster(int level) {
        strength = 25 + (level - 1) * 10;
        mana = 25 + (level - 1) * 10;
        health = 50 + (level - 1) * 10;
        armorReduction = 0.15 + (level - 1) * 0.05;
    }

    public void takeDamage(int dmg) { this.health -= dmg; }
    public boolean isDead() { return health <= 0; }
    public int getStrength() { return strength; }
    public int getMana() { return mana; }
    public int getHealth() { return health; }
    public double getArmorReduction() { return armorReduction; }
}
