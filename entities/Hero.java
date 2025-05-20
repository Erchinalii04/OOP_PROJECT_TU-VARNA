package entities;

import main.java.items.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a hero controlled by the player.
 * Has base attributes depending on race and an inventory.
 */
public class Hero {
    private final String name;
    private final Race race;

    private int strength;
    private int mana;
    private int health;

    private int x; // позиция на картата
    private int y;

    private final List<Item> inventory;

    public Hero(String name, Race race) {
        this.name = name;
        this.race = race;
        this.inventory = new ArrayList<>();

        // Начални стойности по раса
        switch (race) {
            case HUMAN -> {
                strength = 30;
                mana = 20;
                health = 50;
            }
            case MAGE -> {
                strength = 10;
                mana = 40;
                health = 50;
            }
            case WARRIOR -> {
                strength = 40;
                mana = 10;
                health = 50;
            }
        }

        x = 1;
        y = 1;
    }

    // Метод за преместване
    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Метод за вдигане на ниво – дава 30 точки за разпределение (примерна логика)
    public void levelUp(int strengthPoints, int manaPoints, int healthPoints) {
        int total = strengthPoints + manaPoints + healthPoints;
        if (total != 30) {
            System.out.println("You must distribute exactly 30 points.");
            return;
        }
        this.strength += strengthPoints;
        this.mana += manaPoints;
        this.health += healthPoints;
    }

    // Получаване на щета
    public void takeDamage(int amount) {
        health -= amount;
        if (health < 0) health = 0;
    }

    public boolean isAlive() {
        return health > 0;
    }

    // Инвентар
    public void addItem(Item item) {
        inventory.add(item);
    }

    public List<Item> getInventory() {
        return inventory;
    }

    // Гетъри
    public String getName() { return name; }
    public Race getRace() { return race; }
    public int getStrength() { return strength; }
    public int getMana() { return mana; }
    public int getHealth() { return health; }
    public int getX() { return x; }
    public int getY() { return y; }
}
