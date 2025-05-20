package models;

import models.Inventory;

public class Hero {
    private final Race race;
    private int strength, mana, health, level;
    private final Inventory inventory;

    public Race getRace() {
        return race;
    }

    public int getStrength() {
        return strength;
    }

    public Hero setStrength(int strength) {
        this.strength = strength;
        return this;
    }

    public int getMana() {
        return mana;
    }

    public Hero setMana(int mana) {
        this.mana = mana;
        return this;
    }

    public Hero setHealth(int health) {
        this.health = health;
        return this;
    }

    public int getLevel() {
        return level;
    }

    public Hero setLevel(int level) {
        this.level = level;
        return this;
    }

    public Hero(Race race) {
        this.race = race;
        this.level = 1;
        this.strength = race.getBaseStrength();
        this.mana = race.getBaseMana();
        this.health = race.getBaseHealth();
        this.inventory = new Inventory();
    }

    public void takeDamage(int dmg) {
        int reduced = (int)(dmg * (1 - inventory.getArmorBonus() / 100.0));
        health -= reduced;
    }

    public int attack(boolean magic) {
        if (magic)
            return (int)(mana * inventory.getSpellBonus() / 100.0);
        return (int)(strength * inventory.getWeaponBonus() / 100.0);
    }

    public boolean isAlive() { return health > 0; }

    public void levelUp(int str, int man, int hp) {
        this.level++;
        this.strength += str;
        this.mana += man;
        this.health += hp;
    }

    public Inventory getInventory() { return inventory; }
    public int getHealth() { return health; }
    public String toString() {
        return String.format("%s (Lvl %d) HP:%d STR:%d MANA:%d", race, level, health, strength, mana);
    }
}