public class Item {
    private String type;
    private int value;
    private int level;


    public Item(String type, int value, int level) {
        this.type = type;
        this.value = value;
        this.level = level;
    }



    public String getType()
    { return type; }
    public int getValue()
    { return value; }
    public int getLevel()
    { return level; }
}
