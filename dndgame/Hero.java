package dndgame;

public class Hero {
    private String name;
    private Race race;
    private int strength, mana, health, maxHealth, level;
    private Inventory inventory;

    public Hero(String name, Race race) {
        this.name = name;
        this.race = race;
        this.level = 1;
        this.inventory = new Inventory();
        switch (race) {
            case HUMAN -> { strength = 30; mana = 20; }
            case MAGE -> { strength = 10; mana = 40; }
            case WARRIOR -> { strength = 40; mana = 10; }
        }
        this.health = this.maxHealth = 50;
        inventory.equipWeapon(new Weapon("Basic Sword", 20));
        inventory.equipSpell(new Spell("Fireball", 20));
    }

    public void levelUp(int str, int mana, int hp) {
        this.level++;
        this.strength += str;
        this.mana += mana;
        this.maxHealth += hp;
        this.health = maxHealth;
    }

    public void takeDamage(int dmg) { this.health -= dmg; }
    public boolean isDead() { return health <= 0; }
    public void heal() {
        if (health < maxHealth / 2) health = maxHealth / 2;
    }

    public Inventory getInventory() { return inventory; }
    public int getStrength() { return strength; }
    public int getMana() { return mana; }
    public int getHealth() { return health; }
    public int getMaxHealth() { return maxHealth; }
}
