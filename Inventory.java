
public class Inventory {
    private Weapon weapon;
    private Armor armor;
    private Spell spell;

    public void equipWeapon(Weapon w) {
        this.weapon = w;
    }

    public void equipArmor(Armor a) {
        this.armor = a;
    }

    public void equipSpell(Spell s) {
        this.spell = s;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public Spell getSpell() {
        return spell;
    }

    public void display() {
        System.out.println("Inventory:");
        System.out.println("Weapon: " + (weapon != null ? weapon.getName()
                + " +" + weapon.getBonus() + "%" : "None"));
        System.out.println("Armor: " + (armor != null ? armor.getName() + " +" + armor.getBonus()
                + "%" : "None"));
        System.out.println("Spell: " + (spell != null ? spell.getName()
                + " +" + spell.getBonus() + "%" : "None"));
    }
}
