

public abstract class Item {
    protected String name;
    protected int bonus;

    public Item(String name, int bonus) {
        this.name = name;
        this.bonus = bonus;
    }

    public int getBonus() { return bonus; }
    public String getName() { return name; }
}
