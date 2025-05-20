package entities;

/**
 * Represents a monster (dragon) with strength, mana, health,
 * and passive defense (scales) that reduce incoming damage by 15%.
 */
public class Monster {
    private int strength;
    private int mana;
    private int health;

    private static final double DAMAGE_REDUCTION = 0.15; // 15% защита от люспи

    public Monster() {
        // Начални стойности за ниво 1
        this.strength = 25;
        this.mana = 25;
        this.health = 50;
    }

    // Метод за получаване на щета, вземащ предвид защитата
    public void takeDamage(int incoming) {
        int reduced = (int) Math.round(incoming * (1.0 - DAMAGE_REDUCTION));
        health -= reduced;
        if (health < 0) health = 0;
        System.out.println("The monster takes " + reduced + " damage (after scale protection).");
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public int getMana() {
        return mana;
    }
}
