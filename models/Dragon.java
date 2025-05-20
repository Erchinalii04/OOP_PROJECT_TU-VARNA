package models;

public class Dragon {
    private int strength, mana, health, armor;

    public Dragon(int level) {
        strength = 25 + 10 * (level - 1);
        mana = 25 + 10 * (level - 1);
        health = 50 + 10 * (level - 1);
        armor = 15 + 5 * (level - 1);
    }

    public int attack(boolean magic) {
        return magic ? mana : strength;
    }

    public void takeDamage(int dmg) {
        int reduced = (int)(dmg * (1 - armor / 100.0));
        health -= reduced;
    }

    public boolean isAlive() { return health > 0; }
    public int getHealth() { return health; }
}