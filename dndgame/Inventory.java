package dndgame;

public class Inventory {
    private Weapon weapon;
    private Armor armor;
    private Spell spell;

    public void equipWeapon(Weapon weapon) { this.weapon = weapon; }
    public void equipArmor(Armor armor) { this.armor = armor; }
    public void equipSpell(Spell spell) { this.spell = spell; }

    public Weapon getWeapon() { return weapon; }
    public Armor getArmor() { return armor; }
    public Spell getSpell() { return spell; }
}
