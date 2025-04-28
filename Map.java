
import java.util.Random;

public class Map {
    private char[][] grid;
    private int width;
    private int height;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new char[height][width];
        generateMaze();
    }

    private void generateMaze() {
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++)
                grid[i][j] = '.';

        grid[0][0] = 'P'; // Player
        grid[height - 1][width - 1] = 'E'; // Exit
    }

    public void placeObjects(int monsters, int treasures) {
        Random rand = new Random();
        int placedMonsters = 0, placedTreasures = 0;

        while (placedMonsters < monsters) {
            int x = rand.nextInt(height);
            int y = rand.nextInt(width);
            if (grid[x][y] == '.') {
                grid[x][y] = 'M';
                placedMonsters++;
            }
        }

        while (placedTreasures < treasures) {
            int x = rand.nextInt(height);
            int y = rand.nextInt(width);
            if (grid[x][y] == '.') {
                grid[x][y] = 'T';
                placedTreasures++;
            }
        }
    }

    public void printMap() {
        for (char[] row : grid) {
            for (char c : row)
                System.out.print(c + " ");
            System.out.println();
        }
    }

    public char[][] getGrid() {
        return grid;
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }
}
