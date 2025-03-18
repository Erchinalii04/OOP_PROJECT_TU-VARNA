public class Hero {
    private String race;
    private int strength;
    private int mana;
    private int health;
    private int level;
    private Item armor;
    private Item weapon;

    public String getRace()
    {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Item getArmor() {
        return armor;
    }

    public void setArmor(Item armor) {
        this.armor = armor;
    }

    public Item getWeapon() {
        return weapon;
    }

    public void setWeapon(Item weapon) {
        this.weapon = weapon;
    }

    public Item getSpell() {
        return spell;
    }

    public void setSpell(Item spell) {
        this.spell = spell;
    }

    private Item spell;

    public Hero(String race) {
        this.race = race;
        this.level = 1;
        if (race.equals("човек")) {
            this.strength = 30;
            this.mana = 20;
            this.health = 50;
        } else if (race.equals("маг")) {
            this.strength = 10;
            this.mana = 40;
            this.health = 50;
        } else if (race.equals("воин")) {
            this.strength = 40;
            this.mana = 10;
            this.health = 50;
        }
        this.weapon = new Item("оръжие", 20, 1);
        this.spell = new Item("заклинание", 20, 1);
    }

    public void levelUp() {
        this.level++;
        this.strength+=10;
        this.mana+=15;
        this.health+=5;
    }

    public void equipItem(Item item) {
        if (item.getType().equals("броня")) {
            this.armor = item;
        } else if (item.getType().equals("оръжие")) {
            this.weapon = item;
        } else if (item.getType().equals("заклинание")) {
            this.spell = item;
        }
    }
}

