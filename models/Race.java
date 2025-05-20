package models;


public enum Race {
    HUMAN(30, 20, 50), MAGE(10, 40, 50), WARRIOR(40, 10, 50);

    private final int str, mana, hp;
    Race(int s, int m, int h) {
        this.str = s; this.mana = m; this.hp = h;
    }
    public int getBaseStrength() { return str; }
    public int getBaseMana() { return mana; }
    public int getBaseHealth() { return hp; }
}