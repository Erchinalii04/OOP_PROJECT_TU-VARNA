

public class Hero {
    private String name;
    private Race race;
    private int strength;
    private int mana;
    private int health;
    private int maxHealth;
    private int level;
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

    public void levelUp(int strPoints, int manaPoints, int healthPoints) {
        this.level++;
        this.strength += strPoints;
        this.mana += manaPoints;
        this.maxHealth += healthPoints;
        this.health = this.maxHealth;
        System.out.println(name + " leveled up to level " + level + "!");
    }

    public void takeDamage(int dmg) {
        health -= dmg;
    }

    public void setHealth(int h) {
        health = Math.min(h, maxHealth);
    }

    public boolean isDead() {
        return health <= 0;
    }

    public void showStats() {
        System.out.println("[" + name + "] Lvl " + level + " (" + race + ")");
        System.out.println("Health: " + health + "/" + maxHealth);
        System.out.println("Strength: " + strength + ", Mana: " + mana);
        inventory.display();
    }

    // Getters
    public int getHealth() { return health; }
    public int getStrength() { return strength; }
    public int getMana() { return mana; }
    public int getMaxHealth() { return maxHealth; }
    public Inventory getInventory() { return inventory; }
}
