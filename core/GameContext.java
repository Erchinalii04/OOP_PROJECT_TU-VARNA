package core;

import main.java.entities.Hero;
import main.java.entities.Monster;
import main.java.items.Item;
import main.java.map.GameMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Central game state shared between all commands.
 * Stores hero, map, level, monsters and treasures.
 */
public class GameContext {
    private Hero hero;
    private GameMap map;
    private int currentLevel = 1;

    private Map<String, Monster> monsters = new HashMap<>();
    private Map<String, Item> treasures = new HashMap<>();

    // Hero
    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    // Map
    public GameMap getMap() {
        return map;
    }

    public void setMap(GameMap map) {
        this.map = map;
    }

    // Level
    public int getCurrentLevel() {
        return currentLevel;
    }

    public void advanceLevel() {
        currentLevel++;
    }

    // Monsters
    public Map<String, Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(Map<String, Monster> monsters) {
        this.monsters = monsters;
    }

    // Treasures
    public Map<String, Item> getTreasures() {
        return treasures;
    }

    public void setTreasures(Map<String, Item> treasures) {
        this.treasures = treasures;
    }
}
