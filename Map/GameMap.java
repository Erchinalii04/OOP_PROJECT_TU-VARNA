package Map;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Represents the 2D character grid of the game world.
 * Loads the map from resources and provides rendering.
 */
public class GameMap {
    private char[][] grid;
    private int width;
    private int height;

    /**
     * Loads a map file from resources using classloader.
     *
     * @param fileName name of the resource (e.g. "level1.txt")
     */
    public void loadFromFile(String fileName) {
        try {
            InputStream in = getClass().getClassLoader().getResourceAsStream(fileName);
            if (in == null) {
                System.out.println("Error: resource file '" + fileName + "' not found.");
                return;
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder allLines = new StringBuilder();
            String line;
            int rowCount = 0;

            while ((line = reader.readLine()) != null) {
                allLines.append(line).append("\n");
                rowCount++;
            }

            String[] rows = allLines.toString().split("\n");
            height = rowCount;
            width = rows[0].length();
            grid = new char[height][width];

            for (int y = 0; y < height; y++) {
                char[] row = rows[y].toCharArray();
                for (int x = 0; x < width; x++) {
                    grid[y][x] = row[x];
                }
            }

        } catch (Exception e) {
            System.out.println("Error loading map: " + e.getMessage());
        }
    }

    public char getTile(int x, int y) {
        if (x < 0 || y < 0 || y >= height || x >= width) return '#';
        return grid[y][x];
    }

    public void print() {
        for (char[] row : grid) {
            for (char tile : row) {
                System.out.print(tile);
            }
            System.out.println();
        }
    }

    public void printWithHero(int heroX, int heroY) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (x == heroX && y == heroY) {
                    System.out.print('@');
                } else {
                    System.out.print(grid[y][x]);
                }
            }
            System.out.println();
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
