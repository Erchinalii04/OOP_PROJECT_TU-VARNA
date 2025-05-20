package models;

public class GameMap {
    private final char[][] grid;
    public GameMap(char[][] g) { this.grid = g; }
    public char getAt(int x, int y) { return grid[x][y]; }
    public void setAt(int x, int y, char c) { grid[x][y] = c; }
    public int getWidth() { return grid[0].length; }
    public int getHeight() { return grid.length; }
    public void printMap() {
        for (char[] row : grid) {
            for (char c : row) System.out.print(c);
            System.out.println();
        }
    }
}