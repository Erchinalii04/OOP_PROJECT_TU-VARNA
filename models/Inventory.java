package models;

public class Inventory {
    private int armorBonus = 0, weaponBonus = 20, spellBonus = 20;

    public void setArmorBonus(int val) { armorBonus = val; }
    public void setWeaponBonus(int val) { weaponBonus = val; }
    public void setSpellBonus(int val) { spellBonus = val; }

    public int getArmorBonus() { return armorBonus; }
    public int getWeaponBonus() { return weaponBonus; }
    public int getSpellBonus() { return spellBonus; }
}