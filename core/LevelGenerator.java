package core;

import main.java.entities.Monster;
import main.java.items.*;
import main.java.map.GameMap;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Utility class for loading maps, treasures and monsters from resources.
 */
public class LevelGenerator {

    // Зарежда карта от ресурс
    public static GameMap loadLevel(int levelNumber) {
        GameMap map = new GameMap();
        map.loadFromFile("level" + levelNumber + ".txt");
        return map;
    }

    // Зарежда съкровища от ресурс
    public static Map<String, Item> loadTreasureItems(int levelNumber) {
        Map<String, Item> treasures = new HashMap<>();
        String fileName = "treasures_level" + levelNumber + ".txt";

        try {
            InputStream in = LevelGenerator.class.getClassLoader().getResourceAsStream(fileName);
            if (in == null) {
                System.out.println("Treasure file not found: " + fileName);
                return treasures;
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");
                if (parts.length != 4) continue;

                int x = Integer.parseInt(parts[0]);
                int y = Integer.parseInt(parts[1]);
                String type = parts[2].toLowerCase();
                double bonus = Double.parseDouble(parts[3]);

                Item item;

                switch (type) {
                    case "sword" -> item = new Weapon("Sword", bonus);
                    case "armor" -> item = new Armor("Armor", bonus);
                    case "spell" -> item = new Spell("Spell", bonus);
                    default -> item = new Weapon("Unknown", bonus);
                }

                String key = x + "_" + y;
                treasures.put(key, item);
            }

        } catch (Exception e) {
            System.out.println("Error loading treasures: " + e.getMessage());
        }

        return treasures;
    }

    // Зарежда чудовища от карта (където има 'M')
    public static Map<String, Monster> loadMonsters(GameMap map) {
        Map<String, Monster> monsters = new HashMap<>();

        for (int y = 0; y < map.getHeight(); y++) {
            for (int x = 0; x < map.getWidth(); x++) {
                if (map.getTile(x, y) == 'M') {
                    monsters.put(x + "_" + y, new Monster());
                }
            }
        }

        return monsters;
    }

    // Размер на карта за дадено ниво (по условие)
    public static int[] generateMapSize(int levelNumber) {
        if (levelNumber == 1) return new int[]{10, 10};
        if (levelNumber == 2) return new int[]{15, 10};

        int[] size1 = generateMapSize(levelNumber - 1);
        int[] size2 = generateMapSize(levelNumber - 2);
        return new int[]{
                size1[0] + size2[0],
                size1[1] + size2[1]
        };
    }

    // Брой чудовища и съкровища за дадено ниво (рекурсивно)
    public static int[] generateEntitiesCount(int levelNumber) {
        if (levelNumber == 1) return new int[]{2, 2};
        if (levelNumber == 2) return new int[]{3, 2};

        int[] prev1 = generateEntitiesCount(levelNumber - 1);
        int[] prev2 = generateEntitiesCount(levelNumber - 2);
        return new int[]{
                prev1[0] + prev2[0], // monsters
                prev1[1] + prev2[1]  // treasures
        };
    }
}
